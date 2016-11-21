package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.ReadFileException;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl implements ICourseDAO {

  private final JsonParser parser;
  private final FileDAL fileDAL;

  public CourseDAOImpl(FileDAL fileDAL, JsonParser jsonParser) {
    this.fileDAL = fileDAL;
    this.parser = jsonParser;
  }

  @Override
  public Course get(String name) throws PersistenceException {
    try {

      Optional<Course> res = getAll()
          .stream()
          .filter(course -> course.getName().equals(name))
          .findFirst();
      return res.isPresent() ? res.get() : null;

    } catch (PersistenceException e) {
      throw e;
    }
  }

  @Override
  public List<Course> getAll() throws PersistenceException {
    try {
      String json = fileDAL.readFile("Course.json");
      List<Course> courses = parser.toObjectList(json, Course[].class);
      return courses;
    } catch (ReadFileException e) {
      throw new PersistenceException(e.getMessage());
    }
  }

  @Override
  public void add(Course newCourse) throws PersistenceException {
    long newId = System.currentTimeMillis();

    try {
      List<Course> courses = getAll();

      boolean isUnique = !courses.stream()
          .filter(it -> it.getId() == newId)
          .findFirst()
          .isPresent();

      if (isUnique) {
        Course course;
        course = new Course(newCourse.getDescription(), newCourse.getName(), newId);
        courses.add(course);
        String coursesJson = parser.toJson(courses);
        fileDAL.writeFile("Course.json", coursesJson);
      } else {
        throw new PersistenceException("Id is not unique");
      }
    } catch (WriteFileException | PersistenceException e) {
      throw new PersistenceException(e.getMessage());
    }

  }

  @Override
  public Course remove(Course course) {
    return null;
  }
}
