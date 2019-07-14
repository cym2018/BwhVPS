package xyz.cym2018.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import xyz.cym2018.Save;

import java.util.List;

public class NearDAO {
    private static Session session = Save.getSession();

    static int[] GetDistance(int id) {
        Query query = session.createSQLQuery("select count(*) from map");
        int max = Integer.parseInt(query.uniqueResult().toString()) + 1;
        int[] dis = new int[max];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = -1;
        }
        dis[id] = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (dis[j] == i) {
                    int[] near = GetNear(j);
                    for (int k = 0; k < near.length; k++) {
                        if (dis[near[k]] == -1) {
                            dis[near[k]] = i + 1;
                        }
                    }
                }
            }
        }
        return dis;
    }

    static int[] GetNear(int id) {
        Query query1 = session.createQuery("from Near where id1=" + id);
        List ret1 = query1.getResultList();
        Query query2 = session.createQuery("from Near where id2=" + id);
        List ret2 = query2.getResultList();
        int[] ret = new int[ret1.size() + ret2.size()];
        for (int i = 0; i < ret2.size(); i++) {
            ret[i] = ((Near) ret2.get(i)).getId1();
        }
        for (int i = ret2.size(); i < ret2.size() + ret1.size(); i++) {
            ret[i] = ((Near) ret1.get(i - ret2.size())).getId2();
        }
        return ret;
    }
    static int[] StartToEnd(int start,int end){
        int[] a=GetDistance(start);
        int[] b=GetDistance(end);
        for(int i=1;i<a.length;i++){
            if(a[i]+b[i]!=a[end]){
                a[i]=-1;
            }
        }
        return a;
    }
    // 输入起点和终点的id
    public static void main(String[] args) {
        int[] a = StartToEnd(6,3);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}
