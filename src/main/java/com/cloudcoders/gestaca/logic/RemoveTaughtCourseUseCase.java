package com.cloudcoders.gestaca.logic;

public class RemoveTaughtCourseUseCase {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public RemoveTaughtCourseUseCase(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void remove(int id){
    iTaughtCourseDAO.remove(id);
  }
}
