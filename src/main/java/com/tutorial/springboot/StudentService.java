package com.tutorial.springboot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, Student studentDetails) {

        return studentRepository.findById(id).map(student -> {
                    studentDetails.setId(studentDetails.getId());
                    studentDetails.setStudentNumber(student.getStudentNumber());
                    studentDetails.setFirstName(studentDetails.getFirstName());
                    studentDetails.setFirstName(studentDetails.getLastName());
                    studentDetails.setEmail(studentDetails.getEmail());
                    studentDetails.setMajor(studentDetails.getMajor());
                    studentDetails.setEnrollmentYear(studentDetails.getEnrollmentYear());
                    return studentRepository.save(student);


                })
                .orElseThrow(() -> new RuntimeException("Student not found with id" + id));

    }

    public Student deleteStudent(Integer id) {
        return studentRepository.findById(id)
                .map(s -> {
                    studentRepository.delete(s);
                    return studentRepository.save(s);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id" + id));
    }

    public List<Student> getStudentByMajor(String major) {
        return studentRepository.findByMajor(major);
    }
}
