/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jonat
 */
@Entity
@Table(name = "enroll")
//@NamedQueries({
//    @NamedQuery(name = "Enroll.findAll", query = "SELECT e FROM Enroll e")})
public class Enroll implements Serializable {
    @Column(name = "enroll_date")
    @Temporal(TemporalType.DATE)
    private Date enrollDate;
    
    @Id
    @Basic(optional = false)
    @Column(name = "receipt")
    private Long receipt;
    
    @JoinColumn(name = "crn", referencedColumnName = "crn")
    @ManyToOne
    private String crn;
    
    @JoinColumn(name = "stu_id", referencedColumnName = "stu_id")
    @ManyToOne
    private String stuId;
    
    @OneToOne (fetch=FetchType.EAGER)
    @JoinColumn (name="stu_id",insertable=false,updatable=false)
    private Students student;
    
    @OneToOne (fetch=FetchType.EAGER)
    @JoinColumn (name="crn", insertable=false,updatable=false)
    private Section section;
    

    public Enroll() {
    }

    public Enroll(Long receipt) {
        this.receipt = receipt;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Long getReceipt() {
        return receipt;
    }

    public void setReceipt(Long receipt) {
        this.receipt = receipt;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
