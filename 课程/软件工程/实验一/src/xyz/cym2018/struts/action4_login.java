package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.MysqlHelper;

public class action4_login extends ActionSupport {
    private String card_id;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    @Override
    public String execute() throws Exception {
        ActionContext.getContext().getSession().put("card_id", card_id);
        return super.execute();
    }

    @Override
    public void validate() {
        System.out.println(password.length() == 6);
        System.out.println(MysqlHelper.Login(card_id, password));
        if (!(password.length() == 6 && MysqlHelper.Login(card_id, password)))
            addFieldError("card_id", "卡号或密码错误");
    }
}
