package com.cloudcoders.gestaca.ui.controller;

import com.cloudcoders.gestaca.logic.course.GetAllCourses;
import com.cloudcoders.gestaca.logic.enrollment.AddEnrollment;
import com.cloudcoders.gestaca.logic.student.AddStudent;
import com.cloudcoders.gestaca.logic.student.GetStudent;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.ui.View;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
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
    GetStudent getStudent = mock(GetStudent.class);
    GetAllCourses getAllCourses = mock(GetAllCourses.class);
    given(getAllCourses.getCourses()).willReturn(Arrays.asList(new Course("", "", 0)));
    AddEnrollment addEnrollment = mock(AddEnrollment.class);
    AddStudent addStudent = mock(AddStudent.class);
    EnrollmentCommand enrollmentCommand = new EnrollmentCommand(view, getStudent, getAllCourses, addEnrollment, addStudent);

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

}