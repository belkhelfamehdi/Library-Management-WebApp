package Models;
import java.io.Serializable;
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private  int id;
    private String fname;
    private String lname;
    private String birthDate;
    private String status;
    private String role;
    private String type;


    public User() {
        this.fname = null;
        this.lname = null;
        this.birthDate = null;
        this.status = null;
        this.role = null;
        this.type = null;
    }
    public User(int id, String name, String birthDate, String status, String role, String type) {
        this.id = id;
        this.fname = name;
        this.lname = name;
        this.birthDate = birthDate;
        this.status = status;
        this.role = role;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String name) {
        this.fname = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String name) {
        this.lname = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
