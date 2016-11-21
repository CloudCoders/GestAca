package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.TaughtCourse;
import com.cloudcoders.gestaca.persistance.PersistenceException;

import java.util.List;

public interface ITaughtCourseDAO {

  void add(TaughtCourse taughtCourse) throws PersistenceException;

  TaughtCourse remove(TaughtCourse taughtCourse);

  TaughtCourse get(long id);

  List<TaughtCourse> getAll() throws PersistenceException;
}
