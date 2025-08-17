package com.tutorial.springboot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Returns all the students in that course.
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Returns a course based on ID
    public Optional<Course> getCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    // Creates new course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Integer id, Course courseDetails) {
        return courseRepository.findById(id).map(existingCourse -> {
                    existingCourse.setCourseCode(courseDetails.getCourseCode());
                    existingCourse.setCourseName(courseDetails.getCourseName());
                    existingCourse.setInstructor(courseDetails.getInstructor());
                    existingCourse.setSemster(courseDetails.getSemster());
                    existingCourse.setCredits(courseDetails.getCredits());
                    return courseRepository.save(existingCourse);


                })
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    public Course deleteCourse(Integer id) {
        return courseRepository.findById(id)
                .map(c -> {
                    courseRepository.delete(c);
                    return c;
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id" + id));
    }

    public List<Course> getCoursesByInstructor(String instructor) {
        return courseRepository.findByInstructor(instructor);
    }
}
