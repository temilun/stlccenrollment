/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tom
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId")
    , @NamedQuery(name = "Course.findByCourseLevel", query = "SELECT c FROM Course c WHERE c.courseLevel = :courseLevel")
    , @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName")
    , @NamedQuery(name = "Course.findByCourseDesc", query = "SELECT c FROM Course c WHERE c.courseDesc = :courseDesc")
    , @NamedQuery(name = "Course.findByCourseCredit", query = "SELECT c FROM Course c WHERE c.courseCredit = :courseCredit")})
public class Course implements Serializable {

    @Column(name = "course_sub")
    private String courseSub;
    @Column(name = "sub_abbrev")
    private String subAbbrev;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<Section> sectionCollection;

    
    @Id
    @Basic(optional = false)
    @Column(name = "course_id")
    private String courseId;
    @Column(name = "course_level")
    private String courseLevel;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_desc")
    private String courseDesc;
    @Column(name = "course_credit")
    private Integer courseCredit;
    @OneToMany(mappedBy = "courseId")
    private Collection<Transcript> transcriptCollection;
    @JoinColumn(name = "prog_id", referencedColumnName = "prog_id")
    @ManyToOne
    private Program progId;

    public Course() {
    }

    public Course(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    @XmlTransient
    public Collection<Transcript> getTranscriptCollection() {
        return transcriptCollection;
    }

    public void setTranscriptCollection(Collection<Transcript> transcriptCollection) {
        this.transcriptCollection = transcriptCollection;
    }

    public Program getProgId() {
        return progId;
    }

    public void setProgId(Program progId) {
        this.progId = progId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.Course[ courseId=" + courseId + " ]";
    }

    public String getCourseSub() {
        return courseSub;
    }

    public void setCourseSub(String courseSub) {
        this.courseSub = courseSub;
    }

    public String getSubAbbrev() {
        return subAbbrev;
    }

    public void setSubAbbrev(String subAbbrev) {
        this.subAbbrev = subAbbrev;
    }

    @XmlTransient
    public Collection<Section> getSectionCollection() {
        return sectionCollection;
    }

    public void setSectionCollection(Collection<Section> sectionCollection) {
        this.sectionCollection = sectionCollection;
    }
    
}
