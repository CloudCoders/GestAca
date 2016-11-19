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

  public TaughtCourse(int quota, int sessionDuration, Date startDate, int totalPrice, String teachingday, Date endDate, int id, Office office, Teacher teacher, Course course) {
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

  public TaughtCourse(int quota, int sessionDuration, Date startDate, int totalPrice, String teachingday, Date endDate, int id, Office office, Teacher teacher, List<Enrollment> enrollments, Course course) {
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

  public void setQuota(int quota) {
    this.quota = quota;
  }

  public int getSessionDuration() {
    return sessionDuration;
  }

  public void setSessionDuration(int sessionDuration) {
    this.sessionDuration = sessionDuration;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getTeachingday() {
    return teachingday;
  }

  public void setTeachingday(String teachingday) {
    this.teachingday = teachingday;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public List<Enrollment> getEnrollments() {
    return enrollments;
  }

  public void setEnrollments(List<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
}
