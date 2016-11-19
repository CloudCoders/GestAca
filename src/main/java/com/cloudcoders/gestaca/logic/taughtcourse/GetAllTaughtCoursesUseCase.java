package com.cloudcoders.gestaca.logic.taughtcourse;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;

public class GetAllTaughtCoursesUseCase {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public GetAllTaughtCoursesUseCase(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void getAll() {
    iTaughtCourseDAO.getAll();
  }
}
