package cn.bb.model;

import java.util.List;

public class OneUser {
    private Integer id;	//	id
    private String username;//		用户名
    private String password;	//		密码
    private String sex;//	性别
    private String role;//	角色
    private List<OneRole> roles;
    public Integer getId() {
        return id;
    }

    public List<OneRole> getRoles() {
        return roles;
    }

    public void setRoles(List<OneRole> roles) {
        this.roles = roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
