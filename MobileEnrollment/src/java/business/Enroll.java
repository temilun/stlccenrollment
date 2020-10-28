/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author tom
 */

@Entity
@Table(name="enroll")
public class Enroll {
    @Column(name = "crn")
    @Basic(optional = false)
    private String crn;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "crn", insertable = false, updatable = false)
    private Section section;
    
    @Column(name = "stu_id")
    @Basic(optional = false)
    private String stuId;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stu_ID", insertable = false, updatable = false)
    private Students student;
    
    @Column(name = "enroll_date")
    @Basic(optional = false)
    private Date enrollDate;
    
    @Id
    @Column(name = "receipt")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    private int receipt;

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrlDate) {
        this.enrollDate = enrlDate;
    }

    public int getReceipt() {
        return receipt;
    }

    public void setReceipt(int receipt) {
        this.receipt = receipt;
    }
    
    
            
}
