package xyz.cym2018;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Save {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static Session getSession() {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    private static final ThreadLocal<ApplicationContext> threadLocal1 = new ThreadLocal<>();

    public static ApplicationContext GetApplicationContext() {
        ApplicationContext context = threadLocal1.get();
        if (context == null) {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            threadLocal1.set(context);
        }
        return context;
    }

}
