package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Student;

public class AddStudentUseCase {
  IStudentDAO iStudentDAO;

  public AddStudentUseCase(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public void add(Student student){
    try{
      iStudentDAO.add(student);
    }catch(Exception e){
      System.err.println(e);
    }
  }
}
