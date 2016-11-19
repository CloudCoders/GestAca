package Model;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private int maxCapacity;
    private String name;
    private int id;
    private List<TaughtCourse> taughtCourses;

    public Office(int maxCapacity, String name, int id) {
        maxCapacity = maxCapacity;
        this.name = name;
        this.id = id;
        this.taughtCourses = new ArrayList<TaughtCourse>();
    }

    public Office(int maxCapacity, String name, int id, List<TaughtCourse> taughtCourses) {
        this.maxCapacity = maxCapacity;
        this.name = name;
        this.id = id;
        this.taughtCourses = taughtCourses;
    }

    public boolean addTaughtCourses(TaughtCourse taughtCourse){
        try{
            this.taughtCourses.add(taughtCourse);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return  false;
        }
    }

    public boolean removeTaughtCourses(TaughtCourse taughtCourse){
        try{
            this.taughtCourses.remove(taughtCourse);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return  false;
        }
    }
    
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.taughtCourses = taughtCourses;
    }
}
