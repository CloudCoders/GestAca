package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public interface IStudentDAO {

  Student getStudentBy(String dni);

  List<Student> addAllStudents(List<Student> students);

  Student addStudentBy(Student student);

  Student removeStudentBy(Student student);

  Student removeStudentBy(String dni);

  List<Student> getAllStudents();

  List<Student> removeAllStudents();

}
