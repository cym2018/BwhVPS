package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.LoginDAO;

public class Action2_Reg extends ActionSupport {
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
    public String execute(){
        // 检测用户名是否重复
        if(LoginDAO.isUsernameRepeat(username)){
            addFieldError("username","用户名已存在");
            return INPUT;
        }
        // 构造Login对象
        // 获取userid
        // 传回参数
        Login login = new Login(username, password);
        int userid=LoginDAO.SaveLogin(login);
        if (userid!=0){
            java.util.Map request = (java.util.Map) ActionContext.getContext().get("request");
            request.put("username",username);
            request.put("password",password);
            request.put("userid",userid);
            return SUCCESS;
        }
        return ERROR;
    }
}
