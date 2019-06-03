package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class GetSession {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session getSession() {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
            session =sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
}
