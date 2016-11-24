package com.cloudcoders.gestaca.ui.controller;

public class Processor {

  private EnrollmentCommand enrollmentCommand;
  private CreateCourseCommand createCommand;

  public Processor(EnrollmentCommand enrollmentCommand, CreateCourseCommand createCommand) {
    this.enrollmentCommand = enrollmentCommand;
    this.createCommand = createCommand;
  }

  public Command process(String commandLine) {
    Command command = null;

    switch (commandLine) {
      case EnrollmentCommand.ENROLLMENT:
        command = enrollmentCommand;
        break;
      case CreateCourseCommand.CREATE_CURSE:
        command = createCommand;
        break;
    }

    return command;
  }

}
