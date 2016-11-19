package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.TaughtCourse;

public class AddTaughtCourseUseCase {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public AddTaughtCourseUseCase(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }
  public void add(TaughtCourse taughtCourse){
    iTaughtCourseDAO.add(taughtCourse);
  }
}
