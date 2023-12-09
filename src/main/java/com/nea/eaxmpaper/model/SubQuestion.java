// Project : eaxmpaperapi -> com.nea.eaxmpaper.model -> SubQuestion.java
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
@Table(name = "SubQuestion")
@NamedQueries({
    @NamedQuery(name = "SubQuestion.findAll", query = "SELECT s FROM SubQuestion s"),
    @NamedQuery(name = "SubQuestion.findBySubQuestionID", query = "SELECT s FROM SubQuestion s WHERE s.subQuestionID = :subQuestionID"),
    @NamedQuery(name = "SubQuestion.findBySubQuestionNumber", query = "SELECT s FROM SubQuestion s WHERE s.subQuestionNumber = :subQuestionNumber"),
    @NamedQuery(name = "SubQuestion.findByMarks", query = "SELECT s FROM SubQuestion s WHERE s.marks = :marks"),
    @NamedQuery(name = "SubQuestion.findByAmountOfLines", query = "SELECT s FROM SubQuestion s WHERE s.amountOfLines = :amountOfLines")})
public class SubQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subQuestionID")
    private Integer subQuestionID;
    @Column(name = "subQuestionNumber")
    private String subQuestionNumber;
    @Lob
    @Column(name = "content")
    private byte[] content;
    @Column(name = "marks")
    private Integer marks;
    @Column(name = "amountOfLines")
    private Integer amountOfLines;
    @JoinColumn(name = "questionID", referencedColumnName = "questionID")
    @ManyToOne
    private ExamQuestion questionID;
    @OneToMany(mappedBy = "subQuestionID")
    private Collection<Marks> marksCollection;

    public SubQuestion() {
    }

    public SubQuestion(Integer subQuestionID) {
        this.subQuestionID = subQuestionID;
    }

    public Integer getSubQuestionID() {
        return subQuestionID;
    }

    public void setSubQuestionID(Integer subQuestionID) {
        this.subQuestionID = subQuestionID;
    }

    public String getSubQuestionNumber() {
        return subQuestionNumber;
    }

    public void setSubQuestionNumber(String subQuestionNumber) {
        this.subQuestionNumber = subQuestionNumber;
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

    public ExamQuestion getQuestionID() {
        return questionID;
    }

    public void setQuestionID(ExamQuestion questionID) {
        this.questionID = questionID;
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
        hash += (subQuestionID != null ? subQuestionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubQuestion)) {
            return false;
        }
        SubQuestion other = (SubQuestion) object;
        if ((this.subQuestionID == null && other.subQuestionID != null) || (this.subQuestionID != null && !this.subQuestionID.equals(other.subQuestionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nea.eaxmpaper.model.SubQuestion[ subQuestionID=" + subQuestionID + " ]";
    }

}
