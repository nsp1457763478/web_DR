package com.java.order.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/5/4
 * Time: 22:51
 * Description: No Description
 */
public class VisitCount {
    private Integer visit;

    public VisitCount() {
    }

    public VisitCount(Integer visit) {
        this.visit = visit;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    @Override
    public String toString() {
        return "VisitCount{" +
                "visit=" + visit +
                '}';
    }
}
