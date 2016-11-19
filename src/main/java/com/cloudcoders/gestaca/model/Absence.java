package com.cloudcoders.gestaca.model;

import java.util.Date;

public class Absence {
  private Date date;
  private int id;

  public Absence(Date date, int id) {
    this.date = date;
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public int getId() {
    return id;
  }

}
