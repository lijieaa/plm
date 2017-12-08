package com.visizen.sys.lijie.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/4.
 */
@Entity
@Table(name = "sys_user", schema = "", catalog = "jd_plm")
@IdClass(SysUserPoPK.class)
public class SysUserPo {
    private int userId;
    private String username;
    private String nickname;
    private String tel;
    private String email;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String password;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Basic
    @Column(name = "password")
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
        if (createTime != null ? !createTime.equals(sysUserPo.createTime) : sysUserPo.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(sysUserPo.updateTime) : sysUserPo.updateTime != null) return false;
        if (password != null ? !password.equals(sysUserPo.password) : sysUserPo.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
