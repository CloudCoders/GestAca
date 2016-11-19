package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Student;

import java.util.List;

public interface IStudentDAO {

  Student get(String id);

  void add(Student student);

  Student remove(Student student);

  List<Student> getAll();
}
