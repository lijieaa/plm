package com.visizen.customer.lijie.po;

import com.visizen.common.po.BasePo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 网关实体
 */
@Entity
@Table(name = "cus_gat", schema = "", catalog = "jd_plm")
public class CusGatPo extends BasePo{
    private int gatId;
    private String gatIp;
    private String gatName;
    private String gatImsi;
    private String gatType;
    private Byte gatStatus;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "gat_id")
    public int getGatId() {
        return gatId;
    }

    public void setGatId(int gatId) {
        this.gatId = gatId;
    }

    @Basic
    @Column(name = "gat_ip")
    public String getGatIp() {
        return gatIp;
    }

    public void setGatIp(String gatIp) {
        this.gatIp = gatIp;
    }

    @Basic
    @Column(name = "gat_name")
    public String getGatName() {
        return gatName;
    }

    public void setGatName(String gatName) {
        this.gatName = gatName;
    }

    @Basic
    @Column(name = "gat_imsi")
    public String getGatImsi() {
        return gatImsi;
    }

    public void setGatImsi(String gatImsi) {
        this.gatImsi = gatImsi;
    }

    @Basic
    @Column(name = "gat_type")
    public String getGatType() {
        return gatType;
    }

    public void setGatType(String gatType) {
        this.gatType = gatType;
    }

    @Basic
    @Column(name = "gat_status")
    public Byte getGatStatus() {
        return gatStatus;
    }

    public void setGatStatus(Byte gatStatus) {
        this.gatStatus = gatStatus;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CusGatPo cusGatPo = (CusGatPo) o;

        if (gatId != cusGatPo.gatId) return false;
        if (gatIp != null ? !gatIp.equals(cusGatPo.gatIp) : cusGatPo.gatIp != null) return false;
        if (gatName != null ? !gatName.equals(cusGatPo.gatName) : cusGatPo.gatName != null) return false;
        if (gatImsi != null ? !gatImsi.equals(cusGatPo.gatImsi) : cusGatPo.gatImsi != null) return false;
        if (gatType != null ? !gatType.equals(cusGatPo.gatType) : cusGatPo.gatType != null) return false;
        if (gatStatus != null ? !gatStatus.equals(cusGatPo.gatStatus) : cusGatPo.gatStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gatId;
        result = 31 * result + (gatIp != null ? gatIp.hashCode() : 0);
        result = 31 * result + (gatName != null ? gatName.hashCode() : 0);
        result = 31 * result + (gatImsi != null ? gatImsi.hashCode() : 0);
        result = 31 * result + (gatType != null ? gatType.hashCode() : 0);
        result = 31 * result + (gatStatus != null ? gatStatus.hashCode() : 0);
        return result;
    }
}
