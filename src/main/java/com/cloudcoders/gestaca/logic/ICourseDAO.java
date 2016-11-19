package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Course;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.List;

public interface ICourseDAO {
  Course get(String name);
  List<Course> getAll();
  boolean add(Course course);
  Course remove(Course course);
}
