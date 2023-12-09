// Project : eaxmpaperapi -> com.nea.eaxmpaper.model -> ExamPaper.java
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;

/**
 *
 * @author krushnakant
 */
@Entity
@Table(name = "ExamPaper")
@NamedQueries({
    @NamedQuery(name = "ExamPaper.findAll", query = "SELECT e FROM ExamPaper e"),
    @NamedQuery(name = "ExamPaper.findByExamPaperID", query = "SELECT e FROM ExamPaper e WHERE e.examPaperID = :examPaperID"),
    @NamedQuery(name = "ExamPaper.findByYearGroup", query = "SELECT e FROM ExamPaper e WHERE e.yearGroup = :yearGroup"),
    @NamedQuery(name = "ExamPaper.findByTypeOfExam", query = "SELECT e FROM ExamPaper e WHERE e.typeOfExam = :typeOfExam"),
    @NamedQuery(name = "ExamPaper.findByPaperNumber", query = "SELECT e FROM ExamPaper e WHERE e.paperNumber = :paperNumber"),
    @NamedQuery(name = "ExamPaper.findBySubject", query = "SELECT e FROM ExamPaper e WHERE e.subject = :subject"),
    @NamedQuery(name = "ExamPaper.findByDuration", query = "SELECT e FROM ExamPaper e WHERE e.duration = :duration"),
    @NamedQuery(name = "ExamPaper.findByInstructions", query = "SELECT e FROM ExamPaper e WHERE e.instructions = :instructions"),
    @NamedQuery(name = "ExamPaper.findByMaterials", query = "SELECT e FROM ExamPaper e WHERE e.materials = :materials"),
    @NamedQuery(name = "ExamPaper.findByTotalMark", query = "SELECT e FROM ExamPaper e WHERE e.totalMark = :totalMark"),
    @NamedQuery(name = "ExamPaper.findByStatus", query = "SELECT e FROM ExamPaper e WHERE e.status = :status")})
public class ExamPaper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "examPaperID")
    private Integer examPaperID;
    @Column(name = "yearGroup")
    private Integer yearGroup;
    @Column(name = "typeOfExam")
    private String typeOfExam;
    @Column(name = "paperNumber")
    private String paperNumber;
    @Column(name = "subject")
    private String subject;
    @Column(name = "duration")
    private String duration;
    @Column(name = "instructions")
    private String instructions;
    @Column(name = "materials")
    private String materials;
    @Column(name = "totalMark")
    private Integer totalMark;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "examPaperID")
    private Collection<ExamQuestion> examQuestionCollection;
    @OneToMany(mappedBy = "examPaperID")
    private Collection<Marks> marksCollection;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne
    private Teacher teacherID;

    public ExamPaper() {
    }

    public ExamPaper(Integer examPaperID) {
        this.examPaperID = examPaperID;
    }

    public Integer getExamPaperID() {
        return examPaperID;
    }

    public void setExamPaperID(Integer examPaperID) {
        this.examPaperID = examPaperID;
    }

    public Integer getYearGroup() {
        return yearGroup;
    }

    public void setYearGroup(Integer yearGroup) {
        this.yearGroup = yearGroup;
    }

    public String getTypeOfExam() {
        return typeOfExam;
    }

    public void setTypeOfExam(String typeOfExam) {
        this.typeOfExam = typeOfExam;
    }

    public String getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
        this.paperNumber = paperNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public Integer getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Integer totalMark) {
        this.totalMark = totalMark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<ExamQuestion> getExamQuestionCollection() {
        return examQuestionCollection;
    }

    public void setExamQuestionCollection(Collection<ExamQuestion> examQuestionCollection) {
        this.examQuestionCollection = examQuestionCollection;
    }

    public Collection<Marks> getMarksCollection() {
        return marksCollection;
    }

    public void setMarksCollection(Collection<Marks> marksCollection) {
        this.marksCollection = marksCollection;
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
        hash += (examPaperID != null ? examPaperID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamPaper)) {
            return false;
        }
        ExamPaper other = (ExamPaper) object;
        if ((this.examPaperID == null && other.examPaperID != null) || (this.examPaperID != null && !this.examPaperID.equals(other.examPaperID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nea.eaxmpaper.model.ExamPaper[ examPaperID=" + examPaperID + " ]";
    }

}
