package com.cloudcoders.gestaca.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaughtCourse {
  private int quota;
  private int sessionDuration;
  private Date startDate;
  private int totalPrice;
  private String teachingday;
  private Date endDate;
  private int id;
  private Office office;
  private Teacher teacher;
  private List<Enrollment> enrollments;
  private Course course;

  public TaughtCourse(int quota,
                      int sessionDuration,
                      Date startDate,
                      int totalPrice,
                      String teachingday,
                      Date endDate,
                      int id,
                      Office office,
                      Teacher teacher,
                      Course course) {
    this.quota = quota;
    this.sessionDuration = sessionDuration;
    this.startDate = startDate;
    this.totalPrice = totalPrice;
    this.teachingday = teachingday;
    this.endDate = endDate;
    this.id = id;
    this.office = office;
    this.teacher = teacher;
    this.course = course;
    this.enrollments = new ArrayList<Enrollment>();
  }

  public TaughtCourse(int quota,
                      int sessionDuration,
                      Date startDate,
                      int totalPrice,
                      String teachingday,
                      Date endDate,
                      int id,
                      Office office,
                      Teacher teacher,
                      List<Enrollment> enrollments,
                      Course course) {
    this.quota = quota;
    this.sessionDuration = sessionDuration;
    this.startDate = startDate;
    this.totalPrice = totalPrice;
    this.teachingday = teachingday;
    this.endDate = endDate;
    this.id = id;
    this.office = office;
    this.teacher = teacher;
    this.enrollments = enrollments;
    this.course = course;
  }


  public void addEnrollment(Enrollment enrollment) {
    this.enrollments.add(enrollment);
  }

  public void removeEnrollment(Enrollment enrollment) {
    this.enrollments.remove(enrollment);
  }

  public int getQuota() {
    return quota;
  }

  public int getSessionDuration() {
    return sessionDuration;
  }

  public Date getStartDate() {
    return startDate;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public String getTeachingday() {
    return teachingday;
  }

  public Date getEndDate() {
    return endDate;
  }

  public int getId() {
    return id;
  }

  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public List<Enrollment> getEnrollments() {
    return enrollments;
  }

  public Course getCourse() {
    return course;
  }

}
