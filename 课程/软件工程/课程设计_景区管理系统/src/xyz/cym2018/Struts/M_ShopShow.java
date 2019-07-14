package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.ShopDAO;

import java.util.List;
import java.util.Map;

public class M_ShopShow extends ActionSupport {
    @Override
    public String execute() throws Exception {
        List ret = ShopDAO.QueryAll();
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("list", ret);
        return super.execute();
    }
}
