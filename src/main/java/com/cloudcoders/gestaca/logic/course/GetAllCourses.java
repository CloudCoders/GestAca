package com.cloudcoders.gestaca.logic.course;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;

import java.util.List;

public class GetAllCourses {
  ICourseDAO icourseDAO;

  public GetAllCourses(ICourseDAO icourseDAO) {
    this.icourseDAO = icourseDAO;
  }

  public List<Course> getCourses() {
    return icourseDAO.getAll();
  }
}
