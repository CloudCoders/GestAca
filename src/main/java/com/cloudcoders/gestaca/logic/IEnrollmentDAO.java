package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.logic.exceptions.InvalidPersonException;
import com.cloudcoders.gestaca.logic.exceptions.InvalidTaughtCourse;
import com.cloudcoders.gestaca.model.Enrollment;

import java.util.List;

public interface IEnrollmentDAO {

  Enrollment get(int id);

  List<Enrollment> getAll();

  void add(Enrollment enrollment) throws InvalidPersonException, InvalidTaughtCourse;

  Enrollment remove(Enrollment enrollment);

}
