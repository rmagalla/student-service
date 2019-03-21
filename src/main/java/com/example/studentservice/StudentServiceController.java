package com.example.studentservice;

import com.example.studentservice.model.Student;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServiceController {

  private static Map<String, Student> students = new HashMap<String, Student>();

  static {
    students.put("1", new Student("Roberto", "Spring Boot"));
    students.put("2", new Student("Roberto Magallanes", "Spring Boot"));
    students.put("3", new Student("Guille", "Spring Boot"));
    students.put("4", new Student("Guillermo", "Spring Boot"));
    students.put("5", new Student("Juan", "Spring Boot"));
  }

  @GetMapping(value = "/student/{id}")
  public Student getStudent(@PathVariable String id) {
    System.out.println("AQUI!!!!!!");
    Student student = students.get(id);
    if (student == null) {
      student = new Student();
      student.setName("Not Found");
      student.setCourseName("N/A");
    }
    return student;
  }
}
