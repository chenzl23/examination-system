package model;

import java.sql.Date;

public class Teachinfo {
    private String t_id;
    private String t_name;
    private Date t_birth;
    private String t_photo;
    private String t_tel;
    private String t_email;
    private int t_major;//专业，引用专业表专业id

    //setters

    public void setT_id(String t_id) { this.t_id = t_id; }

    public void setT_name(String t_name) { this.t_name = t_name;}

    public void setT_birth(Date t_birth) { this.t_birth = t_birth;}

    public void setT_photo(String t_photo) { this.t_photo = t_photo; }

    public void setT_tel(String t_tel) { this.t_tel = t_tel; }

    public void setT_email(String t_email) { this.t_email =t_email; }

    public void setT_major(int t_major) { this.t_major = t_major; }
    //getters

    public String getT_id() { return t_id; }

    public String getT_name() { return t_name; }

    public Date getT_birth() { return t_birth; }

    public String getT_photo() { return t_photo; }

    public String getT_tel() { return t_tel; }

    public String getT_email() { return t_email; }

    public int getT_major() { return t_major; }
}
