package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.BillDAO;
import xyz.cym2018.DAO.VisitorDAO;

import java.util.Map;

public class V_TicketBuy extends ActionSupport {
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String execute() throws Exception {
        float money;
        switch (type) {
            case 2:
                money = 45;
                break;
            case 3:
                money = 30;
                break;
            default:
                money = 60;
        }
        // 生成票务信息
        int id = VisitorDAO.Sell(money);
        // 记录账单
        BillDAO.Save("购票", money);
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("id", id);
        return super.execute();
    }
}
