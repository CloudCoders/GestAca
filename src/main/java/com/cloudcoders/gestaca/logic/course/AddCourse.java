package com.cloudcoders.gestaca.logic.course;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.PersistenceException;

public class AddCourse {
  ICourseDAO iCourseDAO;

  public AddCourse(ICourseDAO iCourseDAO) {
    this.iCourseDAO = iCourseDAO;
  }

  public void add(Course course) {
    try {
      iCourseDAO.add(course);
    } catch (PersistenceException e) {
      e.printStackTrace(); //TODO handle exception properly
    }
  }
}
