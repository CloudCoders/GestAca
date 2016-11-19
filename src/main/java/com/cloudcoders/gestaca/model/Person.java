package com.cloudcoders.gestaca.model;


public abstract class Person {
  private int zip;
  private String address;
  private String id;
  private String name;

  public Person(int zip, String address, String id, String name) {
    this.zip = zip;
    this.address = address;
    this.id = id;
    this.name = name;
  }


  public int getZip() {
    return zip;
  }

  public String getAddress() {
    return address;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
