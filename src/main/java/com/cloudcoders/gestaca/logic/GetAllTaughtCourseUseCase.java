package com.cloudcoders.gestaca.logic;

public class GetAllTaughtCourseUseCase {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public GetAllTaughtCourseUseCase(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void getAll(){
    iTaughtCourseDAO.getAll();
  }
}
