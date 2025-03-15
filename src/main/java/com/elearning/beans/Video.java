package com.elearning.beans;

public class Video {
    private int id;
    private int courseId;
    private String title;
    private String url;

    // Constructor
    public Video(int id, int courseId, String title, String url) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.url = url;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
