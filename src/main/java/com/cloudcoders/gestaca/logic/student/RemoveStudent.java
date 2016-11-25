package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.persistance.PersistenceException;

public class RemoveStudent {
  IStudentDAO iStudentDAO;

  public RemoveStudent(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public Student remove(Student student) {
    try {
      return iStudentDAO.remove(student);
    } catch (PersistenceException e) {
      e.printStackTrace();
    }
    return null;
  }
}
