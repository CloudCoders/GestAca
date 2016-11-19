package Model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String description;
    private String name;
    private int id;
    private List<TaughtCourse> taughtCourses;

    public Course(String description, String name, int id, List<TaughtCourse> taughtCourses) {
        this.description = description;
        this.name = name;
        this.id = id;
        this.taughtCourses = taughtCourses;
    }

    public Course(String description, String name, int id) {
        description = description;
        name = name;
        this.id = id;
        this.taughtCourses = new ArrayList<TaughtCourse>();
    }

    public boolean addTaughtCourse(TaughtCourse taughtCourse){
        try {
            this.taughtCourses.add(taughtCourse);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return false;
        }
    }


    public boolean removeTaughtCourse(TaughtCourse taughtCourse){
        try {
            this.taughtCourses.remove(taughtCourse);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return false;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TaughtCourse> getTaughtCourses() {
        return taughtCourses;
    }

    public void setTaughtCourses(List<TaughtCourse> taughtCourses) {
        taughtCourses = taughtCourses;
    }
}
