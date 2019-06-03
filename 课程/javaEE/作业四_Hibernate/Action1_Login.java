package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.LoginDAO;

import java.util.Map;


public class Action1_Login extends ActionSupport {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() {
        Login login = new Login(username, password);
        int id = LoginDAO.loginResult(login);
        if (id == 0) {
            addFieldError("username", "用户名或密码不正确");
            return INPUT;
        } else {
            // 传入下一个页面
            Map request = (Map) ActionContext.getContext().get("request");
            request.put("id", id);
            // 写入session
            Map session = (Map) ActionContext.getContext().get("session");
            session.put("userid", "" + id);
            return SUCCESS;
        }
    }
}
