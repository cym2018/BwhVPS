package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.CheckinDAO;
import xyz.cym2018.DAO.Worker;
import xyz.cym2018.DAO.WorkerDAO;

import java.util.Map;

public class W_CheckIn extends ActionSupport {
    @Override
    public String execute() throws Exception {
        Map session= ActionContext.getContext().getSession();
        int id=Integer.parseInt(session.get("UserId").toString());
        Worker worker=WorkerDAO.Query(id);
        if(worker==null){
            return "error";
        }
        if(worker.getState()==1) {
            worker.setState(0);
            WorkerDAO.Save(worker);
            CheckinDAO.CheckIn(id);
            return super.execute();
        }
        return "error";
    }
}
