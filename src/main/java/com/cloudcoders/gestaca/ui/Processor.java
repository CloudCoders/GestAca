package com.cloudcoders.gestaca.ui;

public class Processor {

  public Command process(String commandLine) {

    Command command = null;

    switch (commandLine) {
      case EnrollmentCommand.ENROLLMENT:
        command = new EnrollmentCommand();
        break;
    }

    return command;
  }

}
