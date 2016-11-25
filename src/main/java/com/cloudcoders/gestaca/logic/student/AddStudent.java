package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.persistance.PersistenceException;

public class AddStudent {
  IStudentDAO iStudentDAO;

  public AddStudent(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public void add(Student student) {
    try {
      iStudentDAO.add(student);
    } catch (PersistenceException e) {
      e.printStackTrace(); //TODO handle exception properly
    }
  }
}
