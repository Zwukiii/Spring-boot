package com.tutorial.springboot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Return an enrollment by ID
    public Optional<Enrollment> getEnrollmentById(Integer id) {
        return enrollmentRepository.findById(id);
    }

    // Create a new enrollment
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }


    public Enrollment updateEnrollment(Integer id, Enrollment enrollmentDetails) {
        return enrollmentRepository.findById(id)
                .map(existingEnrollment -> {
                    existingEnrollment.setStudentId(enrollmentDetails.getStudentId());
                    existingEnrollment.setCourseId(enrollmentDetails.getCourseId());
                    existingEnrollment.setEnrollmentDate(enrollmentDetails.getEnrollmentDate());
                    existingEnrollment.setGrade(enrollmentDetails.getGrade());
                    return enrollmentRepository.save(existingEnrollment);
                })
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id " + id));
    }

    public void deleteEnrollment(Integer id) {
        enrollmentRepository.deleteById(id);
    }

    public List<Enrollment> getEnrollmentsByStudentId(Integer studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public Enrollment updateGrade(Integer enrollmentId, String grade) {
        return enrollmentRepository.findById(enrollmentId)
                .map(enrollment -> {
                    enrollment.setGrade(grade);
                    return enrollmentRepository.save(enrollment);
                })
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id " + enrollmentId));


    }
}
