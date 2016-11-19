package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JoseLlorens on 18/11/2016.
 */
public class Enrollment {
    private Date cancellationDate;
    private Date enrollemntDate;
    private  boolean uniquePayment;
    private int id;
    private List<Absence> absences;
    private TaughtCourse taughtCourse;
    private Student student;

    public Enrollment(Date cancellationDate, Date enrollemntDate, boolean uniquePayment, int id, TaughtCourse taughtCourse, Student student) {
        this.cancellationDate = cancellationDate;
        this.enrollemntDate = enrollemntDate;
        this.uniquePayment = uniquePayment;
        this.id = id;
        this.taughtCourse = taughtCourse;
        this.student = student;
        this.absences = new ArrayList<Absence>();
    }

    public Enrollment(Date cancellationDate, Date enrollemntDate, boolean uniquePayment, int id, List<Absence> absences, TaughtCourse taughtCourse, Student student) {
        this.cancellationDate = cancellationDate;
        this.enrollemntDate = enrollemntDate;
        this.uniquePayment = uniquePayment;
        this.id = id;
        this.absences = absences;
        this.taughtCourse = taughtCourse;
        this.student = student;
    }

    public boolean addAbsences(Absence absence){
        try{
            this.absences.add(absence);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return  false;
        }
    }

    public boolean removeAbsences(Absence absence){
        try{
            this.absences.remove(absence);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return  false;
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public Date getEnrollemntDate() {
        return enrollemntDate;
    }

    public void setEnrollemntDate(Date enrollemntDate) {
        this.enrollemntDate = enrollemntDate;
    }

    public boolean isUniquePayment() {
        return uniquePayment;
    }

    public void setUniquePayment(boolean uniquePayment) {
        this.uniquePayment = uniquePayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    public TaughtCourse getTaughtCourse() {
        return taughtCourse;
    }

    public void setTaughtCourse(TaughtCourse taughtCourse) {
        this.taughtCourse = taughtCourse;
    }
}
