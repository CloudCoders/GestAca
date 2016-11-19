package com.cloudcoders.gestaca.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
  private String description;
  private String name;
  private int id;
  private List<TaughtCourse> taughtCourses;

  public Course(String description, String name, int id, List<TaughtCourse> taughtCourses) {
    this.description = description;
    this.name = name;
    this.id = id;
    this.taughtCourses = taughtCourses;
  }

  public Course(String description, String name, int id) {
    this.description = description;
    this.name = name;
    this.id = id;
    this.taughtCourses = new ArrayList<TaughtCourse>();
  }


  public void addTaughtCourse(TaughtCourse taughtCourse) {
    this.taughtCourses.add(taughtCourse);
  }

  public void removeTaughtCourse(TaughtCourse taughtCourse) {
    this.taughtCourses.remove(taughtCourse);
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public List<TaughtCourse> getTaughtCourses() {
    return taughtCourses;
  }

}
