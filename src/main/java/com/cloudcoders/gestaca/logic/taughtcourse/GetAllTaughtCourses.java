package com.cloudcoders.gestaca.logic.taughtcourse;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;

public class GetAllTaughtCourses {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public GetAllTaughtCourses(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void getAll() {
    iTaughtCourseDAO.getAll();
  }
}
