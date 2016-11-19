package com.cloudcoders.gestaca.ui.controller;

import com.cloudcoders.gestaca.ui.View;
import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EnrollmentCommandShould {

  @Test
  public void
  call_to_show_all_courses() {
    View view = mock(View.class);
    EnrollmentCommand enrollmentCommand = new EnrollmentCommand(view);

    enrollmentCommand.execute();

    verify(view).showCourses(anyObject());
  }

  @Test
  public void
  ask_for_dni() {
    View view = mock(View.class);
    EnrollmentCommand enrollmentCommand = new EnrollmentCommand(view);

    enrollmentCommand.execute();

    verify(view).askDNI();
  }

  @Test
  public void
  ask_student() {
    View view = mock(View.class);
    EnrollmentCommand enrollmentCommand = new EnrollmentCommand(view);

    enrollmentCommand.execute();

    verify(view).askStudent();
  }

  @Test
  public void
  call_to_enrollment() {
    View view = mock(View.class);
    EnrollmentCommand enrollmentCommand = new EnrollmentCommand(view);

    enrollmentCommand.execute();

  }

}