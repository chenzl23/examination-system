package model;

public class Roles {
    private int role_id;
    private String role_name;
    private int permission;
    //setters
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

   //getters

    public int getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public int getPermission() {
        return permission;
    }
}
