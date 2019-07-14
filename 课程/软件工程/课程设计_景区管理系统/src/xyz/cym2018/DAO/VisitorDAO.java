package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import xyz.cym2018.Save;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class VisitorDAO {
    enum state {购票, 入场, 离场, 失效, 退票}


    private static Session session = Save.getSession();

    public static Visitor Query(int id) {
        return session.get(Visitor.class, id);
    }

    public static void Save(Visitor visitor) {
        session.save(visitor);
        session.beginTransaction().commit();
    }

    public static int Sell(float price) {
        Visitor visitor = new Visitor();
        visitor.setPrice(price);
        visitor.setBuy_time(new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString());
        Save(visitor);
        Query query = session.createQuery("from Visitor order by id desc ");
        query.setMaxResults(1);
        return ((Visitor) query.uniqueResult()).getId();
    }

    public static boolean In(int id) {
        Visitor visitor = Query(id);
        if (visitor.getState() == 0) {
            visitor.setIn_time(new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString());
            visitor.setState(1);
            Save(visitor);
            return true;
        } else {
            return false;
        }
    }

    public static boolean Out(int id) {
        Visitor visitor = Query(id);
        if (visitor.getState() == 1) {
            visitor.setOut_time(new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString());
            visitor.setState(2);
            Save(visitor);
            return true;
        } else {
            return false;
        }
    }

    public static boolean Back(int id) {
        Visitor visitor = Query(id);
        if (visitor.getState() == 0) {
            visitor.setOut_time(new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString());
            visitor.setState(4);
            Save(visitor);
            return true;
        } else {
            return false;
        }
    }

    public static void Invalid() {
        Query query = session.createQuery("from Visitor where state=0");
        List list = query.getResultList();
        for (Object o : list) {
            Visitor temp = (Visitor) o;
            temp.setOut_time(new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString());
            temp.setState(3);
            Save(temp);
        }
    }

    public static int NumberOfVisitor(int day) {
        Query query = session.createSQLQuery("select count(*) from Visitor where date_sub(curdate(), interval " + day + " day) <= date(out_time)");
        return Integer.parseInt(query.uniqueResult().toString());
    }

    public static int NumberOfVisitor() {
        Query query = session.createSQLQuery("select count(*) from Visitor where state=1");
        return Integer.parseInt(query.uniqueResult().toString());
    }

    public static void main(String[] args) {
        Visitor v = VisitorDAO.Query(21);

        System.out.println(v.getBuy_time() + v.getState());
        ;
    }
}
