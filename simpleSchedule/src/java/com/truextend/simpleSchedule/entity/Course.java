package com.truextend.simpleSchedule.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author jplc
 */
@Entity
public class Course implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long code;
  private String title;
  private String description;
  @ManyToMany(targetEntity = Student.class)
  private Set studentSet;

  public Long getCode() {
    return code;
  }

  public void setCode(Long code) {
    if (code <= 0L) this.code = 0L;
    else this.code = code;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set getStudentSet() {
    return studentSet;
  }

  public void setStudentSet(Set studentSet) {
    this.studentSet = studentSet;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (code != null ? code.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Course)) {
      return false;
    }
    Course other = (Course) object;
    if ((this.code == null && other.code != null) 
        || (this.code != null && !this.code.equals(other.code))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.truextend.simpleSchedule.entity.Course[ id=" + code + " ]";
  }
  
}
