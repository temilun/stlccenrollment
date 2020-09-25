/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Time;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "prof_id")
    private String profId;
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
    @Column(name = "enroll_avail")
    private int enrollAvail;
    @Column(name = "enroll_tot")
    private int enrollTot;
    @Column(name = "prereq")
    private String preReq;
    

    public Section() {
        this.crn = "";
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
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

    public int getEnrollAvail() {
        return enrollAvail;
    }

    public void setEnrollAvail(int enrollAvail) {
        this.enrollAvail = enrollAvail;
    }

    public int getEnrollTot() {
        return enrollTot;
    }

    public void setEnrollTot(int enrollTot) {
        this.enrollTot = enrollTot;
    }

    public String getPreReq() {
        return preReq;
    }

    public void setPreReq(String preReq) {
        this.preReq = preReq;
    }

    
}
