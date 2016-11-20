package com.cloudcoders.gestaca.logic.enrollment;

import com.cloudcoders.gestaca.logic.IEnrollmentDAO;
import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;
import com.cloudcoders.gestaca.logic.exceptions.InvalidPersonException;
import com.cloudcoders.gestaca.logic.exceptions.InvalidTaughtCourse;
import com.cloudcoders.gestaca.model.Enrollment;

public class AddEnrollment  {

  IEnrollmentDAO iEnrollmentDAO;
  ITaughtCourseDAO iTaughtCourseDAO;
  IStudentDAO iStudentDAO;

  public AddEnrollment(IEnrollmentDAO iEnrollmentDAO, ITaughtCourseDAO iTaughtCourseDAO, IStudentDAO iStudentDAO) {
    this.iEnrollmentDAO = iEnrollmentDAO;
    this.iTaughtCourseDAO = iTaughtCourseDAO;
    this.iStudentDAO = iStudentDAO;
  }

  public void add(Enrollment enrollment) throws InvalidPersonException, InvalidTaughtCourse {

    if (iStudentDAO.get(enrollment.getStudent().getId()) == null) {
      throw new InvalidPersonException("Invalid person!");
    }

    if (iTaughtCourseDAO.get(enrollment.getTaughtCourse().getId()) == null) {
      throw  new InvalidTaughtCourse("Invalid TaughtCourse Madafaka");
    }

     iEnrollmentDAO.add(enrollment);
  }
}
