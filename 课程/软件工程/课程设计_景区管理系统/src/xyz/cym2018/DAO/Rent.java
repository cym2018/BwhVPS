package xyz.cym2018.DAO;

public class Rent {
    private Integer id;
    private int shopid;
    private int userid;
    private String  time;

    public Rent(){}
    public Rent(int Shopid,int Userid){
        shopid=Shopid;
        userid=Userid;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
