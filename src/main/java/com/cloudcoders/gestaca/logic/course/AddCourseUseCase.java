package com.cloudcoders.gestaca.logic.course;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;

public class AddCourseUseCase {
  ICourseDAO iCourseDAO;

  public AddCourseUseCase(ICourseDAO iCourseDAO) {
    this.iCourseDAO = iCourseDAO;
  }

  public void add(Course course) {
    iCourseDAO.add(course);
  }
}
