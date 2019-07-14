package xyz.cym2018.old;

import java.sql.SQLException;
public interface I_Visitor {
    enum state {购票,入场,离场,失效,退票}
    // 查询购票信息
    void Query(int id) throws SQLException;
    // 购票
    boolean Buy(float amount) throws SQLException;
    // 入场
    boolean In(int id) throws SQLException;
    // 出场
    boolean Out(int id) throws SQLException;
    // 退票
    boolean Back(int id) throws SQLException;
    // 获取状态
    state GetState(int id) throws SQLException;

    // 关闭景区,当前未入场的票作废
    void Close();
}
