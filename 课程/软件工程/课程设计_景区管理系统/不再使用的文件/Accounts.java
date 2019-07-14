package xyz.cym2018.old;

import xyz.cym2018.old.DBConnect;

public class Accounts {
    private DBConnect db;
    public Accounts(){ db=new DBConnect(); }
    public boolean NewBalance(String type,float balance){
        return db.Write("insert into accounts (a_type,amount) value ('"+type+"','"+balance+"')");
    }
}
