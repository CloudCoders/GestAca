package com.cloudcoders.gestaca.logic.course;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.PersistenceException;

public class GetCourse {
  ICourseDAO iCourseDAO;


  public GetCourse(ICourseDAO iCourseDAO) {
    this.iCourseDAO = iCourseDAO;
  }

  public Course get(String name) {
    try {
      return this.iCourseDAO.get(name);
    } catch (PersistenceException e) {
      e.printStackTrace();
      return null; //TODO handle exception properly
    }
  }
}
