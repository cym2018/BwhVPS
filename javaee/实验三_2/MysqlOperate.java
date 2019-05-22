package xyz.cym2018.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class MysqlOperate {
    // 获取连接
    static private Connection conGetConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/web?user=root&password=ab370126");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("xyz.cym2018.struts/conGetConnection ERROR!\n" + e.toString());
        }
        return null;
    }

    // 查询
    static private ResultSet rsReadFromSql(String strSQL) {
        try {
            return Objects.requireNonNull(conGetConnection()).prepareStatement("select * from info " + strSQL).executeQuery();
        } catch (SQLException e) {
            System.out.println("xyz.cym2018.struts/rsReadFromSql ERROR!\n" + e.toString());
        }
        return null;
    }

    // 查重
    static private boolean isRepeat(String value) {
        ResultSet rs = rsReadFromSql("where " + "username" + " = " + value);
        try {
            return !Objects.requireNonNull(rs).next();
        } catch (SQLException e) {
            System.out.println("xyz.cym2018.struts/isRepeat ERROR!\n" + e.toString());
        }
        return false;
    }

    // 增加
    static private void bWriteToSql(String strSQL) {
        try {
            Objects.requireNonNull(conGetConnection()).prepareStatement(strSQL).executeUpdate();
        } catch (SQLException e) {
            System.out.println("xyz.cym2018.Bean/bWriteToSql ERROR!\n" + e.toString());
        }
    }

    //保存学生信息
    static public void SaveStudentInfo(Action1 ac1) {
        if (isRepeat(ac1.getUsername())) {
            // TODO:更新
            bWriteToSql("update info set name='" + ac1.getName() + "',gender='" + ac1.getGender() + "',major='" +
                    ac1.getMajor() + "',birthday='" + ac1.getBirthday() + "',note='" + ac1.getNote() + "' where username='" + ac1.getUsername() + "'");
        }
        // TODO;新建
        bWriteToSql("insert into info (id,username,name,password,gender,major,birthday,note) values " +
                "(null,'" + ac1.getUsername() + "','" + ac1.getName() + "','','" + ac1.getGender() + "','" + ac1.getMajor() + "','" + ac1.getBirthday() + "','" + ac1.getNote() + "')");
    }

}
