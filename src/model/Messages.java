package model;
import java.sql.*;


public class Messages {
    private int msg_id;//留言id
    private int parent_id;
    private String from_id;//留言发送者
    private String to_id;//留言接收者
    private Date time;//留言时间
    private String message;//留言内容

    //setters

    public void setMsg_id(int msg_id) { this.msg_id = msg_id; }

    public void setParent_id(int parent_id) { this.parent_id = parent_id; }

    public void setFrom_id(String from_id) { this.from_id = from_id; }

    public void setTo_id(String to_id) { this.to_id = to_id; }

    public void setTime(Date time) { this.time = time; }

    public void setMessage(String message) { this.message = message; }

    //getters

    public int getMsg_id() { return msg_id; }

    public int getParent_id() { return parent_id; }

    public String getFrom_id() { return from_id; }

    public String getTo_id() { return to_id; }

    public Date getTime() { return time; }

    public String getMessage() { return message; }

}
