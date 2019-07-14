package xyz.cym2018.DAO;

public class Bill {
    private Integer id;
    private String time;
    private String type;
    private float money;
    public Bill(){}
    public Bill(String Type,float Money){
        type=Type;
        money=Money;
    }
    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
