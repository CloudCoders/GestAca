package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;
import com.sun.org.apache.xpath.internal.operations.String;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements ICourseDAO{

  private JsonParser parser = new JsonParser();


  @Override
  public Course get(String name) {
    return null;
  }

  @Override
  public List<Course> getAll() {
    List<Course> courses = new ArrayList<>();
    JSONArray jsonArray = null;

    try {
       jsonArray = parser.readFile("Course.json");
    } catch (IOException e) {
      e.printStackTrace();
    }

    for(Object o : jsonArray) {
      JSONObject jsonObject = (JSONObject) o;
      String description = (String) jsonObject.get("description");
      String name = (String) jsonObject.get("name");
      int id = (int) jsonObject.get("id");

      Course aux = new Course(description, name, id);
      courses.add(aux);
    }

    return courses;
  }

  @Override
  public boolean add(Course course) {
    JSONObject aux = new JSONObject();
    aux.put("description", course.getDescription());
    aux.put("name", course.getName());
    aux.put("id", course.getId());
    aux.put("taughtCourses", course.getTaughtCourses());

    JSONArray jsonArray = null;

    try {
      jsonArray = parser.readFile("Course.json");
    } catch (IOException e) {
      e.printStackTrace();
    }

    jsonArray.put(aux);
    try {
      parser.writeFile("Course.json", jsonArray);
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  @Override
  public Course remove(Course course) {
    return null;
  }
}
