package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Office;
import com.cloudcoders.gestaca.model.TaughtCourse;
import com.cloudcoders.gestaca.model.Teacher;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class TaughtCourseDAOImplTest {

  @Test
  public void should_add_taught_course() {
    TaughtCourseDAOImpl taughtCourseDAO = new TaughtCourseDAOImpl(new JsonParser());
    Office office = new Office(1, "X", 0);
    Teacher teacher = new Teacher(1234, "Calle false", "1234", "Juan", "Prueba");
    Course course = new Course("Prueba", "Prueba", 0);
    TaughtCourse result = new TaughtCourse(1, 1, new Date(), 1, "X", new Date(), 0, office, teacher, course);

    int prevLength = taughtCourseDAO.getAll().size();
    taughtCourseDAO.add(result);
    int postLength = taughtCourseDAO.getAll().size();
    TaughtCourse actual = taughtCourseDAO.getAll().get(postLength-1);


    assertThat(prevLength, is(postLength-1));
    assertThat(actual.getQuota(), is(result.getQuota()));
    assertThat(actual.getTotalPrice(), is(result.getTotalPrice()));
    assertThat(actual.getStartDate(), is(result.getStartDate()));
    assertThat(actual.getEndDate(), is(result.getEndDate()));
    assertThat(actual.getTeachingday(), is(result.getTeachingday()));
    assertThat(actual.getId(), is(not(result.getId())));

  }



}