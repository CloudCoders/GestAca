package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.logic.IStudentDAO;
import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.ReadFileException;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements IStudentDAO {

  private static final String STUDENTS_FILE = "Student.json";

  private FileDAL fileDAL;
  private JsonParser jsonParser;

  public StudentDAOImpl(FileDAL fileDAL, JsonParser jsonParser) {
    this.fileDAL = fileDAL;
    this.jsonParser = jsonParser;
  }

  @Override
  public Student get(String dni) throws PersistenceException{
    Optional<Student> studentOp = getAll()
        .stream()
        .filter(it -> it.getId().equals(dni))
        .findFirst();
    return studentOp.isPresent()? studentOp.get() : null;
  }

  @Override
  public void add(Student student) throws PersistenceException {
    List<Student> students = getAll();

    Optional<Student> first = students.stream()
        .filter(it -> it.getId().equals(student.getId()))
        .findFirst();

    if (!first.isPresent()) {
      students.add(student);
      String body = jsonParser.toJson(students);
      writeToFile(body);
    }
  }

  @Override
  public Student remove(Student student) throws PersistenceException {
      List<Student> students = getAll();

      Optional<Student> first = students.stream()
                                .filter(it -> it.getId().equals(student.getId()))
                                .findFirst();
      if(first.isPresent()) {
        students.remove(first.get());
        String body = jsonParser.toJson(students);
        writeToFile(body);
      }
    return student;
  }

  @Override
  public List<Student> getAll() throws PersistenceException{
      String json = readFromFile();
      List<Student> students = jsonParser.toObjectList(json, Student[].class);
      return students;
  }

  private String readFromFile() throws PersistenceException{
    try{
      return fileDAL.readFile(STUDENTS_FILE);
    } catch (ReadFileException e) {
      throw new PersistenceException(e.getMessage());
    }

  }


  private void writeToFile(String body) throws PersistenceException{
    try {
      fileDAL.writeFile(STUDENTS_FILE, body);
    } catch (WriteFileException e) {
      throw new PersistenceException(e.getMessage());
    }
  }
}
