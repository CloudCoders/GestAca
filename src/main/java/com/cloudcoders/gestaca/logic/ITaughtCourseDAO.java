package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.TaughtCourse;
import com.sun.tools.javac.util.List;

public interface ITaughtCourseDAO {
  boolean add(TaughtCourse taughtCourse);
  boolean addAll(List<TaughtCourse> taughtCourses);
  TaughtCourse remove(int id);
  List<TaughtCourse> removeAll();
  TaughtCourse get(int id);
  List<TaughtCourse> getAll();
}
