package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Course;
import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.tools.javac.util.List;

public interface ICourseDAO {
  Course getCourseBy(String name);
  List<Course> getAllCourses();
  boolean addCourse(Course course);
  boolean addAllCourses(List<Course> courses);
  Course removeCourseBy(String name);
  Course removeCourseBy(Course course);
  List<Course> removeAllCourses();
}
