package model;

import java.sql.Date;

public class Teachinfo {
    private String id;
    private String name;
    private Date birth;
    private String photo;
    private String tel;
    private String email;
    private int major;//专业，引用专业表专业id

    //setters

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name;}

    public void setBirth(Date birth) { this.birth = birth;}

    public void setPhoto(String photo) { this.photo = photo; }

    public void setTel(String tel) { this.tel = tel; }

    public void setEmail(String email) { this.email = email; }

    public void setMajor(int major) { this.major = major; }
    //getters

    public String getId() { return id; }

    public String getName() { return name; }

    public Date getBirth() { return birth; }

    public String getPhoto() { return photo; }

    public String getTel() { return tel; }

    public String getEmail() { return email; }

    public int getMajor() { return major; }
}
