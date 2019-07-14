package xyz.cym2018.DAO;

public class Worker {
    private int id;
    private String name;
    private float salary;
    private String work;
    private int state;
    private String starttime;
    private String endtime;

    public Worker() {
    }

    Worker(int Id, String Name, float Salary, String Work) {
        id = Id;
        name = Name;
        salary = Salary;
        work = Work;
    }

    public int getState() {
        return state;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getWork() {
        return work;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setWork(String work) {
        this.work = work;
    }
/*

    // 新建用户
    @Override
    public boolean CreateUser(int Id, String Name, float Salary, String Position) throws SQLException {
        ResultSet resultSet = db.Query("select * from employees where id=" + Id);
        if (resultSet.next()) {
            return false;
        } else {
            db.Write("insert into employees (id,name,salary,position) value ('" + Id + "','" + Name + "','" + Salary + "','" + Position + "')");
            Query(Id);
            return true;
        }
    }
    // 调整工资
    @Override
    public boolean ChangeSalary(float salary) throws SQLException {
        this.salary =salary;
        return db.Write("update employees set salary='"+ this.salary +"'");
    }
    // 调整岗位
    @Override
    public  boolean ChangePosition(String position){
        work =position;
        return db.Write("update employees set position='"+ work +"'");
    }
    // 改变状态
    @Override
    public boolean ChangeState(I_Employees.Em_State state){
        this.state =0;
        while(!state.equals(Em_State.values()[this.state])){
            this.state++;}
        if(this.state ==4){
            db.Write("update employees set e_state='"+ this.state +"' where id="+ id);
            db.Write("update employees set ed_time=now() where id="+ id);
        }
        return db.Write("update employees set e_state='"+ this.state +"' where id="+ id);
    }
    // 查询
    private void Query() throws SQLException {
        ResultSet resultSet = db.Query("select * from employees where id=" + id);
        resultSet.next();
        name = resultSet.getString(2);
        salary = resultSet.getFloat(3);
        work = resultSet.getString(4);
        state = resultSet.getInt(5);
        starttime = resultSet.getString(6);
        endtime = resultSet.getString(7);
    }
    @Override
    public void Query(int id) throws SQLException {
        this.id = id;
        Query();
    }

    public String getWork() {
        return work;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() { return name; }
    public float getSalary() { return salary; }
    public String getState() { return Em_State.values()[state].toString(); }
    public String getEndtime() { return endtime; }
    public String getStarttime() { return starttime; }
    public void setEndtime(String endtime) { this.endtime = endtime; }

    public static void main(String[] args) throws SQLException {

    }
     */
}
