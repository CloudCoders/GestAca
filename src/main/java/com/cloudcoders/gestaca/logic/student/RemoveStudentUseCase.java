package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;

public class RemoveStudentUseCase {
  IStudentDAO iStudentDAO;

  public RemoveStudentUseCase(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public Student remove(Student student) {
    return iStudentDAO.remove(student);
  }
}
