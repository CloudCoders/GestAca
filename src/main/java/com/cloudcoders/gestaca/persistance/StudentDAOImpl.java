package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.ReadFileException;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements IStudentDAO {

  private FileDAL fileDAL;
  private JsonParser jsonParser;

  public StudentDAOImpl(FileDAL fileDAL, JsonParser jsonParser) {
    this.fileDAL = fileDAL;
    this.jsonParser = jsonParser;
  }

  @Override
  public Student get(String dni) throws PersistenceException {
    try {

      Optional<Student> studentOp = getAll()
          .stream()
          .filter(it -> it.getId().equals(dni))
          .findFirst();
      return studentOp.isPresent()? studentOp.get() : null;

    } catch (PersistenceException e) {
      throw e;
    }
  }

  @Override
  public void add(Student student) throws PersistenceException {
    try {
      List<Student> students = getAll();

      boolean isUnique = !students.stream()
          .filter(it -> it.getId().equals(student.getId()))
          .findFirst()
          .isPresent();

      if (isUnique) {
        students.add(student);
        String body = jsonParser.toJson(students);
        fileDAL.writeFile("Student.json", body);
      } else {
        throw new PersistenceException("Id is not unique");
      }
    } catch (WriteFileException | PersistenceException e) {
      throw new PersistenceException(e.getMessage());
    }
  }

  @Override
  public Student remove(Student student) {
    JSONArray a = new JSONArray();
//    a = fileDAL.readFile("Student.json");

    int i = 0;
    boolean found = false;
    while(i < a.length() && !found) {
      found = student.getId().equals(((JSONObject)a.get(i)).getString("id")) ;
      i++;
    }
    if(found) {
      a.remove(--i);
//      fileDAL.writeFile("Student.json", a);
    }
    return student;
  }

  @Override
  public List<Student> getAll() throws PersistenceException {
    try {
      String json = fileDAL.readFile("Student.json");
      List<Student> students = jsonParser.toObjectList(json, Student[].class);
      return students;
    } catch (ReadFileException e) {
      throw new PersistenceException(e.getMessage());
    }
  }
}
