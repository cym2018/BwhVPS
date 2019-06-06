package xyz.cym2018.struts;

import xyz.cym2018.DAO.CoutseList;
import xyz.cym2018.DAO.SelectCourseDAO;

public class CourseInfo {
    private String coursename, semester, button;
    private int studyhour, credits, id;

    CourseInfo(CoutseList coutseList, int userid) {
        id = coutseList.getId();
        coursename = coutseList.getCoursename();
        semester = coutseList.getSemester();
        studyhour = coutseList.getStudyhour();
        credits = coutseList.getCredits();
        button=(SelectCourseDAO.isSelect(userid, id) ?null:"未选");
    }
    public int getId() {
        return id;
    }
    public int getStudyhour() {
        return studyhour;
    }
    public int getCredits() {
        return credits;
    }
    public String getButton() {
        return button;
    }
    public String getCoursename() {
        return coursename;
    }
    public String getSemester() {
        return semester;
    }
}
