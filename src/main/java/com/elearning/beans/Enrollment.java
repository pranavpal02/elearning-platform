package com.elearning.beans;

public class Enrollment {
    private int studentId;
    private int courseId;
    private String completionStatus;  // Completion status field (e.g., "completed" or "in-progress")

    // Constructor
    public Enrollment(int studentId, int courseId, String completionStatus) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.completionStatus = completionStatus;
    }

    // Getter and Setter for studentId
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter and Setter for courseId
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    // Getter and Setter for completionStatus
    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }
}
