package com.cloudcoders.gestaca.persistance.parser;

import com.cloudcoders.gestaca.model.Student;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JsonParserShould {

  public String getStudentJson(){
    return "{" +
        "\"iban\":\"iban\"," +
        "\"enrollments\":[]," +
        "\"zip\":1234," +
        "\"address\":\"address\"," +
        "\"id\":\"77X\"," +
        "\"name\":\"pepe\"" +
        "}";
  }

  @Test public void
  parse_student_to_json() {
    Student student = new Student(1234, "address", "77X", "pepe", "iban");

    JsonParser jsonParser = getJsonParser();
    String studentJson = jsonParser.toJson(student);


    assertThat(studentJson, is(getStudentJson()));
  }

  private JsonParser getJsonParser() {
    Gson gson = new Gson();
    return new JsonParser(gson);
  }

  @Test public void
  parse_student_json_to_student(){
    Student expectedStudent = new Student(1234, "address", "77X", "pepe", "iban");

    JsonParser jsonParser = getJsonParser();
    Student student = jsonParser.toObject(getStudentJson(), Student.class);

    assertThat(student.getName(), is(expectedStudent.getName()));
    assertThat(student.getIban(), is(expectedStudent.getIban()));
    assertThat(student.getAddress(), is(expectedStudent.getAddress()));
    assertThat(student.getId(), is(expectedStudent.getId()));
    assertThat(student.getZip(), is(expectedStudent.getZip()));
  }

  @Test public void
  parse_student_list_to_json(){
    Student student = new Student(1234, "address", "77X", "pepe", "iban");
    ArrayList<Student> list = new ArrayList<>(Arrays.asList(student, student));

    JsonParser jsonParser = getJsonParser();
    String studentJson = jsonParser.toJson(list);

    String expectedStudentJson = "[" + getStudentJson() + "," + getStudentJson() + "]";
    assertThat(studentJson, is(expectedStudentJson));
  }

  @Test public void
  parse_student_list_json_to_student_object_list(){
    Student student = new Student(1234, "address", "77X", "pepe", "iban");
    ArrayList<Student> list = new ArrayList<>(Arrays.asList(student, student));

    String studentJson = "[" + getStudentJson() + "," + getStudentJson() + "]";

    JsonParser jsonParser = getJsonParser();
    List<Student> students = jsonParser.toObjectList(studentJson, Student[].class);

    assertThat(students.size(), is(2));
    assertThat(students.get(0).getId(), is("77X"));
  }

}