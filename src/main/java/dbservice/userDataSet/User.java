package dbservice.userDataSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "qwert")
public class User implements Serializable{
    private String pkey;
    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="pass")
    private String pass;
    @Column(name="login")
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

    public String getPkey() {
        return pkey;
    }
    public void setPkey(String pkey) {
        this.pkey = pkey;
    }
}
