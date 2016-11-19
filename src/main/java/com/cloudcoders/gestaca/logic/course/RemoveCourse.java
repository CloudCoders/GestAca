package com.cloudcoders.gestaca.logic.course;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;

public class RemoveCourse {

  ICourseDAO iCourseDAO;

  public RemoveCourse(ICourseDAO iCourseDAO) {
    this.iCourseDAO = iCourseDAO;
  }

  public Course remove(Course course) {
    return iCourseDAO.remove(course);
  }
}
