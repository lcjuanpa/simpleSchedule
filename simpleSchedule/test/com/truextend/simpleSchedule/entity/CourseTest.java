package com.truextend.simpleSchedule.entity;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jplc
 */
public class CourseTest {

  @Test
  public void setCodeUsingNaturalNumbersIsOk() {
    Course course = new Course();
    Long expected = new Long(1);
    course.setCode(expected);
    assertEquals(expected, course.getCode());
  }
  
  @Test
  public void setCodeToZeroUsingNegativeNumbers() {
    Course course = new Course();
    course.setCode(new Long(-11));
    assertEquals(0L, (long)course.getCode());
  }

  @Test
  public void assignStudentToCourse() {
    Set<Student> students = getStudentSet();
    Course course = new Course();
    assertNull(course.getStudentSet());
    
    course.setCode(1L);
    course.setTitle("Math");
    course.setDescription("Basic Math class");
    course.setStudentSet(students);
    assertNotNull(course.getStudentSet());
    assertEquals(students.size(), course.getStudentSet().size());
  }
  
  private Set getStudentSet() {
    Student s1 = new Student();
    s1.setId(1L);
    s1.setLastname("lopez");
    s1.setFirstname("juan");
    Student s2 = new Student();
    s2.setId(2L);
    s2.setLastname("choque");
    s2.setFirstname("pablo");
    Student s3 = new Student();
    s3.setId(3L);
    s3.setLastname("garcia");
    s3.setFirstname("carlos");
    Student s4 = new Student();
    s4.setId(4L);
    s4.setLastname("lopez");
    s4.setFirstname("raul");
    Student s5 = new Student();
    s5.setId(5L);
    s5.setLastname("sejas");
    s5.setFirstname("alvaro");
    
    Set<Student> students = new HashSet<>();
    students.add(s1);
    students.add(s2);
    students.add(s3);
    students.add(s4);
    students.add(s5);
    return students;
  }
  
}
