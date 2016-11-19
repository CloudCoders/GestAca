package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;
import com.cloudcoders.gestaca.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaughtCourseDAOImpl implements ITaughtCourseDAO {

  private JsonParser parser;

  public TaughtCourseDAOImpl(JsonParser p) {
    this.parser = p;
  }

  @Override
  public void add(TaughtCourse taughtCourse) {
    JSONObject aux = new JSONObject();
    aux.put("quota", taughtCourse.getQuota());
    aux.put("sessionDuration", taughtCourse.getSessionDuration());
    aux.put("startDate", taughtCourse.getStartDate());
    aux.put("totalPrice", taughtCourse.getTotalPrice());
    aux.put("teachingday", taughtCourse.getTeachingday());
    aux.put("endDate", taughtCourse.getEndDate());
    aux.put("id", taughtCourse.getId());
    aux.put("office", taughtCourse.getOffice());
    aux.put("teacher", taughtCourse.getTeacher());
    aux.put("course", taughtCourse.getCourse());
    aux.put("enrollments", taughtCourse.getEnrollments());

    JSONArray jsonArray = null;

    try {
      jsonArray = parser.readFile("TaughtCourse.json");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    boolean idIsUnique = true;
    for (Iterator<Object> iterator = jsonArray.iterator(); iterator.hasNext() && idIsUnique; ) {
      Object o = iterator.next();
      JSONObject jsonObject = (JSONObject) o;
      if (((int) jsonObject.get("id")) == taughtCourse.getId()) {
        idIsUnique = false;
      }
    }

    if(idIsUnique) {
      jsonArray.put(aux);
      try {
        parser.writeFile("TaughtCourse.json", jsonArray);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    }

  }

  @Override
  public TaughtCourse remove(TaughtCourse taughtCourse) {
    return null;
  }

  @Override
  public TaughtCourse get(int id) {
    return null;
  }

  @Override
  public List<TaughtCourse> getAll() {
    List<TaughtCourse> taughtCourses = new ArrayList<>();
    JSONArray jsonArray = null;

    try {
      jsonArray = parser.readFile("TaughtCourse.json");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    for(Object o : jsonArray) {
      JSONObject jsonObject = (JSONObject) o;
      int quota = (int) jsonObject.get("quota");
      int sessionDuration = (int) jsonObject.get("sessionDuration");
      Date startDate = (Date) jsonObject.get("startDate");
      int totalPrice = (int) jsonObject.get("totalPrice");
      String teachingday = (String) jsonObject.get("teachingday");
      Date endDate = (Date) jsonObject.get("endDate");
      int id = (int) jsonObject.get("id");
      Office office = (Office) jsonObject.get("office");
      Teacher teacher = (Teacher) jsonObject.get("teacher");
      Course course = (Course) jsonObject.get("course");
      List<Enrollment> enrollments = (List<Enrollment>) jsonObject.get("enrollments");

      TaughtCourse aux;
      if(taughtCourses != null) {
        aux = new TaughtCourse(quota,
            sessionDuration,
            startDate,
            totalPrice,
            teachingday,
            endDate,
            id,
            office,
            teacher,
            enrollments,
            course);
      } else {
        aux = new TaughtCourse(quota,
            sessionDuration,
            startDate,
            totalPrice,
            teachingday,
            endDate,
            id,
            office,
            teacher,
            course);
      }

      taughtCourses.add(aux);
    }
    return taughtCourses;
  }
}

