package com.cloudcoders.gestaca.logic;

public class GetTaughtCourseUseCase {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public GetTaughtCourseUseCase(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void get(int id){
    iTaughtCourseDAO.get(id);
  }
}
