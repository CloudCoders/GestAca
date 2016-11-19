package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.ICourseDAO;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.TaughtCourse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseDAOImpl implements ICourseDAO{

  private JsonParser parser;

  public CourseDAOImpl(JsonParser parser) {
    this.parser = parser;
  }

  @Override
  public Course get(String name) {
    List<Course> courses = new ArrayList<>();
    JSONArray jsonArray = null;

    try {
      jsonArray = parser.readFile("Course.json");
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    Course res;
    for (Object o : jsonArray) {
      JSONObject aux = (JSONObject) o;
      if (aux.get("name") == name) {
        if (aux.get("taughtCourses") != null) {
          res = new Course(
              (String) aux.get("description"),
              (String) aux.get("name"),
              (int) aux.get("id"),
              (List<TaughtCourse>) aux.get("taughtCourses"));
        } else {
          res = new Course(
              (String) aux.get("description"),
              (String) aux.get("name"),
              (int) aux.get("id"));
        }
        return res;
      }
    }

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
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    for(Object o : jsonArray) {
      JSONObject jsonObject = (JSONObject) o;
      String description = (String) jsonObject.get("description");
      String name = (String) jsonObject.get("name");
      int id = (int) jsonObject.get("id");
      JSONArray taughtCoursesJSON = (JSONArray) jsonObject.get("taughtCourses");

      Course aux = new Course(description, name, id);
      courses.add(aux);
    }

    return courses;
  }

  @Override
  public void add(Course course) {
    JSONObject aux = new JSONObject();
    aux.put("description", course.getDescription());
    aux.put("name", course.getName());
    int newId = (int) System.currentTimeMillis();
    aux.put("id", newId);
    aux.put("taughtCourses", course.getTaughtCourses());

    JSONArray jsonArray = null;

    try {
      jsonArray = parser.readFile("Course.json");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    boolean idIsUnique = true;
    for (Iterator<Object> iterator = jsonArray.iterator(); iterator.hasNext() && idIsUnique; ) {
      Object o = iterator.next();
      JSONObject jsonObject = (JSONObject) o;
      if (((int) jsonObject.get("id")) == course.getId()) {
        idIsUnique = false;
      }
    }

    if (idIsUnique) {
      jsonArray.put(aux);
      try {
        parser.writeFile("Course.json", jsonArray);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    }

  }

  @Override
  public Course remove(Course course) {
    return null;
  }
}
