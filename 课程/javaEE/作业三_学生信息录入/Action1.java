package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.*;
import java.util.Date;
import java.util.List;
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

    Date birthday;
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    private String note;
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    private List<File> upload;
    public List<File> getUpload() { return upload; }
    public void setUpload(List<File> upload) { this.upload = upload; }

    private List<String> uploadFileName;
    public List<String> getUploadFileName() { return uploadFileName; }
    public void setUploadFileName(List<String> uploadFileName) { this.uploadFileName = uploadFileName; }

    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }


    @Override
    public String execute() throws Exception {
        setPassword(uploadFileName.get(0));
        Map request= (Map) ActionContext.getContext().get("request");
        request.put("username",username);
        request.put("name", name);
        request.put("major",major);
        request.put("note",note);
        request.put("gender",gender==1?"男":"女");
        request.put("birthday", birthday);
        MysqlOperate.SaveStudentInfo(this);
        SaveFile();
        return SUCCESS;
    }

    void SaveFile() throws Exception{
        for(int i=0;i<upload.size();i++){
            InputStream is = new FileInputStream(upload.get(i));
            int index=uploadFileName.get(i).lastIndexOf(".");
            OutputStream os = new FileOutputStream("C:\\Users\\cym20\\Saved Games\\Files\\save\\" + username+i+uploadFileName.get(i).substring(index));
            byte buffer[] = new byte[1024];
            int count = 0;
            while ((count = is.read(buffer)) > 0) { os.write(buffer, 0, count); }
            os.close();
            is.close();
        }

    }
}
