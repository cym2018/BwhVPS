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
    public static int GetID(String card_id) {
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
        System.out.println("SQL:" + strSQL);
        try {
            Connection connection = GetMysqlConnection();
            connection.prepareStatement(strSQL).executeUpdate();
            connection.close();
        } catch (SQLException e) {
            ErrorReporter("Write", e);
        }
    }
    public static String GetName(int id){
        try {
            ResultSet resultSet=Read("select * from userinfo where id="+id);
            resultSet.next();
            return resultSet.getString("name");
        } catch (SQLException e) {
            ErrorReporter("GetName",e);
        }
        return null;
    }
    public static String GetName(String card_id){
return GetName(GetID(card_id));
    }
    // 读取
    private static ResultSet Read(String strSQL) {
        System.out.println("SQL:" + strSQL);
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
    public static boolean DeleteAccount(String card_id, String name, String id_number, String password) {
        try {
            // 检测余额
            if (GetBalance(card_id) != 0)
                return false;
            // 验证信息
            ResultSet resultSet = Read("select * from userinfo where card_id='" + card_id + "'");
            ResultSet resultSet1 = Read("select * from account where card_id='" + card_id + "'");
            if (resultSet.next() && resultSet1.next())
                if (resultSet.getString("name").equals(name)
                        && resultSet.getString("id_number").equals(id_number)
                        && resultSet1.getString("password").equals(password)) {
                    DeleteAccount(card_id);
                    return true;
                }
        } catch (SQLException e) {
            ErrorReporter("DeleteAccount", e);
        }
        return false;
    }

    private static void DeleteAccount(int id) {
        Write("update userinfo set id_number='' , name='' , phone_number='' where id ='" + id + "'");
        Write("update account set password='' where id ='" + id + "'");
    }

    private static void DeleteAccount(String card_id) {
        int id = GetID(card_id);
        DeleteAccount(id);
    }

    // 查询余额
    public static float GetBalance(int id) {
        ResultSet resultSet = Read("select balance from balance where id=" + id);
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
        float after = before - amount;
        int id1 = GetID(card_id1);
        int id2 = GetID(card_id2);
        Write("insert into history (id,from_id,to_id,amount) values (null,'" + id1 + "','" + id2 + "','" + (-amount) + "')");
        Write("update balance set balance='" + after + "'where id=" + id1);
        // card_id2的操作
        before = GetBalance(GetID(card_id2));
        after = before + amount;
        Write("insert into history (id,from_id,to_id,amount) values (null,'" + id2 + "','" + id1 + "','" + amount + "')");
        Write("update balance set balance='" + after + "'where id=" + id2);
    }
    public static boolean TransferOB(String card_id,String name){
        try {
            ResultSet resultSet=Read("select * from userinfo where card_id='"+card_id+"' and name='"+name+"'");
            return resultSet.next();
        } catch (SQLException e) {
            ErrorReporter("TransferOB",e);
        }
        return false;
    }

    // 交易历史查询
    public static ResultSet QueryHistory(int id) {
        return Read("select * from history where from_id=" + id);
    }

    public static ResultSet QueryHistory(String card_id) {
        int id = GetID(card_id);
        return QueryHistory(id);
    }

    public static String GetCardId(int id) {
        if (id == 0)
            return "现金交易";
        ResultSet resultSet = Read("select card_id from account where id=" + id);
        try {
            if (resultSet.next())
                return resultSet.getString(1);
            return "未知账户";
        } catch (SQLException e) {
            ErrorReporter("GetCardId", e);
        }
        return null;
    }

    // 错误处理
    private static void ErrorReporter(String FunctionName, Object e) {
        System.out.println("MysqlHelper." + FunctionName + "()\nERROR:" + e.toString());
        System.exit(-1);
    }

    // 验证账号密码
    public static boolean Login(String card_id, String password) {
        try {
            ResultSet resultSet = Read("select * from account where card_id='" + card_id + "' and password='" + password + "'");
            return resultSet.next();
        } catch (SQLException e) {
            ErrorReporter("Login",e);
        }
        return false;
    }

}
