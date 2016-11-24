package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Student;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StudentDAOImplTest {

  private static FileDAL DAL = new FileDAL();
  private static JsonParser parser = new JsonParser(new Gson());
  private static String EMPTY_FILE = "[]";

  @Before
  public void setup() {
    //Cleans the Student.json File
    try {
      DAL.writeFile("Student.json", EMPTY_FILE);
    } catch (WriteFileException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Student> initialize_students_file() throws PersistenceException {

    ArrayList<Student> students = new ArrayList<>();
    Student st1 = new Student(46020, "C/Reverendo Blabla 25", "12345678x", "Liil Johny Doe", "600030156161154");
    Student st2 = new Student(46021, "C/Turia 45", "78798797y", "John Doe", "600030156161153");
    Student st3 = new Student(46022, "C/Colon 43", "54984594z", "Jane Doe", "600030156161152");

    students.add(st1);
    students.add(st2);
    students.add(st3);

    StudentDAOImpl dao = new StudentDAOImpl(DAL, parser);
    dao.add(st1);
    dao.add(st2);
    dao.add(st3);
    return students;
  }

  @Test
  public void should_add_student_and_return_it() throws PersistenceException {
    Student st = new Student(03725, "C/Dtr 2", "554564m", "Alsx asdas", "45454sf");
    FileDAL fileDAL = new FileDAL();
    JsonParser jsonParser = new JsonParser(new Gson());
    StudentDAOImpl dao = new StudentDAOImpl(fileDAL, jsonParser);

    dao.add(st);
    Student st2 = dao.get(st.getId());
    assertStudentEquals(st, st2);
  }

  @Test
  public void should_remove_student_and_return_null() throws PersistenceException {
    ArrayList<Student> students = initialize_students_file();
    StudentDAOImpl dao = new StudentDAOImpl(DAL, parser);

    Student st1copy = dao.get(students.get(0).getId());
    Student st2copy = dao.get(students.get(1).getId());
    Student st3copy = dao.get(students.get(2).getId());

    assertStudentEquals(students.get(0), st1copy);
    assertStudentEquals(students.get(1), st2copy);
    assertStudentEquals(students.get(2), st3copy);

    dao.remove(st2copy);
    st2copy = dao.get(st2copy.getId());
    assertNull(st2copy);
  }

  @Test
  public void should_return_list_with_all_students() throws PersistenceException {
    ArrayList<Student> students = initialize_students_file();

    StudentDAOImpl dao = new StudentDAOImpl(DAL, parser);

    Student st1copy = dao.get(students.get(0).getId());
    Student st2copy = dao.get(students.get(1).getId());
    Student st3copy = dao.get(students.get(2).getId());

    assertStudentEquals(students.get(0), st1copy);
    assertStudentEquals(students.get(1), st2copy);
    assertStudentEquals(students.get(2), st3copy);
  }


  private void assertStudentEquals(Student st1, Student st2) {
    assertEquals(st1.getName(), st2.getName());
    assertEquals(st1.getIban(), st2.getIban());
    assertEquals(st1.getEnrollments(), st2.getEnrollments());
    assertEquals(st1.getId(), st2.getId());
    assertEquals(st1.getAddress(), st2.getAddress());
    assertEquals(st1.getZip(), st2.getZip());
    assertEquals(st1.getEnrollments(), st2.getEnrollments());
  }

}
