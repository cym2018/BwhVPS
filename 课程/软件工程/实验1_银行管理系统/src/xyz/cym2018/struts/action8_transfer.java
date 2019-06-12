package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.MysqlHelper;

import java.lang.reflect.Field;
import java.util.Map;

public class action8_transfer extends ActionSupport {
    private String password;
    private String strName, strCard_id;
    private float amount;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStrCard_id(String strCard_id) {
        this.strCard_id = strCard_id;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String card_id = (String) session.get("card_id");
        if (card_id == null)
            return "login";
        if (MysqlHelper.Login(card_id, password)) {
            if (MysqlHelper.GetBalance(card_id) - amount < 0) {
                addFieldError("strName", "余额不足");
                return "input";
            }
            //可以转账
            MysqlHelper.Transfer(card_id, strCard_id, amount);
            return "success";
        }
        addFieldError("strName", "信息错误");
        return "input";
    }

    @Override
    public void validate() {
        if (strName == null || password == null || strCard_id == null) {
            addFieldError("strName", "输入有误,请检查后继续");
            return;
        } else if (strName.length() == 0 || !MysqlHelper.TransferOB(strCard_id, strName)) {
            addFieldError("strName", "输入有误,请检查后继续");
        } else if (amount <= 0) {
            addFieldError("strName", "转账金额必须大于零");
        }
        super.validate();
    }
}
