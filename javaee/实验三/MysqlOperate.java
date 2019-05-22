package xyz.cym2018.struts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

    // 增加
    static private void bWriteToSql(String strSQL) {
        try {
            Objects.requireNonNull(conGetConnection()).prepareStatement(strSQL).executeUpdate();
        } catch (SQLException e) {
            System.out.println("xyz.cym2018.struts/bWriteToSql ERROR!\n" + e.toString());
        }
    }

    //保存学生信息
    static void SaveStudentInfo(Action1 ac1) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        // TODO;新建
        bWriteToSql("insert into info (id,username,name,password,gender,major,birthday,note) values " +
                "(null,'" + ac1.getUsername() + "','" + ac1.getName() + "','"+ac1.getPassword()+"','" + ac1.getGender() + "','" + ac1.getMajor() + "','" + format.format(ac1.getBirthday()) + "','" + ac1.getNote() + "')");
    }

}
