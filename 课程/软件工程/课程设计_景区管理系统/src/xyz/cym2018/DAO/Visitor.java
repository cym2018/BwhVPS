package xyz.cym2018.DAO;

public class Visitor {
    private int id;
    private String in_time;
    private String out_time;
    private int state;
    private float price;
    private String buy_time;

    public String getBuy_time() {
        return buy_time;
    }

    public void setBuy_time(String buy_time) {
        this.buy_time = buy_time;
    }

    public int getId() {
        return id;
    }

    public String getOut_time() {
        return out_time;
    }

    public String getIn_time() {
        return in_time;
    }

    public float getPrice() {
        return price;
    }

    public int getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(int state) {
        this.state = state;
    }


    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

