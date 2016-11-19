package com.cloudcoders.gestaca.ui.controller;

import com.cloudcoders.gestaca.logic.course.GetAllCourses;
import com.cloudcoders.gestaca.logic.enrollment.AddEnrollment;
import com.cloudcoders.gestaca.logic.student.GetStudent;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.ui.View;

import java.util.List;

public class EnrollmentCommand implements Command {

  public static final String ENROLLMENT = "inscribir alumno";

  private View view;
  private GetStudent getStudentUseCase;
  private GetAllCourses getAllCoursesUseCase;
  private AddEnrollment addEnrollment;

  public EnrollmentCommand(View view,
                           GetStudent getStudentUseCase,
                           GetAllCourses getAllCoursesUseCase,
                           AddEnrollment addEnrollment) {
    this.view = view;
    this.getStudentUseCase = getStudentUseCase;
    this.getAllCoursesUseCase = getAllCoursesUseCase;
    this.addEnrollment = addEnrollment;
  }


  @Override
  public boolean matches(String cmd) {
    return cmd.equals(ENROLLMENT);
  }

  public void execute() {
    List<Course> courses = getAllCoursesUseCase.getCourses();

    if (courses.isEmpty()) {
      view.showEmptyCourses();
      return;
    }

    view.showCourses(courses);
    Course course = view.askCourse();
    String dni = view.askDNI();
    Student student = getStudentUseCase.getStudent(dni);
    if (student == null) {
      student = view.askStudent();
    }


  }

}
