package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.TaughtCourse;
import com.sun.tools.javac.util.List;

public interface ITaughtCourseDAO {
  boolean addTaughtCourse(TaughtCourse taughtCourse);
  boolean addAllTaughtCourses(List<TaughtCourse> taughtCourses);
  TaughtCourse removeTaughtCourseBy(int id);
  List<TaughtCourse> removeAllTaughtCourses();
  TaughtCourse getTaughtCourseBy(int id);
  List<TaughtCourse> getAllTaughtCourses();
}
