package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.BillDAO;
import xyz.cym2018.DAO.Visitor;
import xyz.cym2018.DAO.VisitorDAO;

import java.util.Map;

public class V_TicketOperate extends ActionSupport {
    private int operate;

    public void setOperate(int operate) {
        this.operate = operate;
    }

    @Override
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().getSession();
        int id = (Integer) session.get("visitorid");
        boolean ret;
        switch (operate) {
            case 1:
                // 入场
                ret = VisitorDAO.In(id);
                break;
            case 2:
                Visitor visitor = VisitorDAO.Query(id);
                // 退票
                ret = VisitorDAO.Back(id);
                if (ret) {
                    // 记录账单
                    BillDAO.Save("退票", 0 - visitor.getPrice());
                }
                break;
            default:
                // 离场
                ret = VisitorDAO.Out(id);
        }
        return ret ? "success" : "error";
    }
}
