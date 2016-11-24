package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.IEnrollmentDAO;
import com.cloudcoders.gestaca.model.Enrollment;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.ReadFileException;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAOImpl implements IEnrollmentDAO {

  private FileDAL fileDAL;
  private JsonParser jsonParser;

  public EnrollmentDAOImpl(FileDAL fileDAL, JsonParser jsonParser) {
    this.fileDAL = fileDAL;
    this.jsonParser = jsonParser;
  }

  @Override
  public Enrollment get(int id) {
    return null;
  }

  @Override
  public List<Enrollment> getAll() throws PersistenceException {
    String json = null;
    try {
      json = fileDAL.readFile("Enrollment.json");
      List<Enrollment> enrollments = jsonParser.toObjectList(json, Enrollment[].class);
      return enrollments;
    } catch (ReadFileException e) {
      throw new PersistenceException(e.getMessage());
    }
  }

  @Override
  public void add(Enrollment newEnrollment) throws PersistenceException {
    long newId = System.currentTimeMillis();

    try {
      List<Enrollment> enrollments = getAll();

      boolean isUnique = !enrollments.stream()
          .filter(it -> it.getId() == newId)
          .findFirst()
          .isPresent();

      if(isUnique) {
        Enrollment enrollment = new Enrollment(newEnrollment.getCancellationDate(),
            newEnrollment.getEnrollemntDate(),
            newEnrollment.isUniquePayment(),
            newId, newEnrollment.getTaughtCourse(), newEnrollment.getStudent());

        enrollments.add(enrollment);
        String enrollmentsJson = jsonParser.toJson(enrollments);
        fileDAL.writeFile("Enrollment.json", enrollmentsJson);
      } else {
        throw new PersistenceException("Id is not unique");
      }
    } catch (WriteFileException | PersistenceException e) {
      throw new PersistenceException(e.getMessage());
    }
  }

  @Override
  public Enrollment remove(Enrollment enrollment) {
    return null;
  }
}
