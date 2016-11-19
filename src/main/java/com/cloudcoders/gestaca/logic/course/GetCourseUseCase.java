package com.cloudcoders.gestaca.logic.course;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;

public class GetCourseUseCase {
  ICourseDAO iCourseDAO;


  public GetCourseUseCase(ICourseDAO iCourseDAO) {
    this.iCourseDAO = iCourseDAO;
  }

  public Course get(String name) {
    return this.iCourseDAO.get(name);
  }
}
