package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.TaughtCourse;
import java.util.List;

public interface ITaughtCourseDAO {

  void add(TaughtCourse taughtCourse);

  TaughtCourse remove(TaughtCourse taughtCourse);

  TaughtCourse get(int id);

  List<TaughtCourse> getAll();
}
