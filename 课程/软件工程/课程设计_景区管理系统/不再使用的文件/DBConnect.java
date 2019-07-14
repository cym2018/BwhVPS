package xyz.cym2018.old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
    private Connection connection = null;

    public DBConnect() {
        GetConnect();
    }

    // 打开连接
    private void GetConnect() {
        if (connection != null)
            Close();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/VC?user=root&password=ab370126");
        } catch (ClassNotFoundException | SQLException e) {
            ShowError("GetConnect", e);
        }
    }

    // 关闭连接
    public void Close() {
        try {
            connection.close();
        } catch (SQLException e) {
            ShowError("Close", e);
        }
    }

    // 查询操作
    ResultSet Query(String sql) {
        if (connection == null) {
            ShowError("Query", "SQL连接为空");
            return null;
        } else {
            // 执行操作
            try {
                //Close(connection);
                return connection.prepareStatement(sql).executeQuery();
            } catch (SQLException e) {
                ShowError("Query", e);
            }
            return null;
        }
    }

    // 写入操作
    boolean Write(String sql) {
        try {
            if (connection == null) {
                ShowError("Write", "SQL连接为空");
            } else {
                return connection.prepareStatement(sql).execute();
            }
        } catch (SQLException e) {
            ShowError("Write", e);
        }
        return false;
    }

    // 报错
    static void ShowError(String FunctionName, Object e) {
        System.out.println("xyz.cym2018.DAO." + FunctionName + "()\nERROR\n" + e.toString());
    }
}
