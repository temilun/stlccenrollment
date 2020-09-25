/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tom
 */
@Entity
@Table(name = "transcript")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transcript.findAll", query = "SELECT t FROM Transcript t")
    , @NamedQuery(name = "Transcript.findByTransId", query = "SELECT t FROM Transcript t WHERE t.transId = :transId")
    , @NamedQuery(name = "Transcript.findByCourseName", query = "SELECT t FROM Transcript t WHERE t.courseName = :courseName")
    , @NamedQuery(name = "Transcript.findByEnrollGrade", query = "SELECT t FROM Transcript t WHERE t.enrollGrade = :enrollGrade")})
public class Transcript implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trans_id")
    private String transId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "enroll_grade")
    private String enrollGrade;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne
    private Course courseId;
    @JoinColumn(name = "hold_id", referencedColumnName = "hold_id")
    @ManyToOne
    private Holds holdId;
    @JoinColumn(name = "sem_id", referencedColumnName = "sem_id")
    @ManyToOne
    private Semester semId;
    @JoinColumn(name = "stu_id", referencedColumnName = "stu_id")
    @ManyToOne
    private Students stuId;

    public Transcript() {
    }

    public Transcript(String transId) {
        this.transId = transId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getEnrollGrade() {
        return enrollGrade;
    }

    public void setEnrollGrade(String enrollGrade) {
        this.enrollGrade = enrollGrade;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Holds getHoldId() {
        return holdId;
    }

    public void setHoldId(Holds holdId) {
        this.holdId = holdId;
    }

    public Semester getSemId() {
        return semId;
    }

    public void setSemId(Semester semId) {
        this.semId = semId;
    }

    public Students getStuId() {
        return stuId;
    }

    public void setStuId(Students stuId) {
        this.stuId = stuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transId != null ? transId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transcript)) {
            return false;
        }
        Transcript other = (Transcript) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.Transcript[ transId=" + transId + " ]";
    }
    
}
