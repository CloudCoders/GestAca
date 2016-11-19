package com.cloudcoders.gestaca.ui;

import com.cloudcoders.gestaca.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExampleUi {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        CommandLine cmd = new CommandLine(scanner);
        String command;

        List<Course> courseList = new ArrayList<Course>();
        courseList.add(new Course("fdafda", "Programacion en Android", 1));
        courseList.add(new Course("fdafda", "Programacion en Java", 2));
        courseList.add(new Course("fdafda", "Diagramas de clases en UML", 3));
        courseList.add(new Course("fdafda", "Experto de NodeJS (Patrocinado por Goterris)", 4));

        do {
            System.out.print("> ");
            command = scanner.nextLine();
            if (command.equals("inscribir alumno")) {
                cmd.showCourses(courseList);
                cmd.askCourse();
                cmd.askDNI();
                if (isAlumno()) {
                    if (isInscrito()) {
                        cmd.showStudentFoundAndEnrolled();
                    } else {
                        cmd.showStudentFoundAndNotEnrolled();
                    }
                } else {
                    cmd.showStudentNotFound();
                    cmd.askStudent();
                    cmd.showStudentEnrolled();
                }
            }
            if (command.equals("crear curso")) {
                cmd.askCreateCourse();
                if (cursoExiste()) {
                    cmd.showCurseAlreadyExists();
                } else {
                    cmd.showCurseCreated();
                }
            }
        } while (!command.equals("exit"));
    }

    public static boolean isAlumno() {
        return false;
    }

    public static boolean isInscrito() {
        return false;
    }

    public static boolean cursoExiste() {
        return false;
    }
}
