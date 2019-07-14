package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.User;
import xyz.cym2018.DAO.UserDAO;

import java.util.Map;

public class A_Login extends ActionSupport {
    private String Username,Password;

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String execute() throws Exception {
        User user=UserDAO.Login(Username,Password);
        if(user!=null){
            // 如果登陆成功,记录用户id和用户类型
            Map session= ActionContext.getContext().getSession();
            session.put("UserId",user.getId());
            session.put("UserType",user.getType());
            // 根据用户类型确定跳转页面
            return user.getType();
        }
        addFieldError("username","用户名或密码错误");
        return "input";
    }
}
