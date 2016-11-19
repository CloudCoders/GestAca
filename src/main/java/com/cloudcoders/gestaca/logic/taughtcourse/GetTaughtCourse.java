package com.cloudcoders.gestaca.logic.taughtcourse;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;

public class GetTaughtCourse {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public GetTaughtCourse(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void get(int id) {
    iTaughtCourseDAO.get(id);
  }
}
