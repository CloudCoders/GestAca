package com.cloudcoders.gestaca.model;

public class Course {
  private String description;
  private String name;
  private long id;

  public Course(String description, String name, long id) {
    this.description = description;
    this.name = name;
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  public long getId() {
    return id;
  }

}
