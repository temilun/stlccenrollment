/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "campus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campus.findAll", query = "SELECT c FROM Campus c")
    , @NamedQuery(name = "Campus.findByCampId", query = "SELECT c FROM Campus c WHERE c.campId = :campId")
    , @NamedQuery(name = "Campus.findByCampName", query = "SELECT c FROM Campus c WHERE c.campName = :campName")})
public class Campus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "camp_id")
    private String campId;
    @Column(name = "camp_name")
    private String campName;
    @OneToMany(mappedBy = "campId")
    private Collection<Building> buildingCollection;

    public Campus() {
    }

    public Campus(String campId) {
        this.campId = campId;
    }

    public String getCampId() {
        return campId;
    }

    public void setCampId(String campId) {
        this.campId = campId;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    @XmlTransient
    public Collection<Building> getBuildingCollection() {
        return buildingCollection;
    }

    public void setBuildingCollection(Collection<Building> buildingCollection) {
        this.buildingCollection = buildingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campId != null ? campId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campus)) {
            return false;
        }
        Campus other = (Campus) object;
        if ((this.campId == null && other.campId != null) || (this.campId != null && !this.campId.equals(other.campId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.Campus[ campId=" + campId + " ]";
    }
    
}
