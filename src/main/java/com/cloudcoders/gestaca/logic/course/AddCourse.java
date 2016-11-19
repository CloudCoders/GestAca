package com.cloudcoders.gestaca.logic.course;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;

public class AddCourse {
  ICourseDAO iCourseDAO;

  public AddCourse(ICourseDAO iCourseDAO) {
    this.iCourseDAO = iCourseDAO;
  }

  public void add(Course course) {
    iCourseDAO.add(course);
  }
}
