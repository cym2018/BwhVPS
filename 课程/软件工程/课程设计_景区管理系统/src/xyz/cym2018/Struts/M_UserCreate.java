package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.UserDAO;

import java.util.Map;

public class M_UserCreate extends ActionSupport {
    private String username;
    private String password;
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() throws Exception {
        // 判断用户名是否存在
        if (UserDAO.Query(username) != null) {
            addFieldError("username", "用户名已存在");
            return "input";
        }
        // 如果添加员工,进入填写员工信息页
        if (type == 2) {
            Map session = ActionContext.getContext().getSession();
            session.put("username", username);
            session.put("password", password);
            return "worker";
        }
        // 执行添加用户操作
        if (type == 1) {
            UserDAO.CreateUser(username, password, "管理");
        } else {
            UserDAO.CreateUser(username, password, "商户");
        }
        return super.execute();
    }
}
