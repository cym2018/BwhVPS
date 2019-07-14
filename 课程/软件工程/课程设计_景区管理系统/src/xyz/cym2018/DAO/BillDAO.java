package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import xyz.cym2018.Save;

import java.util.List;

public class BillDAO {
    private static Session session = Save.getSession();

    public static Bill Query(int id) {
        return session.get(Bill.class, id);
    }

    public static void Save(Bill bill) {
        session.save(bill);
        session.beginTransaction().commit();
    }

    public static void Save(String Type, float money) {
        Bill bill = new Bill(Type, money);
        Save(bill);
    }

    public static float QueryLastBalance(int day) {
        Query query = session.createSQLQuery("select sum(money) from bill where date_sub(curdate(), interval " + day + " day) <= date(time)");
        return Float.parseFloat(query.uniqueResult().toString());
    }

    public static float QueryLastIncome(int day) {
        Query query = session.createSQLQuery("select sum(money) from bill where date_sub(curdate(), interval " + day + " day) <= date(time) and money>0");
        if (query == null)
            return 0;
        return Float.parseFloat(query.uniqueResult().toString());
    }

    public static float QueryLastSpend(int day) {
        Query query = session.createSQLQuery("select sum(money) from bill where date_sub(curdate(), interval " + day + " day) <= date(time) and money<0");
        Object object=query.uniqueResult();
        if (object == null)
            return 0;
        return Float.parseFloat(object.toString());
    }

    public static List QueryBetween(String startTime, String endTime) {
        Query query = session.createQuery("from Bill where time<" + startTime + " and  time >" + endTime);
        return query.getResultList();
    }
    public static List QueryAll(){
        Query query = session.createQuery("from Bill");
        return query.getResultList();
    }
    public static void main(String[] args) {
    }


}