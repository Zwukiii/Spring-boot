package com.tutorial.springboot;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentId;
    private Integer courseId; // Make sure this field exists
    private LocalDate enrollmentDate;
    private String grade;
    private int transcript;

    public Enrollment(Integer id, Integer studentId, LocalDate enrollmentDate, String grade, Integer courseId, int transcript) {
        this.id = id;
        this.studentId = studentId;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
        this.courseId = courseId;
        this.transcript = transcript;
    }

    public Enrollment() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getTranscript() {
        return transcript;
    }

    public void setTranscript(int transcript) {
        this.transcript = transcript;
    }
}
