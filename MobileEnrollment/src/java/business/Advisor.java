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
@Table(name="advisor")

public class Advisor {
    @Id
    @Basic(optional = false)
    @Column(name = "adv_id")
    private int advId;
    @Basic(optional = false)
    @Column(name = "adv_fname")
    private String advFname;
    @Basic(optional = false)
    @Column(name = "adv_lname")
    private String advLname;
    @Column(name = "adv_phone")
    private int advPhone;
    @Basic(optional = false)
    @Column(name = "adv_email")
    private String advEmail;
    

    public Advisor() {
        this.advId = 0;
        this.advFname = "";
        this.advLname = "";
        this.advPhone = 0;
        this.advEmail = "";
    }

    public int getAdvId() {
        return advId;
    }

    public void setAdvId(int advId) {
        this.advId = advId;
    }

    public String getAdvFname() {
        return advFname;
    }

    public void setAdvFname(String advFname) {
        this.advFname = advFname;
    }

    public String getAdvLname() {
        return advLname;
    }

    public void setAdvLname(String advLname) {
        this.advLname = advLname;
    }

    public int getAdvPhone() {
        return advPhone;
    }

    public void setAdvPhone(int advPhone) {
        this.advPhone = advPhone;
    }

    public String getAdvEmail() {
        return advEmail;
    }

    public void setAdvEmail(String advEmail) {
        this.advEmail = advEmail;
    }
    
}
