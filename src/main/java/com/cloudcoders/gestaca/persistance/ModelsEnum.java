package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.*;

public enum ModelsEnum {
  ABSENCE("Absence.json", Absence.class),
  COURSE("Course.json", Course.class),
  ENROLLMENT("Enrollment.json", Enrollment.class),
  OFFICE("Office.json", Office.class),
  PERSON("Person.json", Person.class),
  STUDENT("Student.json", Student.class),
  TAUGHTCOURSE("TaughtCourse.json", TaughtCourse.class),
  TEACHER("Teacher.json", Teacher.class);

  private String archivo;
  private Class clase;
  ModelsEnum(String archivo, Class clase) {
    this.archivo = archivo;
    this.clase = clase;
  }

  public String getArchivo() {
    return this.archivo;
  }

}