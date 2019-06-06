package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.MysqlHelper;

import java.util.Map;

public class action6_viewinfo extends ActionSupport {
    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String card_id = (String) session.get("card_id");
        if (card_id == null)
            return "login";
        session.put("balance",MysqlHelper.GetBalance(card_id));
        session.put("name",MysqlHelper.GetName(card_id));
        return super.execute();
    }
}
