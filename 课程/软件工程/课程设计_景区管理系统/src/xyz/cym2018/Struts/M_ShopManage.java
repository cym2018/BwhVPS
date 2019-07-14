package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.Shop;
import xyz.cym2018.DAO.ShopDAO;

import java.util.Map;

public class M_ShopManage extends ActionSupport {
    private int selectid;
    public void setSelectid(int selectid) {
        this.selectid = selectid;
    }

    @Override
    public String execute() throws Exception {
        Shop shop=ShopDAO.Query(selectid);
        Map request= (Map) ActionContext.getContext().get("request");
        request.put("shop",shop);
        Map session=ActionContext.getContext().getSession();
        session.put("shopid",selectid);
        return super.execute();
    }
}
