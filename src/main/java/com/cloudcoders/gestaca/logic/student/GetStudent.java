package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;

public class GetStudent {

  private IStudentDAO iStudentDAO;

  public GetStudent(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public Student getStudent(String dni) {
    return iStudentDAO.get(dni);
  }
}
