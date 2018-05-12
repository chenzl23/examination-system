package model;

public class Courses {
    private int c_id;//课程号
    private String c_name;//课程名
    private int grade;
    private double credit;

    //setters

    public void setC_id(int c_id) { this.c_id = c_id; }

    public void setC_name(String c_name) { this.c_name = c_name; }

    public void setGrade(int grade) { this.grade = grade; }

    public void setCredit(double credit) { this.credit = credit; }


    //getters

    public int getC_id() { return c_id; }

    public String getC_name() { return c_name; }

    public int getGrade() { return grade; }

    public double getCredit() { return credit; }


}
