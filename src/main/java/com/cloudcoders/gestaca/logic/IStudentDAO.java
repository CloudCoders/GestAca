package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public interface IStudentDAO {

  Student get(String dni);

  List<Student> addAll(List<Student> students);

  Student add(Student student);

  Student remove(Student student);

  List<Student> getAll();

  List<Student> removeAll();

}
