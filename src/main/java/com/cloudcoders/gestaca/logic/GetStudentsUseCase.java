package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public class GetStudentsUseCase {

  private IStudentDAO iStudentDAO;

  public GetStudentsUseCase(IStudentDAO iStudentDAO){
    this.iStudentDAO = iStudentDAO;
  }

  public List<Student> getStudents(){
    return iStudentDAO.getAll();
  }
}
