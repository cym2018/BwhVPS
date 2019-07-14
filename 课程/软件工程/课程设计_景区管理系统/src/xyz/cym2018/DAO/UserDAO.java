package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import xyz.cym2018.Save;

import java.util.List;

public class UserDAO {
    private static Session session = Save.getSession();

    public static User Query(int id) {
        return session.get(User.class, id);
    }

    public static User Query(String Username) {
        System.out.println(Username);
        Query query=session.createQuery("from User where username=?1");
        query.setParameter(1,Username);
        List ret=query.getResultList();
        //.getResultList();
        return ret.size()==1? (User) ret.get(0) :null;
    }

    public static void Save(User user) {
        session.save(user);
        session.beginTransaction().commit();
    }

    public static int CreateUser(String Username, String Password, String Type) {
        User user = new User(Username, Password, Type);
        Save(user);
        return user.getId();

    }

    public static User Login(String Username, String Password) {
        Query query = session.createQuery("from User where username=?1 and password=?2");
        query.setParameter(1, Username);
        query.setParameter(2, Password);
        User user = (User) query.uniqueResult();
        return user;
    }
}
