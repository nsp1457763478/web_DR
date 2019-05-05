package com.java.comment.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/24
 * Time: 21:48
 * Description: No Description
 */
public class Comment {
    private Integer id;
    private Integer wupinId;
    private String user;
    private String comment;
    private String date;
    private Integer isReported;

    public Comment() {
    }

    public Comment(Integer id, String user) {
        this.id = id;
        this.user = user;
    }

    public Comment(Integer wupinId, String user, String comment, String date, Integer isReported) {
        this.wupinId = wupinId;
        this.user = user;
        this.comment = comment;
        this.date = date;
        this.isReported = isReported;
    }

    public Comment(Integer id, Integer wupinId, String user, String comment, String date) {
        this.id = id;
        this.wupinId = wupinId;
        this.user = user;
        this.comment = comment;
        this.date = date;
    }

    public Comment(Integer id, Integer wupinId, String user, String comment, String date, Integer isReported) {
        this.id = id;
        this.wupinId = wupinId;
        this.user = user;
        this.comment = comment;
        this.date = date;
        this.isReported = isReported;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWupinId() {
        return wupinId;
    }

    public void setWupinId(Integer wupinId) {
        this.wupinId = wupinId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getIsReported() {
        return isReported;
    }

    public void setIsReported(Integer isReported) {
        this.isReported = isReported;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", wupinId=" + wupinId +
                ", user='" + user + '\'' +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                ", isReported=" + isReported +
                '}';
    }
}
