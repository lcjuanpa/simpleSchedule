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
public class Student implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String lastname;
  private String firstname;
  @ManyToMany(targetEntity = Course.class)
  private Set courseSet;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = (id <= 0L ? 0L : id);
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Set getCourseSet() {
    return courseSet;
  }

  public void setCourseSet(Set courseSet) {
    this.courseSet = courseSet;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Student)) {
      return false;
    }
    Student other = (Student) object;
    if ((this.id == null && other.id != null) 
        || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.truextend.simpleSchedule.entity.Student[ id=" + id + " ]";
  }
  
}
