package com.cloudcoders.gestaca.model;


import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
  private String iban;
  private List<Enrollment> enrollments;

  public Student(int zip, String address, String id, String name, String iban) {
    super(zip, address, id, name);
    this.iban = iban;
    this.enrollments = new ArrayList<Enrollment>();
  }

  public Student(int zip, String address, String id, String name, String iban, List<Enrollment> enrollments) {
    super(zip, address, id, name);
    this.iban = iban;
    this.enrollments = enrollments;
  }

  public void addEnrollment(Enrollment enrollment) {
    this.enrollments.add(enrollment);
  }

  public void removeEnrollment(Enrollment enrollment) {
    this.enrollments.remove(enrollment);
  }

  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public List<Enrollment> getEnrollments() {
    return enrollments;
  }

  public void setEnrollments(List<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }
}
