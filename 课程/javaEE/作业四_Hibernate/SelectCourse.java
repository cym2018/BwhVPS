package xyz.cym2018.DAO;

public class SelectCourse {
    private int id;
    private int userid;
    private int courseid;
    private Login login;
    private CoutseList coutseList;
    public SelectCourse() {
    }

    public SelectCourse(int userid, int courseid) {
        this.userid = userid;
        this.courseid = courseid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
