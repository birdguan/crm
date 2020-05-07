package com.birdguan.crm.model;

import java.util.Date;

public class CourseCategory {
    private int id;
    private String course_name;
    private Date publish_datetime;
    private int status; // 1 有效  0 无效
    private String course_author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getPublish_datetime() {
        return publish_datetime;
    }

    public void setPublish_datetime(Date publish_datetime) {
        this.publish_datetime = publish_datetime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCourse_author() {
        return course_author;
    }

    public void setCourse_author(String course_author) {
        this.course_author = course_author;
    }
}
