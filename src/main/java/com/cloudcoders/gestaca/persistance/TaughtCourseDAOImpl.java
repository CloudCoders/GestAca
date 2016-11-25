package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.ITaughtCourseDAO;
import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Office;
import com.cloudcoders.gestaca.model.TaughtCourse;
import com.cloudcoders.gestaca.model.Teacher;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.ReadFileException;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaughtCourseDAOImpl implements ITaughtCourseDAO {

  private FileDAL fileDAL;
  private JsonParser parser;

  public TaughtCourseDAOImpl(FileDAL fileDAL, JsonParser parser) {
    this.fileDAL = fileDAL;
    this.parser = parser;
  }

  @Override
  public void add(TaughtCourse newTaughtCourse) throws PersistenceException {
    long newId = System.currentTimeMillis();

    try {
      List<TaughtCourse> taughtCourses = getAll();

      boolean isUnique = !taughtCourses.stream()
          .filter(it -> it.getId() == newId)
          .findFirst()
          .isPresent();

      if(isUnique) {
        TaughtCourse taughtCourse = new TaughtCourse(
            newTaughtCourse.getQuota(),
            newTaughtCourse.getSessionDuration(),
            newTaughtCourse.getStartDate(),
            newTaughtCourse.getTotalPrice(),
            newTaughtCourse.getTeachingday(),
            newTaughtCourse.getEndDate(),
            newId,
            newTaughtCourse.getOffice(),
            newTaughtCourse.getTeacher(),
            newTaughtCourse.getEnrollments(),
            newTaughtCourse.getCourse());

        taughtCourses.add(taughtCourse);
        String taughtCoursesJson = parser.toJson(taughtCourses);
        fileDAL.writeFile("TaughtCourse.json", taughtCoursesJson);
      } else {
        throw new PersistenceException("Id is not unique");
      }
    } catch (WriteFileException | PersistenceException e) {
      throw new PersistenceException(e.getMessage());
    }

  }

  @Override
  public TaughtCourse remove(TaughtCourse taughtCourse) {
    return null;
  }

  @Override
  public TaughtCourse get(long id) {
    return null;
  }

  @Override
  public List<TaughtCourse> getAll() throws PersistenceException {
    try {
      String json = fileDAL.readFile("TaughtCourse.json");
      List<TaughtCourse> taughtCourses = parser.toObjectList(json, TaughtCourse[].class);
      return taughtCourses;
    } catch (ReadFileException e) {
      throw new PersistenceException(e.getMessage());
    }
  }
}

