package xyz.cym2018.DAO;

public class Login {
    private int id;
    private String username;
    private String password;
    private SelectCourse selectCourse;
    public Login() {
    }

    public Login(String username,String password) {
        setUsername(username);
        setPassword(password);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
