package com.itxingrui.bean;

import java.util.Objects;
import java.util.Set;

public class SysUser {
    private Integer id;

    private String username;

    private String password;

    private String realName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) &&
                Objects.equals(username, sysUser.username) &&
                Objects.equals(password, sysUser.password) &&
                Objects.equals(realName, sysUser.realName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, realName);
    }

    private Set<SysRole> sysRoles;

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public SysUser(String username, String password, String realName, Set<SysRole>  sysRoles) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.sysRoles = sysRoles;
    }

    public SysUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

}