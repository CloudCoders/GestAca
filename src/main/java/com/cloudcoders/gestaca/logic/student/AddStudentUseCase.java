package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;

public class AddStudentUseCase {
  IStudentDAO iStudentDAO;

  public AddStudentUseCase(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public void add(Student student) {
      iStudentDAO.add(student);
  }
}
