package com.cloudcoders.gestaca.logic.course;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;

import java.util.List;

public class GetAllCoursesUseCase {
  ICourseDAO icourseDAO;

  public GetAllCoursesUseCase(ICourseDAO icourseDAO) {
    this.icourseDAO = icourseDAO;
  }

  public List<Course> getcourses() {
    return icourseDAO.getAll();
  }
}
