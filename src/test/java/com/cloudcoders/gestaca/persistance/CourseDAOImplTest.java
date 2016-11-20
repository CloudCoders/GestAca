package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Course;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CourseDAOImplTest {

  @Test
  public void should_add_course() {
    Course course = new Course("Prueba", "Prueba", 0);
    CourseDAOImpl courseDAO = new CourseDAOImpl(new FileDAL());

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
    CourseDAOImpl courseDAO = new CourseDAOImpl(new FileDAL());
    Course expected = new Course("Test", "Course_Test", 0);
    Course actual = courseDAO.get("Course_Test");

    assertEquals(actual.getName(), expected.getName());
    assertEquals(actual.getDescription(), expected.getDescription());

  }

}