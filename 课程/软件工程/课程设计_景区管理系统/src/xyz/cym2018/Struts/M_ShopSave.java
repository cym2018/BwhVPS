package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.*;

import java.util.Map;

public class M_ShopSave extends ActionSupport {

    private String name;
    private String username;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String execute() throws Exception {
        Map session= ActionContext.getContext().getSession();
        int shopid=Integer.parseInt(session.get("shopid").toString());
        User user = UserDAO.Query(username);
        // 保存租赁关系
        System.out.println("用户是否存在");
        if (user != null) {// 用户存在
            int userid=user.getId();
            System.out.println("用户类型");
            if (user.getType().equals("商户")) {// 用户属于商户
                System.out.println("店铺状态");
                if (RentDAO.QueryByShop(shopid)==null){// 店铺未被租用
                    // 存储信息
                    RentDAO.Save(shopid,userid);
                    // 修改名字
                    Shop shop=ShopDAO.Query(shopid);
                    shop.setName(name);
                    shop.setState(0);
                    ShopDAO.Save(shop);
                    return "success";
                }
            }
        }

        return "error";
    }
}
