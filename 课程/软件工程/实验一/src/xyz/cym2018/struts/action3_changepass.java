package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.MysqlHelper;

public class action3_changepass extends ActionSupport {
    private String card_id;
    private String password;
    private String password1;
    public void setPassword(String password) {this.password = password; }
    public void setPassword1(String password1) { this.password1 = password1; }
    public void setCard_id(String card_id) { this.card_id = card_id; }

    @Override
    public String execute() throws Exception {
        if (MysqlHelper.Login(card_id,password)){
            MysqlHelper.ChangePassword(card_id,password1);
            return super.execute();
        }
        addFieldError("card_id","原密码不正确");
        return "input";
    }

    @Override
    public void validate() {
        if(password1.length()!=6)
            addFieldError("password1","密码必须为6位");
        super.validate();
    }
}
