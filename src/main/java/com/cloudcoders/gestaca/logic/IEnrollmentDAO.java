package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.logic.exceptions.InvalidPersonException;
import com.cloudcoders.gestaca.logic.exceptions.InvalidTaughtCourse;
import com.cloudcoders.gestaca.model.Enrollment;
import com.cloudcoders.gestaca.persistance.PersistenceException;

import java.util.List;

public interface IEnrollmentDAO {

  Enrollment get(int id);

  List<Enrollment> getAll() throws PersistenceException;

  void add(Enrollment enrollment) throws InvalidPersonException, InvalidTaughtCourse, PersistenceException;

  Enrollment remove(Enrollment enrollment);

}
