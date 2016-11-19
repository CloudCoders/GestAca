package com.cloudcoders.gestaca.logic.enrollment;

import com.cloudcoders.gestaca.logic.IEnrollmentDAO;
import com.cloudcoders.gestaca.model.Enrollment;

public class AddEnrollment {
  IEnrollmentDAO iEnrollmentDAO;


  public AddEnrollment(IEnrollmentDAO iEnrollmentDAO) {
    this.iEnrollmentDAO = iEnrollmentDAO;
  }

  public void add(Enrollment enrollment) {
     iEnrollmentDAO.add(enrollment);
  }
}
