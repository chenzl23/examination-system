package model;

public class Users {
    private String id;
    private String passwd;
    private int role_id;
    public String getId(){ return id; }
    public void setId(String id){this.id=id;}
    public String getPasswd(){ return passwd; }
    public void setPasswd(String passwd){this.passwd=passwd;}
    public int getRole_id(){ return role_id; }
    public void setRole_id(int role_id){this.role_id=role_id;}
}//对应tb_users实体类
