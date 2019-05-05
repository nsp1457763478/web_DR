package com.java.order.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/28
 * Time: 14:20
 * Description: No Description
 */
public class Information {
    private Integer id;
    //uId用来判断是给哪个用户的通知
    private Integer uId;
    private String content;
    private String isRead;
    private String date;

    public Information() {
    }

    public Information(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Information(Integer uId, String content, String isRead, String date) {
        this.uId = uId;
        this.content = content;
        this.isRead = isRead;
        this.date = date;
    }

    public Information(Integer id, Integer uId, String content, String isRead, String date) {
        this.id = id;
        this.uId = uId;
        this.content = content;
        this.isRead = isRead;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", uId=" + uId +
                ", content='" + content + '\'' +
                ", isRead=" + isRead +
                ", date='" + date + '\'' +
                '}';
    }
}
