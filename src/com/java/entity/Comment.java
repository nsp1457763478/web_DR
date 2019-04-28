package com.java.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * author:孙琪
 * date:2019/4/28
 * time:10:24
 */
@Entity
@Table(name = "comment")//评论表
public class Comment {
    private Integer mid;//评论编号
    private String username;//用户名
    private String content;//评论内容
    private Date createTime;//评论时间
    private String options;//操作（删除）
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Comment() {
    }

    public Comment(Integer mid, String username, String content, Date createTime, String options) {
        this.mid = mid;
        this.username = username;
        this.content = content;
        this.createTime = createTime;
        this.options = options;
    }
    public Comment(String username, String content, Date createTime, String options) {
        this.username = username;
        this.content = content;
        this.createTime = createTime;
        this.options = options;
    }
}
