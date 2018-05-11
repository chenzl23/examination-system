package model;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 * @author by Lxp
 * @// TODO: 2018/5/8 17:36
 */
public class Stuinfo {
    private String id;//学号
    private String name;
    private Date birth;
    private String photo;//记录照片在服务器的路径
    private String tel;
    private String email;
    private int major;//专业，引用专业表中的id
    private int enrollyear;//入学年份
    private double credit_got;//已获学分
    private double credit_need;//需获学分
    //setters

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setBirth(Date birth) { this.birth = birth; }

    public void setPhoto(String photo) { this.photo = photo; }

    public void setTel(String tel) { this.tel = tel; }

    public void setEmail(String email) { this.email = email; }

    public void setMajor(int major) { this.major = major; }

    public void setEnrollyear(int enrollyear) { this.enrollyear = enrollyear; }

    public void setCredit_got(double credit_got) { this.credit_got = credit_got; }

    public void setCredit_need(double credit_need) { this.credit_need = credit_need; }
    //getters

    public String getId() { return id; }

    public String getName() { return name; }

    public Date getBirth() { return birth; }

    public String getPhoto() { return photo; }

    public String getTel() { return tel; }

    public String getEmail() { return email; }

    public int getMajor() { return major; }

    public int getEnrollyear() { return enrollyear; }

    public double getCredit_got() { return credit_got; }

    public double getCredit_need() { return credit_need; }
}
