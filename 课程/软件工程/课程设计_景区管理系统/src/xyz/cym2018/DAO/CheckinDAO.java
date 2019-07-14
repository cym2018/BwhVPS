package xyz.cym2018.DAO;

import org.hibernate.Session;
import xyz.cym2018.Save;

public class CheckinDAO {
    enum type{签到,签退};
    private static Session session = Save.getSession();
    public static void CheckIn(int Userid){
        Checkin checkin=new Checkin(Userid,0);
        session.save(checkin);
    }
    public static void CheckOut(int Userid){
        Checkin checkin=new Checkin(Userid,1);
        session.save(checkin);
    }
}
