package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CourseDAOImplTest {

  @Test
  public void should_add_course() {
    Course course = new Course("Prueba", "Prueba", 0);
    FileDAL fileDAL = new FileDAL();
    JsonParser jsonParser = new JsonParser(new Gson());
    CourseDAOImpl courseDAO = new CourseDAOImpl(fileDAL, jsonParser);

    int prevLength = courseDAO.getAll().size();
    courseDAO.add(course);
    int postLength = courseDAO.getAll().size();
    Course res = courseDAO.getAll().get(postLength-1);

    assertEquals(prevLength, postLength-1);
    assertEquals(course.getName(), res.getName());
    assertEquals(course.getDescription(), res.getDescription());
    assertNotEquals(course.getId(), res.getId());


  }

  @Test
  public void should_read_course() {
    FileDAL fileDAL = new FileDAL();
    JsonParser jsonParser = new JsonParser(new Gson());
    CourseDAOImpl courseDAO = new CourseDAOImpl(fileDAL, jsonParser);
    Course expected = new Course("Test", "Course_Test", 0);
    Course actual = courseDAO.get("Course_Test");

    assertEquals(actual.getName(), expected.getName());
    assertEquals(actual.getDescription(), expected.getDescription());

  }

}