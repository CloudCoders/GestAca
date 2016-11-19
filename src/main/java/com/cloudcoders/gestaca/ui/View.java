package com.cloudcoders.gestaca.ui;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public interface View {
    void showCourses(List<Course> courseList);
    Course askCourse();
    String askDNI();
    void showStudentNotFound();
    void showStudentFoundAndEnrolled();
    void showStudentEnrolled();
    Student askStudent();
}
