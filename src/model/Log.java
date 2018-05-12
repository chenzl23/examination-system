package model;

import java.sql.Date;

public class Log {
    private int login_id;
    private Date login_time;
    private String key;

    //setters

    public void setLogin_id(int login_id) { this.login_id = login_id; }

    public void setLogin_time(Date login_time) { this.login_time = login_time; }

    public void setKey(String key) { this.key = key; }

    //getters

    public int getLogin_id() { return login_id; }

    public Date getLogin_time() { return login_time; }

    public String getKey() { return key; }
}
