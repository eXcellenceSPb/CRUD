package dbservice.userDataSet;

import java.util.Objects;

public class User {
    private String pkey;

    private int id;
    private String name;
    private String pass;
    private String login;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public User(){
        this.id = 0;
        this.name = null;
        this.pass = null;
        this.login = null;

    }

    public User(int id, String name, String pass, String login) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getLogin() {
        return login;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, login, pass);
    }

    public String getPkey() {
        return pkey;
    }
    public void setPkey(String pkey) {
        this.pkey = pkey;
    }
}
