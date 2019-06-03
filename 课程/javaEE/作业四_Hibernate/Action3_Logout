package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class Action3_Logout extends ActionSupport {
    @Override
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        session.remove("userid");
        return super.execute();
    }
}
