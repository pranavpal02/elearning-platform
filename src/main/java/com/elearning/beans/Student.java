package com.elearning.beans;

public class Student {
    private int id;
    private String name;
    private String course;
    private String learningMode;
    private String status;

    // Default constructor (required)
    public Student() {
    }

    // Constructor with parameters
    public Student(int id, String name, String course, String learningMode, String status) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.learningMode = learningMode;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public String getLearningMode() { return learningMode; }
    public void setLearningMode(String learningMode) { this.learningMode = learningMode; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
