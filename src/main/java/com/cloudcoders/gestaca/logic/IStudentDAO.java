package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.persistance.PersistenceException;

import java.util.List;

public interface IStudentDAO {

  Student get(String id) throws PersistenceException;

  void add(Student student) throws PersistenceException;

  Student remove(Student student);

  List<Student> getAll() throws PersistenceException;
}
