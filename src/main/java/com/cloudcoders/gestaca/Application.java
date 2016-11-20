package com.cloudcoders.gestaca;

import com.cloudcoders.gestaca.logic.course.AddCourse;
import com.cloudcoders.gestaca.logic.course.GetAllCourses;
import com.cloudcoders.gestaca.logic.enrollment.AddEnrollment;
import com.cloudcoders.gestaca.logic.student.AddStudent;
import com.cloudcoders.gestaca.logic.student.GetStudent;
import com.cloudcoders.gestaca.persistance.CourseDAOImpl;
import com.cloudcoders.gestaca.persistance.EnrollmentDAOImpl;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.StudentDAOImpl;
import com.cloudcoders.gestaca.persistance.TaughtCourseDAOImpl;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import com.cloudcoders.gestaca.ui.CommandLine;
import com.cloudcoders.gestaca.ui.controller.Command;
import com.cloudcoders.gestaca.ui.controller.CreateCourseCommand;
import com.cloudcoders.gestaca.ui.controller.EnrollmentCommand;
import com.cloudcoders.gestaca.ui.controller.Processor;
import com.google.gson.Gson;

import java.util.Scanner;

public class Application {

  public static void main(String... args) {
    CommandLine commandLine = new CommandLine(new Scanner(System.in));
    FileDAL dal = new FileDAL();
    JsonParser jsonParser = new JsonParser(new Gson());
    StudentDAOImpl iStudentDAO = new StudentDAOImpl(dal, jsonParser);
    GetStudent getStudentUseCase = new GetStudent(iStudentDAO);
    CourseDAOImpl icourseDAO = new CourseDAOImpl(dal, jsonParser);
    GetAllCourses getAllCoursesUseCase = new GetAllCourses(icourseDAO);
    EnrollmentDAOImpl iEnrollmentDAO = new EnrollmentDAOImpl(dal, jsonParser);
    AddEnrollment addEnrollment = new AddEnrollment(iEnrollmentDAO, new TaughtCourseDAOImpl(dal), iStudentDAO);
    EnrollmentCommand enrollmentCommand = new EnrollmentCommand(commandLine, getStudentUseCase, getAllCoursesUseCase, addEnrollment, new AddStudent(iStudentDAO));
    AddCourse addCourse = new AddCourse(new CourseDAOImpl(dal, jsonParser));
    CreateCourseCommand createCommand = new CreateCourseCommand(commandLine, addCourse);
    Processor processor = new Processor(enrollmentCommand, createCommand);

    String command = null;
    do {
      command = commandLine.typeCommand();
      Command process = processor.process(command);
      if (process != null) process.execute();

    } while (!command.equals("exit"));
  }

}
