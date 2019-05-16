package xyz.cym2018.struts.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;

public class Action1 extends ActionSupport {
    private String username, name, major, note;
    private int gender;
    private Date birthdate;

    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }
    public void setGender(int gender) { this.gender = gender; }
    public void setNote(String note) { this.note = note; }
    public void setMajor(String major) { this.major = major; }
    public void setUsername(String username) { this.username = username; }
    public void setName(String name) { this.name = name; }
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("username",username);
        request.put("name", name);
        request.put("major",major);
        request.put("note",note);
        request.put("gender",gender==1?"男":"女");
        request.put("birthdate",birthdate);
        return "success";
    }
}
