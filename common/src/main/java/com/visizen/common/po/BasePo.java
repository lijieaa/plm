package com.visizen.common.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * 基本实体
 */
@MappedSuperclass
public class BasePo implements Serializable{


    private Calendar createTime;

    private Calendar updateTime;



    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.CreationTimestamp
    @Basic
    @Column(name = "create_time",updatable = false)
    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @org.hibernate.annotations.UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    @Column(name = "update_time")
    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }
}
