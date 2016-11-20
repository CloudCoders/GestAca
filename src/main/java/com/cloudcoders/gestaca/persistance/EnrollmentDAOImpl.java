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
  public List<Enrollment> getAll() {
    String json = null;
    try {
      json = fileDAL.readFile("Enrollment.json");
      List<Enrollment> enrollments = jsonParser.toObjectList(json, Enrollment[].class);
    } catch (ReadFileException e) {
      e.printStackTrace(); //TODO throws model exception
    }
    return new ArrayList<>();
  }

  @Override
  public void add(Enrollment enrollment) {
    int newId = (int) System.currentTimeMillis();

    try {
      List<Enrollment> enrollments = getAll();

      Enrollment newEnrollment = new Enrollment(enrollment.getCancellationDate(),
          enrollment.getEnrollemntDate(),
          enrollment.isUniquePayment(),
          newId, enrollment.getTaughtCourse(), enrollment.getStudent());

      enrollments.add(newEnrollment);
      String enrollmentsJson = jsonParser.toJson(enrollments);
      fileDAL.writeFile("Enrollment.json", enrollmentsJson);
    } catch (WriteFileException e) {
      e.printStackTrace(); //TODO throws model exception
    }
  }

  @Override
  public Enrollment remove(Enrollment enrollment) {
    return null;
  }
}
