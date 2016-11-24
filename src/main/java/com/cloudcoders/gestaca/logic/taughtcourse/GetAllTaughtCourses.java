package com.cloudcoders.gestaca.logic.taughtcourse;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;
import com.cloudcoders.gestaca.persistance.PersistenceException;

public class GetAllTaughtCourses {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public GetAllTaughtCourses(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void getAll() {
    try {
      iTaughtCourseDAO.getAll();
    } catch (PersistenceException e) {
      e.printStackTrace(); //TODO handle exception properly
    }
  }
}
