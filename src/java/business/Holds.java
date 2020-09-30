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
@Table(name = "holds")
@XmlRootElement

public class Holds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hold_id")
    private String holdId;
    @Column(name = "hold_desc")
    private String holdDesc;
    @OneToMany(mappedBy = "holdId")
    private Collection<Transcript> transcriptCollection;

    public Holds() {
    }

    public Holds(String holdId) {
        this.holdId = holdId;
    }

    public String getHoldId() {
        return holdId;
    }

    public void setHoldId(String holdId) {
        this.holdId = holdId;
    }

    public String getHoldDesc() {
        return holdDesc;
    }

    public void setHoldDesc(String holdDesc) {
        this.holdDesc = holdDesc;
    }

    @XmlTransient
    public Collection<Transcript> getTranscriptCollection() {
        return transcriptCollection;
    }

    public void setTranscriptCollection(Collection<Transcript> transcriptCollection) {
        this.transcriptCollection = transcriptCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (holdId != null ? holdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Holds)) {
            return false;
        }
        Holds other = (Holds) object;
        if ((this.holdId == null && other.holdId != null) || (this.holdId != null && !this.holdId.equals(other.holdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.Holds[ holdId=" + holdId + " ]";
    }
    
}
