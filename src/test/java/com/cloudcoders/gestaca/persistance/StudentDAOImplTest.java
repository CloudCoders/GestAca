package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Student;
import org.junit.Before;
import org.junit.Test;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentDAOImplTest {

  @Test
  public void addStudent() {
    Student st = new Student(03725, "C/Dtr 2", "554564m", "Alsx asdas", "45454sf");
    StudentDAOImpl dao = new StudentDAOImpl();
    dao.add(st);
    Student st2 = dao.get(st.getId());
    assertEquals(st.getName(), st2.getName());
    assertEquals(st.getIban(), st2.getIban());
    assertEquals(st.getEnrollments(), st2.getEnrollments());
    assertEquals(st.getId(), st2.getId());
    assertEquals(st.getAddress(), st2.getAddress());
    assertEquals(st.getZip(), st2.getZip());
  }

  @Test
  public void removeStudent() {
    ArrayList<Student> students = new ArrayList<>();

    Student st1 = new Student(03725, "C/Dtr 1", "154564m", "Alsx asdas", "45454sf");
    Student st2 = new Student(03725, "C/Dtr 2", "254554m", "Alsx asdas", "45454sf");
    Student st3 = new Student(02147, "C/Dtr 3", "388854m", "Alsx asdas", "45454sf");

    StudentDAOImpl dao = new StudentDAOImpl();
    dao.add(st1);
    dao.add(st2);
    dao.add(st3);

    Student st1c = dao.get(st1.getId());
    Student st2c = dao.get(st2.getId());
    Student st3c = dao.get(st3.getId());

    assertEquals(st1.getName(), st1c.getName());
    assertEquals(st1.getIban(), st1c.getIban());
    assertEquals(st1.getEnrollments(), st1c.getEnrollments());
    assertEquals(st1.getId(), st1c.getId());
    assertEquals(st1.getAddress(), st1c.getAddress());
    assertEquals(st1.getZip(), st1c.getZip());

    assertEquals(st2.getName(), st2c.getName());
    assertEquals(st2.getIban(), st2c.getIban());
    assertEquals(st2.getEnrollments(), st2c.getEnrollments());
    assertEquals(st2.getId(), st2c.getId());
    assertEquals(st2.getAddress(), st2c.getAddress());
    assertEquals(st2.getZip(), st2c.getZip());

    assertEquals(st3.getName(), st3c.getName());
    assertEquals(st3.getIban(), st3c.getIban());
    assertEquals(st3.getEnrollments(), st3c.getEnrollments());
    assertEquals(st3.getId(), st3c.getId());
    assertEquals(st3.getAddress(), st3c.getAddress());
    assertEquals(st3.getZip(), st3c.getZip());

    dao.remove(st2);
    st2 = dao.get(st2.getId());
    assertNull(st2);
  }

  @Test
  public void getAllStudents() {
    ArrayList<Student> students = precondiciones();

    StudentDAOImpl dao = new StudentDAOImpl();

    Student st1c = dao.get(students.get(0).getId());
    Student st2c = dao.get(students.get(1).getId());
    Student st3c = dao.get(students.get(2).getId());

    assertEquals(students.get(0).getName(), st1c.getName());
    assertEquals(students.get(0).getIban(), st1c.getIban());
    assertEquals(students.get(0).getEnrollments(), st1c.getEnrollments());
    assertEquals(students.get(0).getId(), st1c.getId());
    assertEquals(students.get(0).getAddress(), st1c.getAddress());
    assertEquals(students.get(0).getZip(), st1c.getZip());

    assertEquals(students.get(1).getName(), st2c.getName());
    assertEquals(students.get(1).getIban(), st2c.getIban());
    assertEquals(students.get(1).getEnrollments(), st2c.getEnrollments());
    assertEquals(students.get(1).getId(), st2c.getId());
    assertEquals(students.get(1).getAddress(), st2c.getAddress());
    assertEquals(students.get(1).getZip(), st2c.getZip());

    assertEquals(students.get(2).getName(), st3c.getName());
    assertEquals(students.get(2).getIban(), st3c.getIban());
    assertEquals(students.get(2).getEnrollments(), st3c.getEnrollments());
    assertEquals(students.get(2).getId(), st3c.getId());
    assertEquals(students.get(2).getAddress(), st3c.getAddress());
    assertEquals(students.get(2).getZip(), st3c.getZip());

    dao.remove(st2c);
    st2c = dao.get(st2c.getId());
    assertNull(st2c);
  }

  public ArrayList<Student> precondiciones() {

    ArrayList<Student> students = new ArrayList<>();
    Student st1 = new Student(03725, "C/Dtr 1", "154564m", "Alsx asdas", "45454sf");
    Student st2 = new Student(03725, "C/Dtr 2", "254554m", "Alsx asdas", "45454sf");
    Student st3 = new Student(02147, "C/Dtr 3", "388854m", "Alsx asdas", "45454sf");

    students.add(st1);
    students.add(st2);
    students.add(st3);

    StudentDAOImpl dao = new StudentDAOImpl();
    dao.add(st1);
    dao.add(st2);
    dao.add(st3);
    return students;
  }

  @Before
  public void setup() {
    ClassLoader loader = getClass().getClassLoader();
    File file = null;
    try {
      file = new File(loader.getResource("Student.json").toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    try {
      FileWriter fw = new FileWriter(file, false);
      fw.write("[]".toCharArray());
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}