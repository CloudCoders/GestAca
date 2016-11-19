package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;

public class RemoveStudent {
  IStudentDAO iStudentDAO;

  public RemoveStudent(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public Student remove(Student student) {
    return iStudentDAO.remove(student);
  }
}
