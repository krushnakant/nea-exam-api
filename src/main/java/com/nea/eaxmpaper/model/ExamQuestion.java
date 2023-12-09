// Project : eaxmpaperapi -> com.nea.eaxmpaper.model -> ExamQuestion.java
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
import jakarta.persistence.Lob;
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
@Table(name = "ExamQuestion")
@NamedQueries({
    @NamedQuery(name = "ExamQuestion.findAll", query = "SELECT e FROM ExamQuestion e"),
    @NamedQuery(name = "ExamQuestion.findByQuestionID", query = "SELECT e FROM ExamQuestion e WHERE e.questionID = :questionID"),
    @NamedQuery(name = "ExamQuestion.findByQuestionNumber", query = "SELECT e FROM ExamQuestion e WHERE e.questionNumber = :questionNumber"),
    @NamedQuery(name = "ExamQuestion.findByMarks", query = "SELECT e FROM ExamQuestion e WHERE e.marks = :marks"),
    @NamedQuery(name = "ExamQuestion.findByAmountOfLines", query = "SELECT e FROM ExamQuestion e WHERE e.amountOfLines = :amountOfLines")})
public class ExamQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "questionID")
    private Integer questionID;
    @Column(name = "questionNumber")
    private String questionNumber;
    @Lob
    @Column(name = "content")
    private byte[] content;
    @Column(name = "marks")
    private Integer marks;
    @Column(name = "amountOfLines")
    private Integer amountOfLines;
    @OneToMany(mappedBy = "questionID")
    private Collection<SubQuestion> subQuestionCollection;
    @JoinColumn(name = "examPaperID", referencedColumnName = "examPaperID")
    @ManyToOne
    private ExamPaper examPaperID;
    @OneToMany(mappedBy = "questionID")
    private Collection<Marks> marksCollection;

    public ExamQuestion() {
    }

    public ExamQuestion(Integer questionID) {
        this.questionID = questionID;
    }

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Integer getAmountOfLines() {
        return amountOfLines;
    }

    public void setAmountOfLines(Integer amountOfLines) {
        this.amountOfLines = amountOfLines;
    }

    public Collection<SubQuestion> getSubQuestionCollection() {
        return subQuestionCollection;
    }

    public void setSubQuestionCollection(Collection<SubQuestion> subQuestionCollection) {
        this.subQuestionCollection = subQuestionCollection;
    }

    public ExamPaper getExamPaperID() {
        return examPaperID;
    }

    public void setExamPaperID(ExamPaper examPaperID) {
        this.examPaperID = examPaperID;
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
        hash += (questionID != null ? questionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamQuestion)) {
            return false;
        }
        ExamQuestion other = (ExamQuestion) object;
        if ((this.questionID == null && other.questionID != null) || (this.questionID != null && !this.questionID.equals(other.questionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nea.eaxmpaper.model.ExamQuestion[ questionID=" + questionID + " ]";
    }

}
