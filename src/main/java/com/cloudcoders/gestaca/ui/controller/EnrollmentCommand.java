package com.cloudcoders.gestaca.ui.controller;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.ui.View;

public class EnrollmentCommand implements Command {

  public static final String ENROLLMENT = "inscribir alumno";

  private View view;

  public EnrollmentCommand(View view) {
    this.view = view;
  }

  @Override
  public boolean matches(String cmd) {
    return cmd.equals(ENROLLMENT);
  }

  public void execute() {
    view.showCourses(null);
    Course course = view.askCourse();
    String s = view.askDNI();
    Student student = view.askStudent();
  }

}
