package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.ReadFileException;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements ICourseDAO {

  private final JsonParser parser;
  private final FileDAL fileDAL;

  public CourseDAOImpl(FileDAL fileDAL, JsonParser jsonParser) {
    this.fileDAL = fileDAL;
    this.parser = jsonParser;
  }

  @Override
  public Course get(String name) {
    Course res = null;
    for (Course c : getAll()) {
      System.out.println(c.getName());
      System.out.println(name);
      if (c.getName().equals(name)) {
        res = c;
      }
    }

    return res;
  }

  @Override
  public List<Course> getAll() {
    try {
      String json = fileDAL.readFile("Course.json");
      List<Course> courses = parser.toObjectList(json, Course[].class);
      return courses;
    } catch (ReadFileException e) {
      e.printStackTrace(); //TODO throw model exceptions
    }
    return new ArrayList<>();
  }

  @Override
  public void add(Course newCourse) {
    int newId = (int) System.currentTimeMillis();

    try {
      List<Course> courses = getAll();

      boolean isUnique = !courses.stream()
          .filter(it -> it.getId() == newId)
          .findFirst()
          .isPresent();

      if (isUnique) {
        Course course = new Course(newCourse.getDescription(), newCourse.getName(), newId);
        courses.add(course);
        String coursesJson = parser.toJson(courses);
        fileDAL.writeFile("Course.json", coursesJson);
      }
    } catch (WriteFileException e) {
      e.printStackTrace(); //TODO throw model exceptions
    }

  }

  @Override
  public Course remove(Course course) {
    return null;
  }
}
