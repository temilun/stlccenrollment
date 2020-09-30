/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tom
 */
@Entity
@Table(name = "semester")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semester.findAll", query = "SELECT s FROM Semester s")
    , @NamedQuery(name = "Semester.findBySemId", query = "SELECT s FROM Semester s WHERE s.semId = :semId")
    , @NamedQuery(name = "Semester.findBySemYear", query = "SELECT s FROM Semester s WHERE s.semYear = :semYear")
    , @NamedQuery(name = "Semester.findBySemTerm", query = "SELECT s FROM Semester s WHERE s.semTerm = :semTerm")
    , @NamedQuery(name = "Semester.findBySemStart", query = "SELECT s FROM Semester s WHERE s.semStart = :semStart")
    , @NamedQuery(name = "Semester.findBySemEnd", query = "SELECT s FROM Semester s WHERE s.semEnd = :semEnd")})
public class Semester implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sem_id")
    private String semId;
    @Column(name = "sem_year")
    private String semYear;
    @Column(name = "sem_term")
    private String semTerm;
    @Column(name = "sem_start")
    @Temporal(TemporalType.DATE)
    private Date semStart;
    @Column(name = "sem_end")
    @Temporal(TemporalType.DATE)
    private Date semEnd;
    @OneToMany(mappedBy = "semId")
    private Collection<Transcript> transcriptCollection;

    public Semester() {
    }

    public Semester(String semId) {
        this.semId = semId;
    }

    public String getSemId() {
        return semId;
    }

    public void setSemId(String semId) {
        this.semId = semId;
    }

    public String getSemYear() {
        return semYear;
    }

    public void setSemYear(String semYear) {
        this.semYear = semYear;
    }

    public String getSemTerm() {
        return semTerm;
    }

    public void setSemTerm(String semTerm) {
        this.semTerm = semTerm;
    }

    public Date getSemStart() {
        return semStart;
    }

    public void setSemStart(Date semStart) {
        this.semStart = semStart;
    }

    public Date getSemEnd() {
        return semEnd;
    }

    public void setSemEnd(Date semEnd) {
        this.semEnd = semEnd;
    }

    @XmlTransient
    public Collection<Transcript> getTranscriptCollection() {
        return transcriptCollection;
    }

    public void setTranscriptCollection(Collection<Transcript> transcriptCollection) {
        this.transcriptCollection = transcriptCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semId != null ? semId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semester)) {
            return false;
        }
        Semester other = (Semester) object;
        if ((this.semId == null && other.semId != null) || (this.semId != null && !this.semId.equals(other.semId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.Semester[ semId=" + semId + " ]";
    }
    
}
