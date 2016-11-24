package com.cloudcoders.gestaca.ui;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public interface View {
  void showCourses(List<Course> courseList);

  void showEmptyCourses();

  Course askCourse();

  String askDNI();

  void showStudentNotFound();

  void showStudentFoundAndEnrolled();

  void showStudentEnrolled();

  void showStudentFoundAndNotEnrolled();

  Student askStudent();

  void showStudent(Student student);

  Course askCreateCourse();

  void showCurseCreated();

  void showCurseAlreadyExists();
}
