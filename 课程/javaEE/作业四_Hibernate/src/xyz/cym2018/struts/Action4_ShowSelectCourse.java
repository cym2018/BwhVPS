package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.CourseListDAO;
import xyz.cym2018.DAO.CoutseList;
import xyz.cym2018.DAO.SelectCourse;
import xyz.cym2018.DAO.SelectCourseDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Action4_ShowSelectCourse extends ActionSupport {

    @Override
    public String execute() {
        // 检测是否登录
        int userid;
        Map session = (Map) ActionContext.getContext().get("session");
        if (session.get("userid") == null) {
            addFieldError("username", "请先登录");
            return LOGIN;
        }
        userid = Integer.parseInt(session.get("userid").toString());
        List<SelectCourse> list = SelectCourseDAO.GetSelectCourse(userid);
        List<CoutseList> ret=new ArrayList<>();
        for (SelectCourse selectCourse : list) {
            CoutseList coutseList = CourseListDAO.getACourse(selectCourse.getCourseid());
            ret.add(coutseList);
        }
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("list", ret);
        return SUCCESS;
    }
}
