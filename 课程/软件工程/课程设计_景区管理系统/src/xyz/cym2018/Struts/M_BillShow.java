package xyz.cym2018.Struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.BillDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class M_BillShow extends ActionSupport {
    private String StartTime, EndTime;

    public void setEndTime(String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(endTime);
            SimpleDateFormat ssdf = new SimpleDateFormat("yyyyMMdd");
            EndTime = ssdf.format(date)+"000000";
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setStartTime(String startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(startTime);
            SimpleDateFormat ssdf = new SimpleDateFormat("yyyyMMdd");
            StartTime = ssdf.format(date)+"235959";
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String execute() throws Exception {
        List ret = BillDAO.QueryAll();
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("list", ret);
        return super.execute();
    }
}
