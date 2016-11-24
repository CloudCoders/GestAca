package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.*;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNot.not;

public class EnrollmentDAOImplTest {

  private FileDAL fileDAL;
  private JsonParser jsonParser;

  @Before
  public void setup() {
    fileDAL = new FileDAL();
    jsonParser = new JsonParser(new Gson());
    List<Enrollment> enrollments = new ArrayList<>();
    String enrollmentsJson = jsonParser.toJson(enrollments);
    try {
      fileDAL.writeFile("Enrollment.json", enrollmentsJson);
    } catch (WriteFileException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void should_add_enrollment() {
    Office office = new Office(1, "X", System.currentTimeMillis());
    Teacher teacher = new Teacher(1234, "Calle false", "1234", "Juan", "Prueba");
    Course course = new Course("Prueba", "Prueba", System.currentTimeMillis());
    TaughtCourse taughtCourse = new TaughtCourse(1, 1, new Date(), 1, "X", new Date(),
        System.currentTimeMillis(), office, teacher, course);
    Student student = new Student(1234, "1234", "1234", "Juan", "1234");
    Enrollment enrollment = new Enrollment(
        new Date(),
        new Date(),
        true,
        0,
        taughtCourse,
        student);
    EnrollmentDAOImpl enrollmentDAO = new EnrollmentDAOImpl(fileDAL, jsonParser);

    int prevLength = 0;
    int postLength = 0;
    Enrollment res = null;
    try {
      prevLength = enrollmentDAO.getAll().size();
      enrollmentDAO.add(enrollment);
      postLength = enrollmentDAO.getAll().size();
      res = enrollmentDAO.getAll().get(postLength-1);
    } catch (PersistenceException e) {
      e.printStackTrace();
    }

    assertThat(prevLength, is(postLength-1));
    assertThat(enrollment.getId(), is(not(res.getId())));
    assertThat(enrollment.isUniquePayment(), is(res.isUniquePayment()));
    assertThat(enrollment.getTaughtCourse().getId(), is(res.getTaughtCourse().getId()));
    assertThat(enrollment.getStudent().getId(), is(res.getStudent().getId()));
  }

}