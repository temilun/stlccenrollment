/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tom
 */

@Entity
@Table(name="section")

public class Section {


    @Id
    @Basic(optional = false)
    @Column(name = "crn")
    private String crn;
    @Column(name = "days")
    private String days;
    @Column(name = "time")
    private Time time;
    @Column(name = "sec_type")
    private String secType;
    @Column(name = "term_type")
    private String termType;
    @Column(name = "status")
    private String status;
    @Column(name = "prereq")
    private String preReq;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "enroll_avail")
    private String enrollAvail;
    @Column(name = "enroll_tot")
    private String enrollTot;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "prof_id", referencedColumnName = "prof_id")
    private String profId;
    

    public Section() {
        this.crn = "";
        this.courseId = null;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPreReq() {
        return preReq;
    }

    public void setPreReq(String preReq) {
        this.preReq = preReq;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEnrollAvail() {
        return enrollAvail;
    }

    public void setEnrollAvail(String enrollAvail) {
        this.enrollAvail = enrollAvail;
    }

    public String getEnrollTot() {
        return enrollTot;
    }

    public void setEnrollTot(String enrollTot) {
        this.enrollTot = enrollTot;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    
}
