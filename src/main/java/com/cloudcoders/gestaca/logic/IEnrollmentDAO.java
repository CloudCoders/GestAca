package com.cloudcoders.gestaca.logic;

import com.cloudcoders.gestaca.model.Enrollment;

import java.util.List;

public interface IEnrollmentDAO{
  Enrollment get(int id);
  List<Enrollment> getAll();
}
