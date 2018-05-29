package model;

import java.sql.Date;

public class Messages {
    private int ms_id;//留言id
    private int parent_id;//父留言id
    private String from_id;//留言发送者id
    private String to_id;//留言接收中id
    private Date time;//留言时间
    private String message;//留言内容

    //setters

    public void setMs_id(int ms_id) { this.ms_id = ms_id; }

    public void setParent_id(int parent_id) { this.parent_id = parent_id; }

    public void setFrom_id(String from_id) { this.from_id = from_id; }

    public void setTo_id(String to_id) { this.to_id = to_id;}

    public void setTime(Date time) { this.time=time; }

    public void setMessage(String message) { this.message = message; }

    //getters

    public int getMs_id() { return ms_id; }

    public int getParent_id() { return parent_id; }

    public String getFrom_id() { return from_id; }

    public String getTo_id() { return to_id; }

    public Date getTime() { return time; }

    public String getMessage() { return message; }
}
