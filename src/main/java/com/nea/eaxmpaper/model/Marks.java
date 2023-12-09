// Project : eaxmpaperapi -> com.nea.eaxmpaper.model -> Marks.java
// Author  : krushnakant
// Created : 9 Dec 2023 15:21:20

package com.nea.eaxmpaper.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author krushnakant
 */
@Entity
@Table(name = "Marks")
@NamedQueries({
    @NamedQuery(name = "Marks.findAll", query = "SELECT m FROM Marks m"),
    @NamedQuery(name = "Marks.findByMarksID", query = "SELECT m FROM Marks m WHERE m.marksID = :marksID"),
    @NamedQuery(name = "Marks.findByMarksObtained", query = "SELECT m FROM Marks m WHERE m.marksObtained = :marksObtained"),
    @NamedQuery(name = "Marks.findByTotalMarks", query = "SELECT m FROM Marks m WHERE m.totalMarks = :totalMarks")})
public class Marks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "marksID")
    private Integer marksID;
    @Column(name = "marksObtained")
    private Integer marksObtained;
    @Column(name = "totalMarks")
    private Integer totalMarks;
    @JoinColumn(name = "examPaperID", referencedColumnName = "examPaperID")
    @ManyToOne
    private ExamPaper examPaperID;
    @JoinColumn(name = "questionID", referencedColumnName = "questionID")
    @ManyToOne
    private ExamQuestion questionID;
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    @ManyToOne
    private Student studentID;
    @JoinColumn(name = "subQuestionID", referencedColumnName = "subQuestionID")
    @ManyToOne
    private SubQuestion subQuestionID;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne
    private Teacher teacherID;

    public Marks() {
    }

    public Marks(Integer marksID) {
        this.marksID = marksID;
    }

    public Integer getMarksID() {
        return marksID;
    }

    public void setMarksID(Integer marksID) {
        this.marksID = marksID;
    }

    public Integer getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(Integer marksObtained) {
        this.marksObtained = marksObtained;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public ExamPaper getExamPaperID() {
        return examPaperID;
    }

    public void setExamPaperID(ExamPaper examPaperID) {
        this.examPaperID = examPaperID;
    }

    public ExamQuestion getQuestionID() {
        return questionID;
    }

    public void setQuestionID(ExamQuestion questionID) {
        this.questionID = questionID;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    public SubQuestion getSubQuestionID() {
        return subQuestionID;
    }

    public void setSubQuestionID(SubQuestion subQuestionID) {
        this.subQuestionID = subQuestionID;
    }

    public Teacher getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Teacher teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marksID != null ? marksID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marks)) {
            return false;
        }
        Marks other = (Marks) object;
        if ((this.marksID == null && other.marksID != null) || (this.marksID != null && !this.marksID.equals(other.marksID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nea.eaxmpaper.model.Marks[ marksID=" + marksID + " ]";
    }

}
