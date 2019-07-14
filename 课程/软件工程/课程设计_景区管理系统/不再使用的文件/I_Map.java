package xyz.cym2018.old;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface I_Map {
    // 添加地点
    static int add(String name) throws SQLException {
        DBConnect db = new DBConnect();
        ResultSet resultSet = db.Query("select * from map where name='" + name + "'");
        if (resultSet.next()) {
            return 0;
        } else {
            db.Write("insert into map (name) value ('" + name + "')");
            ResultSet resultSet1 = db.Query("select * from map where name='" + name + "'");
            resultSet1.next();
            return resultSet1.getInt(1);
        }
    }
    // 删除地点
    static boolean Del(String name) {
        DBConnect db = new DBConnect();
        return db.Write("delete from map where name='" + name + "'");
    }
    // 名称查id
    static int GetId(String name) throws SQLException {
        DBConnect db = new DBConnect();
        ResultSet resultSet = db.Query("select * from map where name='" + name + "'");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
    // id查名称
    static String GetName(int id)throws SQLException{
        DBConnect db = new DBConnect();
        ResultSet resultSet = db.Query("select * from map where id='" + id + "'");
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
}
