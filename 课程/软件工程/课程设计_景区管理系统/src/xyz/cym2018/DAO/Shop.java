package xyz.cym2018.DAO;

public class Shop {
    private int id;
    private String name;
    private String place;
    private int state;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getState() {
        return state;
    }

    public String getPlace() {
        return place;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setPlace(String place) {
        this.place = place;
    }
/*
    Shop() {
        db = new DBConnect();
    }

    private void Query() throws SQLException {
        ResultSet resultSet = db.Query("select * from equipment where id=" + id);
        resultSet.next();
        name = resultSet.getString(2);
        place = resultSet.getString(3);
        state = resultSet.getInt(4);
    }

    public void Query(int id) throws SQLException {
        this.id = id;
        Query();
    }

    public void setName(String name) {
        this.name = name;
        db.Write("update equipment set name='"+name+"' where id="+id);
    }

    // 设置状态
    public void setE_state(int state) {
        this.state = state;
        db.Write("update equipment set state='"+state+"' where id="+id);
    }

    // 新建地点
    public void AddPlace(String name,String place){
        db.Write("insert into equipment (name,place) value ('"+name+"','"+place+"')");
    }

    public String getName() {
        return name;
    }

    public int getE_state() {
        return state;
    }

    public String getPlace() {
        return place;
    }
    // 查询所有信息
    public String[][] getAllPlace() throws SQLException {
        ResultSet resultSet = db.Query("select count(*) from equipment");
        resultSet.next();
        String[][] ret=new String[resultSet.getInt(1)][4];
        resultSet=db.Query("select * from equipment");
        int i=0;
        while (resultSet.next()){
            ret[i][0]=resultSet.getString(1);
            ret[i][1]=resultSet.getString(2);
            ret[i][2]=resultSet.getString(3);
            ret[i][3]=resultSet.getString(4);
        }
        return ret;
    }
    */
}
