package com.tutorial.springboot;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable("id") Integer id) {
        return enrollmentService.getEnrollmentById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
    }

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable("id") Integer id, @RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable("id") Integer id) {
        enrollmentService.deleteEnrollment(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudentId(@PathVariable("studentId") Integer studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }



    @PutMapping("/{enrollmentId}/grade")
    public Enrollment updateGrade(@PathVariable("enrollmentId") Integer enrollmentId, @RequestBody String grade) {
        return enrollmentService.updateGrade(enrollmentId, grade);
    }
}