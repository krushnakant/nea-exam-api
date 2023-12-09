// Project : eaxmpaper -> com.nea.eaxmpaper.model -> Student.java
// Author  : krushnakant
// Created : 9 Dec 2023 11:42:54
package com.nea.eaxmpaper.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;

/**
 *
 * @author krushnakant
 */
@Entity
@Table(name = "Student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "Student.findByFName", query = "SELECT s FROM Student s WHERE s.fName = :fName"),
    @NamedQuery(name = "Student.findByLname", query = "SELECT s FROM Student s WHERE s.lname = :lname")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "studentID")
    private Integer studentID;
    @Column(name = "fName")
    private String fName;
    @Column(name = "lname")
    private String lname;
    @OneToMany(mappedBy = "studentID", fetch = FetchType.LAZY)
    private Collection<Marks> marksCollection;

    public Student() {
    }

    public Student(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Collection<Marks> getMarksCollection() {
        return marksCollection;
    }

    public void setMarksCollection(Collection<Marks> marksCollection) {
        this.marksCollection = marksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nea.eaxmpaper.model.Student[ studentID=" + studentID + " ]";
    }

}
