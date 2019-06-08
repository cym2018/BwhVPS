package xyz.cym2018.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xyz.cym2018.DAO.MysqlHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class action7_viewhistory extends ActionSupport {
    class HistoryInfo {
        private String type, operate, amount,object;

        HistoryInfo(String type, String operate, String amount,String object) {
            this.amount = amount;
            this.operate = operate;
            this.type = type;
            this.object=object;
        }

        public String getObject() {
            return object;
        }

        public String getAmount() {
            return amount;
        }

        public String getOperate() {
            return operate;
        }

        public String getType() {
            return type;
        }
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String card_id = (String) session.get("card_id");
        if (card_id == null)
            return "login";
        ResultSet resultSet = MysqlHelper.QueryHistory(card_id);
        List<HistoryInfo> list = new ArrayList<>();
        while (resultSet.next()) {
            String type, operate, amount,object;
            amount = resultSet.getString("amount");
            type = resultSet.getInt("to_id") == 0 ? "现金交易" : "转账";
            operate = resultSet.getInt("to_id") == 0 ?
                    (resultSet.getFloat("amount") > 0 ? "存钱" : "取钱") :
                    (resultSet.getFloat("amount") > 0 ? "汇入" : "汇出");
            object=resultSet.getInt("to_id") == 0?"":MysqlHelper.GetCardId(resultSet.getInt("to_id"));
            HistoryInfo historyInfo = new HistoryInfo(type, operate, amount,object);
            list.add(historyInfo);
        }
        session.put("list",list);
        return super.execute();
    }
}
