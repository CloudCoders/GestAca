package com.cloudcoders.gestaca.persistance.parser;

import com.cloudcoders.gestaca.model.Student;
import com.google.gson.Gson;
import org.junit.Test;

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

    Gson gson = new Gson();
    JsonParser jsonParser = new JsonParser(gson);
    String studentJson = jsonParser.toJson(student);


    assertThat(studentJson, is(getStudentJson()));
  }

  @Test public void
  parse_student_json_to_student(){
    Student expectedStudent = new Student(1234, "address", "77X", "pepe", "iban");

    Gson gson = new Gson();
    JsonParser jsonParser = new JsonParser(gson);
    Student student = jsonParser.toObject(getStudentJson(), Student.class);

    assertThat(student.getName(), is(expectedStudent.getName()));
    assertThat(student.getIban(), is(expectedStudent.getIban()));
    assertThat(student.getAddress(), is(expectedStudent.getAddress()));
    assertThat(student.getId(), is(expectedStudent.getId()));
    assertThat(student.getZip(), is(expectedStudent.getZip()));
  }

}