package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LoginDAO {
    // 将注册信息存入数据库
    public static int SaveLogin(Login login) {
        // 检测重复
        if (isUsernameRepeat(login.getUsername()))
            return 0;
        Session session = GetSession.getSession();
        session.save(login);
        int id=loginResult(login);
        session.close();
        return id;
    }

    // 检测用户名是否重复
    public static boolean isUsernameRepeat(String username) {
        Session session = GetSession.getSession();
        Query query = session.createQuery("from Login where username=?0");
        query.setParameter(0, username);
        query.setMaxResults(1);
        List ret = query.getResultList();
        return ret.size() > 0;
    }

    // 获取用户id
    public static int loginResult(Login login) {
        Session session = GetSession.getSession();
        Query query = session.createQuery("from Login where username=?0 and password=?1");
        query.setMaxResults(1);
        query.setParameter(0, login.getUsername());
        query.setParameter(1, login.getPassword());
        List ret = query.getResultList();
        if(ret.size() > 0){
            return ((Login)ret.get(0)).getId();
        }
        return 0;
    }
}
