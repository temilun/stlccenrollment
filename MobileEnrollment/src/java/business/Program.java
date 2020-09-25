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
@Table(name="Program")

public class Program {
    @Id
    @Basic(optional = false)
    @Column(name = "prog_id")
    private String prog_id;
    @Basic(optional = false)
    @Column(name = "dept_name")
    private String dept_name;

    public String getProgId() {
        return prog_id;
    }

    public void setProgId(String prog_id) {
        this.prog_id = prog_id;
    }

    public String getDeptName() {
        return dept_name;
    }

    public void setDeptName(String dept_name) {
        this.dept_name = dept_name;
    }
}
