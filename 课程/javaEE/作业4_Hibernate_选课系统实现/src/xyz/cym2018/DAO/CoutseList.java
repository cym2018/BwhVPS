package xyz.cym2018.DAO;

public class CoutseList {
    private Integer id;
    private String coursename;
    private String semester;
    private Integer studyhour;
    private Integer credits;

    public CoutseList() {
    }

    public CoutseList(String coursename, String semester, int studyhour, int credits) {
        this.coursename = coursename;
        this.semester = semester;
        this.studyhour = studyhour;
        this.credits = credits;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getStudyhour() {
        return studyhour;
    }

    public void setStudyhour(Integer studyhour) {
        this.studyhour = studyhour;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
