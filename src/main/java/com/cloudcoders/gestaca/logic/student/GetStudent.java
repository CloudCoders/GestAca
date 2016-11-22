package com.cloudcoders.gestaca.logic.student;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.persistance.PersistenceException;

public class GetStudent {

  private IStudentDAO iStudentDAO;

  public GetStudent(IStudentDAO iStudentDAO) {
    this.iStudentDAO = iStudentDAO;
  }

  public Student getStudent(String dni) {
    try {
      return iStudentDAO.get(dni);
    } catch (PersistenceException e) {
      e.printStackTrace(); //TODO handle exception properly
      return null;
    }
  }
}
