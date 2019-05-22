package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;

public class Action1 extends ActionSupport {
    private String username;
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private int gender;
    public int getGender() { return gender; }
    public void setGender(int gender) { this.gender = gender; }

    private String major;
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    private Date birthday;
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    private String note;
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    Action1(){ username="";name="";gender=0;major="";birthday =new Date(0);note=""; }

    @Override
    public String execute() throws Exception {
        Map request= (Map) ActionContext.getContext().get("request");
        request.put("username",username);
        request.put("name", name);
        request.put("major",major);
        request.put("note",note);
        request.put("gender",gender==1?"男":"女");
        request.put("birthday", birthday);
        MysqlOperate.SaveStudentInfo(this);
        return SUCCESS;
    }
}
