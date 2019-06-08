package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.MysqlHelper;

public class action2_cancel extends ActionSupport {
    private String card_id;
    private String name;
    private String id_number;
    private String password;
    public void setCard_id(String card_id) { this.card_id = card_id; }
    public void setId_number(String id_number) { this.id_number = id_number; }
    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String execute() throws Exception {
        if(MysqlHelper.DeleteAccount(card_id,name,id_number,password))
            return super.execute();
        else addFieldError("name","信息错误或账户余额不为0");
        return "input";
    }

    @Override
    public void validate() {
        if(card_id==null||name==null||id_number==null||password==null)
            addFieldError("name","请填写全部信息");
        super.validate();
    }
}
