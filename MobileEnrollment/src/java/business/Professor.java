/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
@Table(name="professor")

public class Professor {
    @Id
    @Basic(optional = false)
    @Column(name = "prof_id")
    private String profId;
    @Basic(optional = false)
    @Column(name = "prof_fname")
    private String profFname;
    @Basic(optional = false)
    @Column(name = "prof_lname")
    private String profLname;
    @Column(name = "prof_email")
    private String profEmail;
    

    public Professor() {
        this.profId = "";
        this.profFname = "";
        this.profLname = "";
        this.profEmail = "";
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String getProfFname() {
        return profFname;
    }

    public void setProfFname(String profFname) {
        this.profFname = profFname;
    }

    public String getProfLname() {
        return profLname;
    }

    public void setProfLname(String profLname) {
        this.profLname = profLname;
    }

    public String getProfEmail() {
        return profEmail;
    }

    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }

    
}
