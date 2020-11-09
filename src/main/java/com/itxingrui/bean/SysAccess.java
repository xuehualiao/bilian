package com.itxingrui.bean;

public class SysAccess {
    private Integer id;

    private String accessName;

    private Integer activeId;

    private Integer moduleId;

    public SysAccess(String s, String query) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName == null ? null : accessName.trim();
    }

    public Integer getActiveId() {
        return activeId;
    }

    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}