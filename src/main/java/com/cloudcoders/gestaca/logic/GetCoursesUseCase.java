package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public class GetCoursesUseCase {
  ICourseDAO icourseDAO;

  public GetCoursesUseCase(ICourseDAO icourseDAO){
    this.icourseDAO = icourseDAO;
  }

  public List<Course> getcourses(){
    return icourseDAO.getAll();
  }
}
