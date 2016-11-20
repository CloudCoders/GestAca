package com.cloudcoders.gestaca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Office implements Serializable {
  private int maxCapacity;
  private String name;
  private int id;
  private List<TaughtCourse> taughtCourses;

  public Office(int maxCapacity, String name, int id) {
    this.maxCapacity = maxCapacity;
    this.name = name;
    this.id = id;
    this.taughtCourses = new ArrayList<TaughtCourse>();
  }

  public Office(int maxCapacity, String name, int id, List<TaughtCourse> taughtCourses) {
    this.maxCapacity = maxCapacity;
    this.name = name;
    this.id = id;
    this.taughtCourses = taughtCourses;
  }


  public void addTaughtCourses(TaughtCourse taughtCourse) {
    this.taughtCourses.add(taughtCourse);
  }

  public void removeTaughtCourses(TaughtCourse taughtCourse) {
    this.taughtCourses.remove(taughtCourse);
  }

  public int getMaxCapacity() {
    return maxCapacity;
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
