package com.cloudcoders.gestaca.ui.controller;

public class Processor {

  private EnrollmentCommand enrollmentCommand;

  public Processor(EnrollmentCommand enrollmentCommand) {
    this.enrollmentCommand = enrollmentCommand;
  }

  public Command process(String commandLine) {
    Command command = null;

    switch (commandLine) {
      case EnrollmentCommand.ENROLLMENT:
        command = enrollmentCommand;
        break;
    }

    return command;
  }

}
