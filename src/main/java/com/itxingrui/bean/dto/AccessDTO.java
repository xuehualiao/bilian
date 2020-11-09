package com.itxingrui.bean.dto;

public class AccessDTO {

    /**
     * accessId
     */
    private int id;

    private int activeId;
    private int moduleId;
    private String activeName;
    private String moduleName;

    /**
     * 角色名称，权限中间表的角色为null
     */
    private String roleName;

    /**
     * 标识权限来自于 角色/权限中间表     角色：1，权限：0
     */
    private int roleFlag;

    public int getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(int roleFlag) {
        this.roleFlag = roleFlag;
    }

    @Override
    public String toString() {
        return "AccessDTO{" +
                "id=" + id +
                ", activeId=" + activeId +
                ", moduleId=" + moduleId +
                ", activeName='" + activeName + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActiveId() {
        return activeId;
    }

    public void setActiveId(int activeId) {
        this.activeId = activeId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
