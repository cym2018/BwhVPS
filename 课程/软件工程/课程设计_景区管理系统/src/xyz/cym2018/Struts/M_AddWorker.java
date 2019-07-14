package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.UserDAO;
import xyz.cym2018.DAO.WorkerDAO;

import java.util.Map;

public class M_AddWorker extends ActionSupport {
    private String name;
    private float salary;
    private String work;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String username = session.get("username").toString();
        String password = session.get("password").toString();
        session.remove("username");
        session.remove("password");
        int id = UserDAO.CreateUser(username, password, "员工");
        if (WorkerDAO.CreateWorker(id, name, salary, work)) {
            return "success";
        }
        return "error";
    }
}
