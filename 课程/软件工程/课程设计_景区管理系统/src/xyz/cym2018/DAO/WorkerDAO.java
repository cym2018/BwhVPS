package xyz.cym2018.DAO;

import org.hibernate.Session;
import xyz.cym2018.Save;

public class WorkerDAO {
    enum Em_State {在岗, 休假, 离岗, 旷工, 离职;}

    private static Session session = Save.getSession();

    public static Worker Query(int id) {
        return session.get(Worker.class, id);
    }

    public static void Save(Worker worker) {
        session.save(worker);
        session.beginTransaction().commit();
    }

    public static boolean CreateWorker(int Id, String Name, float Salary, String Work) {
        Worker worker=Query(Id);
        if (worker==null) {
            worker = new Worker(Id, Name, Salary, Work);
            Save(worker);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
