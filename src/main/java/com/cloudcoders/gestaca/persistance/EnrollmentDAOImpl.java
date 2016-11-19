package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.IEnrollmentDAO;
import com.cloudcoders.gestaca.model.Absence;
import com.cloudcoders.gestaca.model.Enrollment;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.model.TaughtCourse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EnrollmentDAOImpl implements IEnrollmentDAO {

  private JsonParser parser;

  public EnrollmentDAOImpl(JsonParser p) {
    this.parser = p;
  }

  @Override
  public Enrollment get(int id) {
    return null;
  }

  @Override
  public List<Enrollment> getAll() {
    List<Enrollment> enrollments = new ArrayList<>();
    JSONArray jsonArray = null;

    try {
      jsonArray = parser.readFile("Enrollment.json");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    for(Object o : jsonArray) {
      JSONObject jsonObject = (JSONObject) o;
      Date cancellationDate = (Date) jsonObject.get("cancellationDate");
      Date enrollmentDate = (Date) jsonObject.get("enrollmentDate");
      boolean uniquePayment = (boolean) jsonObject.get("uniquePayment");
      int id = (int) jsonObject.get("id");
      TaughtCourse taughtCourse = (TaughtCourse) jsonObject.get("taughtCourse");
      Student student = (Student) jsonObject.get("student");
      List<Absence> absences = (List<Absence>) jsonObject.get("absences");

      Enrollment aux;
      if(absences != null) {
        aux = new Enrollment(
            cancellationDate,
            enrollmentDate,
            uniquePayment,
            id,
            absences,
            taughtCourse,
            student);
      } else {
        aux = new Enrollment(
            cancellationDate,
            enrollmentDate,
            uniquePayment,
            id,
            taughtCourse,
            student);
      }

      enrollments.add(aux);
    }

    return enrollments;
  }

  @Override
  public void add(Enrollment enrollment) {
    JSONObject aux = new JSONObject();
    aux.put("cancellationDate", enrollment.getCancellationDate());
    aux.put("enrollmentDate", enrollment.getEnrollemntDate());
    aux.put("uniquePayment", enrollment.isUniquePayment());
    aux.put("id", enrollment.getId());
    aux.put("taughtCourse", enrollment.getTaughtCourse());
    aux.put("student", enrollment.getStudent());
    aux.put("absences", enrollment.getAbsences());

    JSONArray jsonArray = null;

    try {
      jsonArray = parser.readFile("Enrollment.json");
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    boolean idIsUnique = true;
    for (Iterator<Object> iterator = jsonArray.iterator(); iterator.hasNext() && idIsUnique; ) {
      Object o = iterator.next();
      JSONObject jsonObject = (JSONObject) o;
      if(((int) jsonObject.get("id")) == enrollment.getId()) {
        idIsUnique = false;
      }
    }

    if (idIsUnique) {
      jsonArray.put(aux);
      try {
        parser.writeFile("Enrollment.json", jsonArray);
      } catch (URISyntaxException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public Enrollment remove(Enrollment enrollment) {
    return null;
  }
}
