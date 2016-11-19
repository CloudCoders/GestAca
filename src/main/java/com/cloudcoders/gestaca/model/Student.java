package com.cloudcoders.gestaca.model;


import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
  private String IBAN;
  private List<Enrollment> enrollments;

  public Student(int zip, String address, String id, String name, String IBAN) {
    super(zip, address, id, name);
    this.IBAN = IBAN;
    this.enrollments = new ArrayList<Enrollment>();
  }

  public Student(int zip, String address, String id, String name, String IBAN, List<Enrollment> enrollments) {
    super(zip, address, id, name);
    this.IBAN = IBAN;
    this.enrollments = enrollments;
  }

  public void addEnrollment(Enrollment enrollment) {
    this.enrollments.add(enrollment);
  }

  public void removeEnrollment(Enrollment enrollment) {
    this.enrollments.remove(enrollment);
  }

  public String getIBAN() {
    return IBAN;
  }

  public void setIBAN(String IBAN) {
    this.IBAN = IBAN;
  }

  public List<Enrollment> getEnrollments() {
    return enrollments;
  }

  public void setEnrollments(List<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }
}
