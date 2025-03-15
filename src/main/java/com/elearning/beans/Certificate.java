package com.elearning.beans;

public class Certificate {
    private int id;
    private int userId;
    private int courseId;
    private String certificateDate;

    // Constructor
    public Certificate(int id, int userId, int courseId, String certificateDate) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.certificateDate = certificateDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }
}
