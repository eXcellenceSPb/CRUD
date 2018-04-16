package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "qwert")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "pass")
    private String pass;
    @Column(name = "login")
    private String login;
    @Column(name = "type")
    private String type;

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

    public void setType(String type) { this.type = type; }

    public User() {
        this.id = 0;
        this.name = null;
        this.pass = null;
        this.login = null;
        this.type = null;
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
        this.name = null;
        this.type = "user";
    }

    public User(int id, String name, String pass, String login) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.login = login;
        this.type = "user";
    }

    public User(int id,String name, String pass, String login,String type){
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.login = login;
        this.type = type;
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

    public String getType() { return type; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", login='" + login + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
