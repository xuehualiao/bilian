package com.itxingrui.bean;

public class SysRoleAccess {
    private Integer id;

    private Integer roleId;

    private Integer accessId;

    private String represent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent == null ? null : represent.trim();
    }
}