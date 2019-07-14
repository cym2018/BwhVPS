package xyz.cym2018.DAO;

import org.hibernate.Session;
import xyz.cym2018.Save;

public class MapDAO {
    private static Session session = Save.getSession();

    public static Map Query(int id) {
        return session.get(Map.class, id);
    }

    public static Map Query(String name) {
        return (Map) session.createQuery("from Map where name=" + name).uniqueResult();
    }

    public static void Save(Map map) {
        session.save(map);
        session.beginTransaction().commit();
    }

    public static void AddPlace(String name){
        Map map=new Map();
        map.setName(name);
        Save(map);
    }

    public static void DelPlace(Map map){
        session.delete(map);
        session.beginTransaction().commit();
    }

}
