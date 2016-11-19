package com.cloudcoders.gestaca.logic.taughtcourse;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;

public class GetAllTaughtCourseUseCase {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public GetAllTaughtCourseUseCase(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void getAll(){
    iTaughtCourseDAO.getAll();
  }
}
