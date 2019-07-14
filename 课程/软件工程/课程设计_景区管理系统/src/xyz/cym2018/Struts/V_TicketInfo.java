package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.Visitor;
import xyz.cym2018.DAO.VisitorDAO;

import java.util.Map;

public class V_TicketInfo extends ActionSupport {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        Visitor visitor = VisitorDAO.Query(id);
        Map request = (Map) ActionContext.getContext().get("request");
        Map session = ActionContext.getContext().getSession();
        request.put("ticket", visitor);
        session.put("visitorid", visitor.getId());
        return super.execute();
    }
}
