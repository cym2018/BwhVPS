package xyz.cym2018.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlHelper {
    // 通用
    // 获取数据库连接
    private static Connection GetMysqlConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/bank?user=root&password=ab370126&useSSL=false");
        } catch (ClassNotFoundException | SQLException e) {
            ErrorReporter("GetMysqlConnection", e);
        }
        return null;
    }

    // 获取id
    private static int GetID(String card_id) {
        ResultSet resultSet = Read("select id from userinfo where card_id='" + card_id + "'");
        try {
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            ErrorReporter("GetID", e);
        }
        return 0;
    }

    // 写入
    private static void Write(String strSQL) {
        System.out.println("SQL:"+strSQL);
        try {
            Connection connection = GetMysqlConnection();
            connection.prepareStatement(strSQL).executeUpdate();
            connection.close();
        } catch (SQLException e) {
            ErrorReporter("Write", e);
        }
    }

    // 读取
    private static ResultSet Read(String strSQL) {
        System.out.println("SQL:"+strSQL);
        try {
            Connection connection = GetMysqlConnection();
            ResultSet resultSet = connection.prepareStatement(strSQL).executeQuery();
            return resultSet;
        } catch (SQLException e) {
            ErrorReporter("Read", e);
        }
        return null;
    }

    // 特定功能
    // 新建账户
    public static void CreateAccount(String card_id, String name, String id_number, String phone_number, String password) {
        Write("insert into userinfo (id,card_id,name,id_number,phone_number) values (null,'" + card_id + "','" + name + "','" + id_number + "','" + phone_number + "')");
        int id = GetID(card_id);
        Write("insert into account (id,card_id,password) values ('" + id + "','" + card_id + "','" + password + "')");
        Write("insert into balance (id,balance) values ('" + id + "','0')");
    }

    // 修改手机号
    public static void ChangePhoneNumber(int id, String phone_number) {
        Write("update userinfo set phone_number='" + phone_number + "' where id=" + id);
    }

    public static void ChangePhoneNumber(String card_id, String phone_number) {
        int id = GetID(card_id);
        ChangePhoneNumber(id, phone_number);
    }

    // 修改密码
    public static void ChangePassword(int id, String password) {
        Write("update account set password='" + password + "' where id=" + id);
    }

    public static void ChangePassword(String card_id, String password) {
        int id = GetID(card_id);
        ChangePassword(id, password);
    }

    // 销户
    public static void DeleteAccount(int id) {
        Write("delete from userinfo where id ='" + id + "'");
        Write("delete from account where id ='" + id + "'");
        Write("delete from balance where id ='" + id + "'");
    }

    public static void DeleteAccount(String card_id) {
        int id = GetID(card_id);
        DeleteAccount(id);
    }

    // 查询余额
    public static float GetBalance(int id) {
        ResultSet resultSet = Read("select balance from balance");
        try {
            resultSet.next();
            return resultSet.getFloat(1);
        } catch (SQLException e) {
            ErrorReporter("GetBalance", e);
        }
        return 0;
    }

    public static float GetBalance(String card_id) {
        int id = GetID(card_id);
        return GetBalance(id);
    }

    // 现金交易
    public static void Money(String card_id, float amount) {
        int id = GetID(card_id);
        float before = GetBalance(id);
        float after = before + amount;
        // 记账
        Write("insert into history (id,from_id,to_id,amount) values (null,'" + id + "','0','" + amount + "')");
        // 修改余额
        Write("update balance set balance='" + after + "'where id=" + id);
    }

    // 内部转账
    public static void Transfer(String card_id1, String card_id2, float amount) {
        // card_id1的操作
        float before = GetBalance(GetID(card_id1));
        float after = before + amount;
        int id = GetID(card_id1);
        Write("insert into history (id,from_id,to_id,balance) values (null,'" + card_id1 + "','" + card_id2 + "','" + amount + "')");
        Write("update balance set balance='" + after + "'where id=" + id);
        // card_id2的操作
        before = GetBalance(GetID(card_id2));
        after = before - amount;
        id = GetID(card_id2);
        Write("insert into history (id,from_id,to_id,balance) values (null,'" + card_id2 + "','" + card_id1 + "','" + amount + "')");
        Write("update balance set balance='" + after + "'where id=" + id);
    }

    // 交易历史查询
    public static ResultSet QueryHistory(int id) {
        return Read("select * from history where id=" + id);
    }

    public static ResultSet QueryHistory(String card_id) {
        int id = GetID(card_id);
        return QueryHistory(id);
    }

    // 错误处理
    private static void ErrorReporter(String FunctionName, Object e) {
        System.out.println("MysqlHelper." + FunctionName + "()\nERROR:" + e.toString());
        System.exit(-1);
    }
}
