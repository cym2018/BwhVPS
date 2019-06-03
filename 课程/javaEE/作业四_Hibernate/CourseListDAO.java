package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static xyz.cym2018.DAO.GetSession.getSession;

public class CourseListDAO {
    public static List getList(){
        Session session=getSession();
        Query query= session.createQuery("from CoutseList ");
        List ret=query.getResultList();
        session.close();
        return ret;
    }
    public static CoutseList getACourse(int coutseid){
        Session session=getSession();
        Query query= session.createQuery("from CoutseList where id=?0");
        query.setParameter(0,coutseid);
        List ret=query.getResultList();
        session.close();
        return (CoutseList) ret.get(0);
    }
}
