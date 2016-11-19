package com.cloudcoders.gestaca.ui.controller;

import com.cloudcoders.gestaca.logic.course.GetAllCoursesUseCase;
import com.cloudcoders.gestaca.logic.student.GetStudentUseCase;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.ui.View;

import java.util.List;

public class EnrollmentCommand implements Command {

  public static final String ENROLLMENT = "inscribir alumno";

  private View view;
  private GetStudentUseCase getStudentUseCase;
  private GetAllCoursesUseCase getAllCoursesUseCase;

  public EnrollmentCommand(View view,
                           GetStudentUseCase getStudentUseCase,
                           GetAllCoursesUseCase getAllCoursesUseCase) {
    this.view = view;
    this.getStudentUseCase = getStudentUseCase;
    this.getAllCoursesUseCase = getAllCoursesUseCase;
  }

  @Override
  public boolean matches(String cmd) {
    return cmd.equals(ENROLLMENT);
  }

  public void execute() {
    List<Course> courses = getAllCoursesUseCase.getcourses();
    view.showCourses(courses);

    Course course = view.askCourse();
    String dni = view.askDNI();
    Student student = getStudentUseCase.getStudent(dni);
    if (student == null) {
      student = view.askStudent();
    }

  }

}
