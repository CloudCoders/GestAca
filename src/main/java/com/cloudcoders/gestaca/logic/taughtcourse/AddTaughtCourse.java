package com.cloudcoders.gestaca.logic.taughtcourse;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;
import com.cloudcoders.gestaca.model.TaughtCourse;
import com.cloudcoders.gestaca.persistance.PersistenceException;

public class AddTaughtCourse {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public AddTaughtCourse(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void add(TaughtCourse taughtCourse) {
    try {
      iTaughtCourseDAO.add(taughtCourse);
    } catch (PersistenceException e) {
      e.printStackTrace(); //TODO handle exception properly
    }
  }
}
