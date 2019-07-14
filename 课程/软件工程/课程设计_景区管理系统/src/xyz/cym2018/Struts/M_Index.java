package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.BillDAO;
import xyz.cym2018.DAO.Visitor;
import xyz.cym2018.DAO.VisitorDAO;

import java.util.Map;

public class M_Index extends ActionSupport {
    @Override
    public String execute() throws Exception {
        Visitor visitor = new Visitor();
        int V30 = VisitorDAO.NumberOfVisitor(30),
                V1 = VisitorDAO.NumberOfVisitor(1),
                V0 = VisitorDAO.NumberOfVisitor();
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("V30", V30);
        request.put("V1", V1);
        request.put("V0", V0);
        request.put("balance30", BillDAO.QueryLastBalance(30));
        request.put("balance1", BillDAO.QueryLastBalance(1));
        request.put("income30", BillDAO.QueryLastIncome(30));
        request.put("income1", BillDAO.QueryLastIncome(1));
        request.put("spend30", BillDAO.QueryLastSpend(30));
        request.put("spend1", BillDAO.QueryLastSpend(1));
        return super.execute();
    }
}
