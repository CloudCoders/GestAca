package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Course;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDAOImplTest {

  @Test
  public void shouldAddCourse() {
    Course course = new Course("Prueba", "Prueba", 0);
    CourseDAOImpl courseDAO = new CourseDAOImpl(new JsonParser());

    int prevLength = courseDAO.getAll().size();
    courseDAO.add(course);
    int postLength = courseDAO.getAll().size();
    Course res = courseDAO.getAll().get(postLength-1);

    assertEquals(prevLength, postLength-1);
    assertEquals(course.getName(), res.getName());
    assertEquals(course.getDescription(), res.getDescription());
    assertNotEquals(course.getId(), res.getId());


  }

}