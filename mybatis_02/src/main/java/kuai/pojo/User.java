package kuai.pojo;

//实体类
public class User {
    private int id;
    private String user_name;
    private String pubKey;

    public User() {
    }

    public User(int id, String user_name, String pubKey) {
        this.id = id;
        this.user_name = user_name;
        this.pubKey = pubKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String name) {
        this.user_name = name;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", pubKey='" + pubKey + '\'' +
                '}';
    }
}
