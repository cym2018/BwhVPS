package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import xyz.cym2018.Save;

import java.util.List;

public class ShopDAO {
    private static Session session = Save.getSession();

    public static Shop Query(int id) {
        return session.get(Shop.class, id);
    }

    public static Shop Query(String name) {
        return (Shop) session.createQuery("from Shop where name=" + name).uniqueResult();
    }

    public static void Save(Shop shop) {
        session.save(shop);
        session.beginTransaction().commit();
    }

    public static List QueryAll() {
        Query query = session.createQuery("from Shop");
        return query.getResultList();
    }

}
