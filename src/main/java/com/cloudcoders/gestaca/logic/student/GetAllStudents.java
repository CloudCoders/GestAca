package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public class GetAllStudents {

  private IStudentDAO iStudentDAO;

  public GetAllStudents(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public List<Student> getStudents() {
    return iStudentDAO.getAll();
  }
}
