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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tom
 */

@Entity
@Table(name="building")

public class Building {
    @Id
    @Basic(optional = false)
    @Column(name = "build_id")
    private String buildId;
    
    @Column(name = "build_name")
    private String buildName;
    
    @JoinColumn(name = "camp_id", insertable=false, updatable=false)
    @ManyToOne( targetEntity = Campus.class)
    private Campus campus;
    
    @Column(name = "camp_id")
    private String campId;

    

    public Building() {
        this.buildId = "";
        this.buildName = "";
        this.campId = "";
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getCampId() {
        return campId;
    }

    public void setCampId(String campId) {
        this.campId = campId;
    } 

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
    
}
