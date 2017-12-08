package com.visizen.rs.lijie.config;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/30.
 */
@Entity
@Table(name = "sys_user", schema = "", catalog = "jd_plm")
public class SysUserPo {
    private long uid;
    private String username;
    private String password;
    private Long cid;

    @Id
    @Column(name = "uid")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "cid")
    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserPo sysUserPo = (SysUserPo) o;

        if (uid != sysUserPo.uid) return false;
        if (username != null ? !username.equals(sysUserPo.username) : sysUserPo.username != null) return false;
        if (password != null ? !password.equals(sysUserPo.password) : sysUserPo.password != null) return false;
        if (cid != null ? !cid.equals(sysUserPo.cid) : sysUserPo.cid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        return result;
    }
}
