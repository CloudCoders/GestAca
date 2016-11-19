package com.cloudcoders.gestaca.ui.controller;

import com.cloudcoders.gestaca.ui.View;

public class CreateCourseCommand implements Command {

  public static final String CREATE_CURSE = "crear curso";

  private View view;

  public CreateCourseCommand(View view) {
    this.view = view;
  }

  @Override
  public boolean matches(String cmd) {
    return cmd.equals(CREATE_CURSE);
  }

  @Override
  public void execute() {

  }
}
