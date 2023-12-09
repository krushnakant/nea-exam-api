// Project : eaxmpaperapi -> com.nea.eaxmpaper.model -> Teacher.java
// Author  : krushnakant
// Created : 9 Dec 2023 15:21:20

package com.nea.eaxmpaper.model;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author krushnakant
 */
@Entity
@Table(name = "Teacher")
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacherID", query = "SELECT t FROM Teacher t WHERE t.teacherID = :teacherID"),
    @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "Teacher.findByLastName", query = "SELECT t FROM Teacher t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "Teacher.findByEmail", query = "SELECT t FROM Teacher t WHERE t.email = :email"),
    @NamedQuery(name = "Teacher.findByDepartment", query = "SELECT t FROM Teacher t WHERE t.department = :department"),
    @NamedQuery(name = "Teacher.findByPassword", query = "SELECT t FROM Teacher t WHERE t.password = :password")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 11L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teacherID")
    private Integer teacherID;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "department")
    private String department;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "teacherID")
    private Collection<Marks> marksCollection;
    @OneToMany(mappedBy = "teacherID")
    private Collection<ExamPaper> examPaperCollection;

    public Teacher() {
    }

    public Teacher(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Marks> getMarksCollection() {
        return marksCollection;
    }

    public void setMarksCollection(Collection<Marks> marksCollection) {
        this.marksCollection = marksCollection;
    }

    public Collection<ExamPaper> getExamPaperCollection() {
        return examPaperCollection;
    }

    public void setExamPaperCollection(Collection<ExamPaper> examPaperCollection) {
        this.examPaperCollection = examPaperCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherID != null ? teacherID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherID == null && other.teacherID != null) || (this.teacherID != null && !this.teacherID.equals(other.teacherID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nea.eaxmpaper.model.Teacher[ teacherID=" + teacherID + " ]";
    }

}
