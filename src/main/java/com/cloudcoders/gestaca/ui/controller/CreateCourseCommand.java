package com.cloudcoders.gestaca.ui.controller;

import com.cloudcoders.gestaca.logic.course.AddCourse;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.ui.View;

public class CreateCourseCommand implements Command {

  public static final String CREATE_CURSE = "crear curso";

  private View view;
  private AddCourse addCourse;

  public CreateCourseCommand(View view, AddCourse addCourse) {
    this.view = view;
    this.addCourse = addCourse;
  }

  @Override
  public boolean matches(String cmd) {
    return cmd.equals(CREATE_CURSE);
  }

  @Override
  public void execute() {
    Course course = view.askCreateCourse();
    addCourse.add(course);
  }
}
