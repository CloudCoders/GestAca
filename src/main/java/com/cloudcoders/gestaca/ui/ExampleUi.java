package com.cloudcoders.gestaca.ui;

import java.util.Scanner;

public class ExampleUi {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("> ");
            command = scanner.nextLine();
            if (command.equals("inscribir alumno")) {
                listarCursos();
                System.out.print("Curso: ");
                String curso = scanner.nextLine();

                System.out.print("DNI alumno: ");
                String dni = scanner.nextLine();

                if (isAlumno()) {
                    if (isInscrito()) {
                        System.out.println("ERROR: Alumno ya escrito en el curso.");
                    } else {
                        System.out.println("Alumno inscrito en el curso.");
                    }
                } else {
                    System.out.println("Alumno no encontrado, introduce sus datos.");
                    System.out.print("\tNombre: ");
                    String alumno = scanner.nextLine();
                    System.out.print("\tDireccion: ");
                    String direccion = scanner.nextLine();
                    System.out.print("\tZip: ");
                    String zip = scanner.nextLine();
                    System.out.print("\tIBAN: ");
                    String iban = scanner.nextLine();
                    System.out.println("Alumno matriculado y inscrito en el curso.");
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

    public static void listarCursos() {
        System.out.println("\t1.- Programacion en Android");
        System.out.println("\t2.- Programacion en Java");
        System.out.println("\t3.- Diagramas de clases en UML");
        System.out.println("\t4.- Experto de NodeJS (Patrocinado por Goterris)");
    }
}
