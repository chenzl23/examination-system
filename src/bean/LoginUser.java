/*test*/
package bean;

import java.io.Serializable;

public class LoginUser  implements Serializable {
    private String username;
    private String psw;
    private int role;
    private String key;
    private String state;

    public LoginUser(){
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUsername(String name)
    {
        this.username = name;
    }

    public void setPsw(String psw)
    {
        this.psw = psw;
    }

    public String getPsw() {
        return psw;
    }

    public String getUsername() {
        return username;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
