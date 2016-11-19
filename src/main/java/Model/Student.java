package Model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoseLlorens on 18/11/2016.
 */
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

    public boolean addEnrollment(Enrollment enrollment){
        try{
            this.enrollments.add(enrollment);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return  false;
        }
    }

    public boolean removeEnrollment(Enrollment enrollment){
        try{
            this.enrollments.remove(enrollment);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return  false;
        }
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
