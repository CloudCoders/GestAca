package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {

  private JsonParser parser = new JsonParser();

  @Override
  public Student get(String dni) {
    List<Student> list = getAll();
    int i = 0;
    boolean found = false;
    Student result = null;
    while(i < list.size() && !found) {
      found = dni.equals(list.get(i).getId()) ;
      i++;
    }
    if(found)
      result = list.get(i);
    return result;
  }

  @Override
  public Student add(Student student) {
    JSONObject aux = new JSONObject();

    aux.put("id",      student.getId());
    aux.put("name",    student.getName());
    aux.put("iban",    student.getIban());
    aux.put("address", student.getAddress());
    aux.put("zip",     student.getZip());
    aux.put("enrollments", student.getEnrollments());

    JSONArray a = null;
    try {
      a = parser.readFile("Student.json");
    } catch(IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    a.put(aux);

    try {
      parser.writeFile("Student.json", a);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Student remove(Student student) {
    JSONObject aux = new JSONObject();

    aux.put("id",      student.getId());
    aux.put("name",    student.getName());
    aux.put("iban",    student.getIban());
    aux.put("address", student.getAddress());
    aux.put("zip",     student.getZip());
    aux.put("enrollments", student.getEnrollments());

    JSONArray a = null;
    try {
      a = parser.readFile("Student.json");
    } catch(IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    int i = 0;
    boolean found = false;
    while(i < a.length() && !found) {
      found = student.getId().equals(((Student)a.get(i)).getId()) ;
      i++;
    }
    if(found) {
      a.remove(i);
      try {
        parser.writeFile("Student.json", a);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public List<Student> getAll() {
    List<Student> list =  new ArrayList<>();
    JsonParser parser = new JsonParser();
    try {
      JSONArray a = parser.readFile("Student.json");
      for (Object o: a) {
        list.add((Student) o);
      }
    } catch(IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return list;
  }
}
