package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.TaughtCourse;

import java.util.List;

public interface ITaughtCourseDAO {
  boolean add(TaughtCourse taughtCourse);
  TaughtCourse remove(int id);
  TaughtCourse get(int id);
  List<TaughtCourse> getAll();
}
