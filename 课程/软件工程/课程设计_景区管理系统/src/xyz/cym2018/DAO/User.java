package xyz.cym2018.DAO;

public class User {
    private int id;
    private String username;
    private String password;
    private String type;

    public User() {
    }

    public User(String Username, String Password, String Type) {
        username = Username;
        password = Password;
        type = Type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }
}
