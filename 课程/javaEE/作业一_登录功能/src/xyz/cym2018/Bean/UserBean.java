package xyz.cym2018.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBean {
    private String sqlUser, sqlPassword, sqlDBName, sqlTableName;
    private String strUsername;
    private String strPassword;
    private int iUserNameLength;
    private int iPasswordLength;

    public UserBean() {
        strUsername = "undefined";
        strPassword = "undefined";
        sqlUser = "user";
        sqlPassword = "pass";
        sqlDBName = "javaee";
        sqlTableName = "user";
        iUserNameLength = 10;
        iPasswordLength = 20;
    }

    public boolean setStrUsername(String strUsername) {
        if (strUsername != null) {
            if (strUsername.length() > 0 && strUsername.length() <= iUserNameLength) {
                this.strUsername = strUsername;
                return true;
            }
        }
        return false;
    }

    public boolean setStrPassword(String strPassword) {
        if (strPassword != null) {
            if (strPassword.length() > 0 && strPassword.length() <= iPasswordLength) {
                this.strPassword = strPassword;
                return true;
            }
        }
        return false;
    }

    public String getStrUsername() {
        return this.strUsername;
    }

    public String getStrPassword() {
        return this.strPassword;
    }

    // 注册功能
    public boolean bRegister() {
        // 检查用户名是否重复
        ResultSet rs = rsReadFromSql("where username='" + strUsername + "'");
        try {
            if (!rs.next()) {
                return bWriteToSql("('" + strUsername + "','" + strPassword + "')");
            }
        } catch (SQLException e) {
            System.out.println("xyz.cym2018.Bean/bRegister ERROR!\n" + e.toString());
        }
        return false;
    }

    // 登录功能
    public boolean bLogin() {
        ResultSet rs = rsReadFromSql("where username='" + strUsername + "' and password='" + strPassword + "'");
        try {
            return rs.next();
        } catch (SQLException e) {
            System.out.println("xyz.cym2018.Bean/bLogin ERROR!\n" + e.toString());
        }
        return false;
    }

    // 获取数据库连接
    private Connection conGetConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/" + sqlDBName + "?user=" + sqlUser + "&password=" + sqlPassword);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("xyz.cym2018.Bean/conGetConnection ERROR!\n" + e.toString());
        }
        return null;
    }

    // 数据库查询
    private ResultSet rsReadFromSql(String strSQL) {
        try {
            return conGetConnection().prepareStatement("select * from " + sqlTableName + " " + strSQL).executeQuery();
        } catch (SQLException e) {
            System.out.println("xyz.cym2018.Bean/rsReadFromSql ERROR!\n" + e.toString());
        }
        return null;
    }

    // 数据库更新
    private boolean bWriteToSql(String strSQL) {
        try {
            return conGetConnection().prepareStatement("insert into " + sqlTableName + " (username,password) " + "value " + strSQL).executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("xyz.cym2018.Bean/bWriteToSql ERROR!\n" + e.toString());
        }
        return false;
    }
}
