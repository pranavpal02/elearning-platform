package com.elearning.beans;

public class Course {
    private int courseId;
    private String courseName;
    private String courseImage;
    private String category;

    // No-argument constructor (Fix for "The constructor Course() is undefined")
    public Course() {}

    // Parameterized constructor
    public Course(int courseId, String courseName, String courseImage, String category) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.category = category;
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
}
