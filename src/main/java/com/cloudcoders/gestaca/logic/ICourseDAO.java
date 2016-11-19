package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.PersistenceException;

import java.util.List;

public interface ICourseDAO {
  Course get(String name);
  List<Course> getAll();
  boolean add(Course course);
  Course remove(Course course);
}
