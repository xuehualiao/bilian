package com.itxingrui.bean;

import java.util.Date;
import java.util.Set;

public class SysRole {
    private Integer id;

    private String roleName;

    private String state;

    private String represent;

    private Date createDate;

    private Set<SysAccess> sysAccesses;

    public Set<SysAccess> getSysAccesses() {
        return sysAccesses;
    }

    public void setSysAccesses(Set<SysAccess> sysAccesses) {
        this.sysAccesses = sysAccesses;
    }

    public SysRole(Set<SysAccess> sysAccesses) {
        this.sysAccesses = sysAccesses;
    }

    public SysRole(Integer id, String roleName, Set<SysAccess> sysAccesses) {
        this.id = id;
        this.roleName = roleName;
        this.sysAccesses = sysAccesses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent == null ? null : represent.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}