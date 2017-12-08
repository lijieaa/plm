package com.visizen.sys.lijie.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/7.
 */
@Entity
@Table(name = "cus_org", schema = "", catalog = "jd_plm")
public class CusOrgPo {
    private int cusId;
    private String cusName;
    private String cusAddr;
    private String cusCon;
    private String cusTel;
    private String cusEmail;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "cus_id")
    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "cus_name")
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Basic
    @Column(name = "cus_addr")
    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    @Basic
    @Column(name = "cus_con")
    public String getCusCon() {
        return cusCon;
    }

    public void setCusCon(String cusCon) {
        this.cusCon = cusCon;
    }

    @Basic
    @Column(name = "cus_tel")
    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    @Basic
    @Column(name = "cus_email")
    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
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

        CusOrgPo cusOrgPo = (CusOrgPo) o;

        if (cusId != cusOrgPo.cusId) return false;
        if (cusName != null ? !cusName.equals(cusOrgPo.cusName) : cusOrgPo.cusName != null) return false;
        if (cusAddr != null ? !cusAddr.equals(cusOrgPo.cusAddr) : cusOrgPo.cusAddr != null) return false;
        if (cusCon != null ? !cusCon.equals(cusOrgPo.cusCon) : cusOrgPo.cusCon != null) return false;
        if (cusTel != null ? !cusTel.equals(cusOrgPo.cusTel) : cusOrgPo.cusTel != null) return false;
        if (cusEmail != null ? !cusEmail.equals(cusOrgPo.cusEmail) : cusOrgPo.cusEmail != null) return false;
        if (createTime != null ? !createTime.equals(cusOrgPo.createTime) : cusOrgPo.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(cusOrgPo.updateTime) : cusOrgPo.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cusId;
        result = 31 * result + (cusName != null ? cusName.hashCode() : 0);
        result = 31 * result + (cusAddr != null ? cusAddr.hashCode() : 0);
        result = 31 * result + (cusCon != null ? cusCon.hashCode() : 0);
        result = 31 * result + (cusTel != null ? cusTel.hashCode() : 0);
        result = 31 * result + (cusEmail != null ? cusEmail.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
