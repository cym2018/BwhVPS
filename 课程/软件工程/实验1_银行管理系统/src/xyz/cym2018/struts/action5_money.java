package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.MysqlHelper;

public class action5_money extends ActionSupport {
    int state;
    float amount;

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String execute() throws Exception {
        String card_id = ActionContext.getContext().getSession().get("card_id").toString();
        if (card_id == null)
            return "login";
        if (state == 1) {
            MysqlHelper.Money(card_id, amount);
            return "success";
        }
        if (MysqlHelper.GetBalance(card_id) - amount >= 0) {
            amount = 0 - amount;
            MysqlHelper.Money(card_id, amount);
            return "success";
        }
        addFieldError("amount","余额不足");
        return "error";
        // 取钱
    }
}
