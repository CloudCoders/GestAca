package com.cloudcoders.gestaca.ui.controller;

import com.cloudcoders.gestaca.logic.student.GetStudent;
import com.cloudcoders.gestaca.model.Enrollment;
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
    getEnrollment(view);

    verify(view).showCourses(anyObject());
  }

  private void getEnrollment(View view) {
    EnrollmentCommand enrollmentCommand = new EnrollmentCommand(view);

    enrollmentCommand.execute();
  }

  @Test
  public void
  ask_for_dni() {
    View view = mock(View.class);
    getEnrollment(view);

    verify(view).askDNI();
  }

  @Test
  public void
  ask_student() {
    View view = mock(View.class);
    getEnrollment(view);

    verify(view).askStudent();
  }

  @Test
  public void
  call_to_enrollment() {
    View view = mock(View.class);
    getEnrollment(view);

  }

}