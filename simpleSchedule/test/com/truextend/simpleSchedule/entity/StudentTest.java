package com.truextend.simpleSchedule.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jplc
 */
public class StudentTest {
  
  @Test
  public void setIdUsingNaturalNumbersIsOk() {
    Student student = new Student();
    Long expected = new Long(1);
    student.setId(expected);
    assertEquals(expected, student.getId());
  }

  @Test
  public void setIdToZeroUsingNegativeNumbers() {
    Student student = new Student();
    student.setId(new Long(-11));
    assertEquals(0L, (long)student.getId());
  }
  
}
