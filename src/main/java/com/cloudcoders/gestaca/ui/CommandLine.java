package com.cloudcoders.gestaca.ui;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Student;

import java.util.List;
import java.util.Scanner;

public class CommandLine implements View{

    private List<Course> courseList;
    private Scanner scanner;
    private String dni;

    public CommandLine() {
        scanner = new Scanner(System.in);
    }

    public void showCourses(List<Course> courseList) {
        this.courseList = courseList;
        for(int i=0; i<courseList.size(); i++) {
            System.out.println("\t"+i+".- "+courseList.get(i).getName());
        }
    }

    public Course askCourse() {
        int choice = -1;
        do{
            try{
                System.out.print("Course: ");
                choice = Integer.parseInt(scanner.nextLine());
                if(choice < 1 || choice > courseList.size()) {
                    System.out.println("ERROR: Numero de curso no valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Introduce un numero.");
            }
        }while(choice < 1 || choice > courseList.size());
        Course course = this.courseList.get(choice-1);
        return course;
    }

    public String askDNI() {
        System.out.print("DNI alumno");
        this.dni = scanner.nextLine();
        return dni;
    }

    public void showStudentNotFound() {
        System.out.println("Alumno no encontrado, introduce sus datos.");
    }

    public void showStudentFoundAndEnrolled() {
        System.out.println("Alumno inscrito en el curso.");
    }

    public void showStudentEnrolled() {
        System.out.println("Alumno matriculado y inscrito en el curso.");
    }

    public Student askStudent() {
        System.out.print("\tNombre: ");
        String name = scanner.nextLine();
        System.out.print("\tDireccion: ");
        String address = scanner.nextLine();
        System.out.print("\tZip: ");
        String zip = scanner.nextLine();
        System.out.print("\tIBAN: ");
        String iban = scanner.nextLine();
        Student student = new Student(Integer.parseInt(zip),address,dni,name,iban);
        return student;
    }
}
