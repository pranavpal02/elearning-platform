package com.elearning.beans;

public class Course {
    private int courseId;
    private String courseName;
    private String courseImage;
    private String category;
    private String description;
    private String videoUrl;

    // No-argument constructor (Fix for "The constructor Course() is undefined")
    public Course() {}

    // Parameterized constructor
    public Course(int courseId, String courseName, String courseImage, String category, String description, String videoUrl) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.category = category;
        this.description = description;
        this.videoUrl = videoUrl;
    }

    // Getters and Setters (Fix for undefined setter methods)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
