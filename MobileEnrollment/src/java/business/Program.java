 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tom
 */

@Entity
@Table(name="program")

public class Program {


    @Id
    @Basic(optional = false)
    @Column(name = "prog_id")
    private String progId;
    @Column(name = "dept_id")
    /*@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    @ManyToOne*/
    private String deptId;    
    @Basic(optional = false)
    @Column(name = "prog_name")
    private String progName;
    @Column(name = "prog_type")
    @Basic(optional = false)
    private String progType;

    
    public Program() {
        this.progId = "";
        this.deptId = "";
        this.progName ="";
        this.progType = "";
    }
    
    public String getProgId() {
        return progId;
    }

    public void setProgId(String progId) {
        this.progId = progId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public String getProgType() {
        return progType;
    }

    public void setProgType(String progType) {
        this.progType = progType;
    }




}
