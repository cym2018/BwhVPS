package xyz.cym2018.old;

import xyz.cym2018.DAO.User;

import java.sql.SQLException;

public interface I_User {
    // 查询信息
    User Query(int id) throws SQLException;
    // 新建用户
    boolean CreateUser(String Username, String Password, String type) throws SQLException;
    // 用户登陆
    boolean Login(String Username, String Password) throws SQLException;
}
