package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.MysqlHelper;

public class action1_reg extends ActionSupport {
    private String card_id;
    private String name;
    private String id_number;
    private String phone_number;
    private String password;
    public void setCard_id(String card_id) { this.card_id = card_id; }
    public void setId_number(String id_number) { this.id_number = id_number; }
    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    @Override
    public String execute() throws Exception {
        MysqlHelper.CreateAccount(card_id,name,id_number,phone_number,password);
        return super.execute();
    }

    @Override
    public void validate() {
        if(phone_number==null)
            phone_number="";
        if (MysqlHelper.GetID(card_id)!=0)
            addFieldError("card_id","卡号已存在");
        if(card_id==null||card_id.equals(""))
            addFieldError("card_id","卡号不能为空");
        if(name==null||name.length()>10)
            addFieldError("name","姓名格式不正确");
        if(id_number==null||id_number.length()!=18)
            addFieldError("id_number","身份证号格式错误");
        if(password==null||password.length()!=6)
            addFieldError("password","密码格式必须为六位");
        super.validate();
    }
    // String card_id, String name, String id_number, String phone_number, String password) {


}
