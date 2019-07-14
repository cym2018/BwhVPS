package xyz.cym2018.old;

import java.sql.SQLException;

//	0: 在岗:正常工作
//	1: 休假:正常假期/下班,带工资
//	2: 离岗:请假,无工资
//	3: 旷工:扣工资
//	4: 离职:


public interface I_Employees {
    enum Em_State {在岗, 休假, 离岗, 旷工, 离职;}

    // 新建用户
    boolean CreateUser(

    ) throws SQLException;

    // 调整工资
    boolean ChangeSalary(float salary) throws SQLException;

    // 调整岗位
    boolean ChangePosition(String position);

    // 修改状态
    boolean ChangeState(Em_State state);

    // 查询id
    void Query(int id) throws SQLException;


}
