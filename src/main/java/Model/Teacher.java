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

    public boolean addTaughtCourse(TaughtCourse taughtCourse){
        try{
            this.taughtCourses.add(taughtCourse);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return  false;
        }
    }

    public boolean removeTaughtCourse(TaughtCourse taughtCourse){
        try{
            this.taughtCourses.remove(taughtCourse);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return  false;
        }
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
