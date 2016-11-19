package com.cloudcoders.gestaca.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Enrollment {
  private Date cancellationDate;
  private Date enrollemntDate;
  private boolean uniquePayment;
  private int id;
  private List<Absence> absences;
  private TaughtCourse taughtCourse;
  private Student student;

  public Enrollment(Date cancellationDate,
                    Date enrollemntDate,
                    boolean uniquePayment,
                    int id,
                    TaughtCourse taughtCourse,
                    Student student) {
    this.cancellationDate = cancellationDate;
    this.enrollemntDate = enrollemntDate;
    this.uniquePayment = uniquePayment;
    this.id = id;
    this.taughtCourse = taughtCourse;
    this.student = student;
    this.absences = new ArrayList<Absence>();
  }

  public Enrollment(Date cancellationDate,
                    Date enrollemntDate,
                    boolean uniquePayment,
                    int id, List<Absence> absences,
                    TaughtCourse taughtCourse,
                    Student student) {
    this.cancellationDate = cancellationDate;
    this.enrollemntDate = enrollemntDate;
    this.uniquePayment = uniquePayment;
    this.id = id;
    this.absences = absences;
    this.taughtCourse = taughtCourse;
    this.student = student;
  }

  public void addAbsences(Absence absence) {
    this.absences.add(absence);
  }

  public void removeAbsences(Absence absence) {
    this.absences.remove(absence);
  }

  public Student getStudent() {
    return student;
  }

  public Date getCancellationDate() {
    return cancellationDate;
  }

  public Date getEnrollemntDate() {
    return enrollemntDate;
  }

  public boolean isUniquePayment() {
    return uniquePayment;
  }

  public int getId() {
    return id;
  }

  public List<Absence> getAbsences() {
    return absences;
  }

  public TaughtCourse getTaughtCourse() {
    return taughtCourse;
  }

}
