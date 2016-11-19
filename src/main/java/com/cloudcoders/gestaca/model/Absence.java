package com.cloudcoders.gestaca.model;

import java.util.Date;

public class Absence {
  private Date date;
  private int id;

  public Absence(Date date, int id) {
    this.date = date;
    this.id = id;
  }

  public Absence() {
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
