package com.visizen.sys.lijie.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.visizen.common.po.BasePo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

/**
 * 角色实体
 */
@Entity
@Table(name = "sys_role", schema = "", catalog = "jd_plm")
public class SysRolePo extends BasePo{
    private Long roleId;
    private String roleName;
    private String roleNickname;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "role_id")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    //@Id
    @NotNull(message="角色名称不能为空！")
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @NotNull(message="角色显示名称不能为空！")
    @Basic
    @Column(name = "role_nickname")
    public String getRoleNickname() {
        return roleNickname;
    }

    public void setRoleNickname(String roleNickname) {
        this.roleNickname = roleNickname;
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
        return true;
    }

}
