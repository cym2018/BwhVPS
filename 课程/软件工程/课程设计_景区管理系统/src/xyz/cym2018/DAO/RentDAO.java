package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import xyz.cym2018.Save;

import java.sql.Date;
import java.sql.Time;

public class RentDAO {
    private static Session session = Save.getSession();

    public static void Save(int Shopid, int Userid) {

        Rent rent = new Rent(Shopid, Userid);
        Save(rent);
    }

    public static void Save(Rent rent) {
        session.save(rent);
        session.beginTransaction().commit();
    }

    public static void Cancel(int id) {
        Rent rent = session.get(Rent.class, id);
        rent.setTime(new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString());
        Save(rent);
    }
    public static Rent QueryByShop(int Shopid){
        Query query=session.createQuery("from Rent where shopid="+Shopid+" and time!=null");
        return (Rent) query.uniqueResult();
    }
    public static Rent QueryByUser(int Userid){
        Query query=session.createQuery("from Rent where userid="+Userid+" and time!=null");
        return (Rent) query.uniqueResult();
    }
}
