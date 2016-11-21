package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

public class CourseDAOImplTest {

  private FileDAL fileDAL;
  private JsonParser jsonParser;

  @Before
  public void setup() {
    fileDAL = new FileDAL();
    jsonParser = new JsonParser(new Gson());
    List<Course> courses = new ArrayList<>();
    String coursesJson = jsonParser.toJson(courses);
    try {
      fileDAL.writeFile("Course.json", coursesJson);
    } catch (WriteFileException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void should_add_course() {
    Course course = new Course("Test", "Course_Test", 0);
    CourseDAOImpl courseDAO = new CourseDAOImpl(fileDAL, jsonParser);

    int prevLength = 0;
    int postLength = 0;
    Course res = null;
    try {
      prevLength = courseDAO.getAll().size();
      courseDAO.add(course);
      postLength = courseDAO.getAll().size();
      res = courseDAO.getAll().get(postLength-1);
    } catch (PersistenceException e) {
      e.printStackTrace();
    }

    assertThat(prevLength, is(postLength-1));
    assertThat(course.getName(), is(res.getName()));
    assertThat(course.getDescription(), is(res.getDescription()));
    assertThat(course.getId(), is(not(res.getId())));

  }

  @Test
  public void should_read_course() {
    JsonParser jsonParser = new JsonParser(new Gson());
    CourseDAOImpl courseDAO = new CourseDAOImpl(fileDAL, jsonParser);
    Course expected = new Course("Test", "Course_Test", 0);

    Course actual = null;
    try {
      courseDAO.add(expected);
      actual = courseDAO.get("Course_Test");
    } catch (PersistenceException e) {
      e.printStackTrace();
    }

    assertEquals(actual.getName(), expected.getName());
    assertEquals(actual.getDescription(), expected.getDescription());

  }

}