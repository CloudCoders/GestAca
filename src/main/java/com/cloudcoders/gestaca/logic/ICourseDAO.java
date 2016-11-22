package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.PersistenceException;

import java.util.List;

public interface ICourseDAO {

  Course get(String name) throws PersistenceException;

  List<Course> getAll() throws PersistenceException;

  void add(Course course) throws PersistenceException;

  Course remove(Course course);

}

