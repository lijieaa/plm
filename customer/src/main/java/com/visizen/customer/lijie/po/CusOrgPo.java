package com.visizen.customer.lijie.po;

import com.visizen.common.po.BasePo;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/7.
 */
@Entity
@Table(name = "cus_org", schema = "", catalog = "jd_plm")
public class CusOrgPo extends BasePo{
    private Long cusId;
    private String cusName;
    private String cusAddr;
    private String cusCon;
    private String cusTel;
    private String cusEmail;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "cus_id")
    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "cus_name")
    @Length(max = 20,min = 1,message = "客户名称不能为空,最大20个字符!")
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Basic
    @Column(name = "cus_addr")
    @NotNull(message = "地址不能为空！")
    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    @Basic
    @Column(name = "cus_con")
    @NotNull(message = "联系人不能为空！")
    public String getCusCon() {
        return cusCon;
    }

    public void setCusCon(String cusCon) {
        this.cusCon = cusCon;
    }

    @Basic
    @Column(name = "cus_tel")
    @NotNull(message = "电话不能为空！")
    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    @Basic
    @Column(name = "cus_email")
    @Email
    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
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

}
