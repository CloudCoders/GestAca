package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Student;
import org.junit.Test;


import static org.junit.Assert.*;

public class StudentDAOImplTest {

  @Test
  public void add_student() {
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


}