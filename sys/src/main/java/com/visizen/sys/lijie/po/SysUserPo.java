package com.visizen.sys.lijie.po;

import com.visizen.common.po.BasePo;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户实体
 */
@Entity
@Table(name = "sys_user", schema = "", catalog = "jd_plm")
public class SysUserPo extends BasePo {
    private Long userId;
    private String username;
    private String nickname;
    private String tel;
    private String email;

    private String password;

    @Column(name = "role_id")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    private Long roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    //@Id
    @Column(name = "username")
    //@NotNull(message = "用户名不能为空！")
    @Length(max = 100,message = "用户名100个字符")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "nickname")
    @Length(max = 100,message = "昵称100个字符")
   // @NotNull(message = "昵称不能为空！")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "tel")
    @Pattern(regexp = "/^1[3|5|8]{1}[0-9]{9}$/", message = "手机号格式不正确！")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "email")
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "password")
    @NotNull(message = "密码不能为空！")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserPo sysUserPo = (SysUserPo) o;

        if (userId != sysUserPo.userId) return false;
        if (username != null ? !username.equals(sysUserPo.username) : sysUserPo.username != null) return false;
        if (nickname != null ? !nickname.equals(sysUserPo.nickname) : sysUserPo.nickname != null) return false;
        if (tel != null ? !tel.equals(sysUserPo.tel) : sysUserPo.tel != null) return false;
        if (email != null ? !email.equals(sysUserPo.email) : sysUserPo.email != null) return false;
        if (password != null ? !password.equals(sysUserPo.password) : sysUserPo.password != null) return false;

        return true;
    }
}
