package xyz.cym2018.DAO;

public class Checkin {
    private Integer id;
    private int type;
    private int userid;

    Checkin(int Type, int Userid) {
        type = Type;
        userid = Userid;
    }

    public Checkin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
