package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.CourseListDAO;
import xyz.cym2018.DAO.CoutseList;
import xyz.cym2018.DAO.SelectCourseDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Action5_SelectCourse extends ActionSupport {
    private String selectid;
    private int userid;

    public String getSelectid() {
        return selectid;
    }

    public void setSelectid(String selectid) {
        this.selectid = selectid;
    }

    @Override
    public String execute() throws Exception {
        // 检测是否登录
        Map session = (Map) ActionContext.getContext().get("session");
        if (session.get("userid") == null) {
            addFieldError("username", "请先登录");
            return LOGIN;
        }
        userid = Integer.parseInt(session.get("userid").toString());
        // 选课,退选
        if (selectid != null) {
            int courseid = Integer.parseInt(selectid);
            SelectCourseDAO.ChangeState(userid, courseid);
        }
        // 返回数据
        List ret = getRet(CourseListDAO.getList());
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("list", ret);
        return super.execute();
    }

    private List getRet(List list) {
        List<CourseInfo> ret = new ArrayList<>();
        for (Object o : list) {
            CourseInfo temp = new CourseInfo((CoutseList) o, userid);
            ret.add(temp);
        }
        return ret;
    }
}
