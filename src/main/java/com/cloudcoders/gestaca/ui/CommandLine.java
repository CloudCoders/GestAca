package com.cloudcoders.gestaca.ui;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.model.Student;

import java.util.List;
import java.util.Scanner;

public class CommandLine implements View {

    private List<Course> courseList;
    private Scanner scanner;
    private String dni;

    public CommandLine(Scanner scanner) {
        this.scanner = scanner;
    }

    public String typeCommand(){
        System.out.print("> ");
        return scanner.nextLine();
    }

    public void showCourses(List<Course> courseList) {
        this.courseList = courseList;
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println("\t" + i + ".- " + courseList.get(i).getName());
        }
    }

    public void showEmptyCourses() {
        System.out.println("ERROR: No hay cursos disponibles en este momento.");
    }

    public Course askCourse() {
        int choice = -1;
        do {
            try {
                System.out.print("Course: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > courseList.size()) {
                    System.out.println("ERROR: Numero de curso no valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Introduce un numero.");
            }
        } while (choice < 1 || choice > courseList.size());
        Course course = this.courseList.get(choice);
        return course;
    }

    public String askDNI() {
        System.out.print("DNI alumno: ");
        this.dni = scanner.nextLine();
        return dni;
    }

    public void showStudentNotFound() {
        System.out.println("Alumno no encontrado, introduce sus datos.");
    }

    public void showStudentFoundAndEnrolled() {
        System.out.println("ERROR: Alumno ya escrito en el curso.");
    }

    public void showStudentFoundAndNotEnrolled() {
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
        boolean isNumber = false;
        int zip = 0;
        do {
            try {
                System.out.print("\tZip: ");
                zip = Integer.parseInt(scanner.nextLine());
                isNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("\tERROR: Introduce un numero.");
            }
        } while (!isNumber);
        System.out.print("\tIBAN: ");
        String iban = scanner.nextLine();
        Student student = new Student(zip, address, dni, name, iban);
        return student;
    }

    public void showStudent(Student student) {
        System.out.print("\tNombre: " + student.getName());
        System.out.print("\tDireccion: " + student.getAddress());
        System.out.print("\tZip: " + student.getZip());
        System.out.print("\tIBAN: " + student.getIban());
    }

    public Course askCreateCourse() {
        System.out.println("\tNombre: ");
        String name = scanner.nextLine();
        System.out.println("\tDescripcion: ");
        String description = scanner.nextLine();
        Course course = new Course(description, name, 0);
        return course;
    }

    public void showCurseCreated() {
        System.out.println("Curso creado.");
    }

    public void showCurseAlreadyExists() {
        System.out.println("Ya existe el curso introducido.");
    }
}
