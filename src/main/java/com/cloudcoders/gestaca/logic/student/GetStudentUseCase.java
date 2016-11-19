package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public class GetStudentUseCase {

  private IStudentDAO iStudentDAO;

  public GetStudentUseCase(IStudentDAO iStudentDAO){
    this.iStudentDAO = iStudentDAO;
  }

  public Student getStudent(String name){
    return iStudentDAO.get(name);
  }
}
