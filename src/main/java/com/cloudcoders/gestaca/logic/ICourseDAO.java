package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Course;
import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.tools.javac.util.List;

public interface ICourseDAO {
  Course getCourseBy(String name);
  List<Course> getAllCourses();
  boolean add(Course course);
  boolean addAll(List<Course> courses);
  Course remove(Course course);
  List<Course> removeAll();
}
