package Model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
  private String ssn;
  private List<TaughtCourse> taughtCourses;

  public Teacher(int zip, String address, String id, String name, String ssn) {
    super(zip, address, id, name);
    this.ssn = ssn;
    this.taughtCourses = new ArrayList<TaughtCourse>();
  }

  public Teacher(int zip, String address, String id, String name, String ssn, List<TaughtCourse> taughtCourses) {
    super(zip, address, id, name);
    this.ssn = ssn;
    this.taughtCourses = taughtCourses;
  }

  public void addTaughtCourse(TaughtCourse taughtCourse) {
    this.taughtCourses.add(taughtCourse);
  }

  public void removeTaughtCourse(TaughtCourse taughtCourse) {
    this.taughtCourses.remove(taughtCourse);
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public List<TaughtCourse> getTaughtCourses() {
    return taughtCourses;
  }

  public void setTaughtCourses(List<TaughtCourse> taughtCourses) {
    this.taughtCourses = taughtCourses;
  }
}
