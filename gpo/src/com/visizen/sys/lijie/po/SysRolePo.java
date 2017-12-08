package com.visizen.sys.lijie.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/4.
 */
@Entity
@Table(name = "sys_role", schema = "", catalog = "jd_plm")
@IdClass(SysRolePoPK.class)
public class SysRolePo {
    private int roleId;
    private String roleName;
    private String roleNickname;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_nickname")
    public String getRoleNickname() {
        return roleNickname;
    }

    public void setRoleNickname(String roleNickname) {
        this.roleNickname = roleNickname;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRolePo sysRolePo = (SysRolePo) o;

        if (roleId != sysRolePo.roleId) return false;
        if (roleName != null ? !roleName.equals(sysRolePo.roleName) : sysRolePo.roleName != null) return false;
        if (roleNickname != null ? !roleNickname.equals(sysRolePo.roleNickname) : sysRolePo.roleNickname != null)
            return false;
        if (createTime != null ? !createTime.equals(sysRolePo.createTime) : sysRolePo.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(sysRolePo.updateTime) : sysRolePo.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleNickname != null ? roleNickname.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
