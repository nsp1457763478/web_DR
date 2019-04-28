package com.java.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * author:孙琪
 * date:2019/4/28
 * time:10:16
 */
@Entity
@Table(name = "type")//商品分类表
public class Type {
    private Integer tid;
    private String typeName;
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Type() {
    }

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public Type(Integer tid, String typeName) {
        this.tid = tid;
        this.typeName = typeName;
    }
}
