package com.cloudcoders.gestaca.logic.taughtcourse;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;
import com.cloudcoders.gestaca.model.TaughtCourse;

public class RemoveTaughtCourse {
  private ITaughtCourseDAO iTaughtCourseDAO;

  public RemoveTaughtCourse(ITaughtCourseDAO iTaughtCourseDAO) {
    this.iTaughtCourseDAO = iTaughtCourseDAO;
  }

  public TaughtCourse remove(TaughtCourse taughtCourse) {
    return iTaughtCourseDAO.remove(taughtCourse);
  }
}
