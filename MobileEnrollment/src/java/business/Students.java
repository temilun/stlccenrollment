/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author tom
 */
@Entity
@Table(name = "students")

public class Students implements Serializable {

    @Column(name = "stu_initial")
    private String stuInitial;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "stuId")
    private Collection<Enroll> enrollCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "stu_id")
    private String stuId;
    @Basic(optional = false)
    @Column(name = "stu_fname")
    private String stuFname;
    @Basic(optional = false)
    @Column(name = "stu_lname")
    private String stuLname;
    @Column(name = "stu_email")
    private String stuEmail;
    @Column(name = "password")
    private String password;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zipcode")
    private Integer zipcode;
    @Column(name = "username")
    private String username;
    
    @Transient
    private String passattempt;
    
    @JoinColumn(name = "adv_id", referencedColumnName = "adv_id")
    @ManyToOne
    private Advisor advId;
    @JoinColumn(name = "prog_id", referencedColumnName = "prog_id")
    @ManyToOne
    private Program progId;
    @OneToMany(mappedBy = "stuId")
    private Collection<Transcript> transcriptCollection;

    public Students() {
    }

    public Students(String stuId) {
        this.stuId = stuId;
    }

    public Students(String stuId, String stuFname, String stuLname) {
        this.stuId = stuId;
        this.stuFname = stuFname;
        this.stuLname = stuLname;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuFname() {
        return stuFname;
    }

    public void setStuFname(String stuFname) {
        this.stuFname = stuFname;
    }

    public String getStuLname() {
        return stuLname;
    }

    public void setStuLname(String stuLname) {
        this.stuLname = stuLname;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Advisor getAdvId() {
        return advId;
    }

    public void setAdvId(Advisor advId) {
        this.advId = advId;
    }

    public Program getProgId() {
        return progId;
    }

    public void setProgId(Program progId) {
        this.progId = progId;
    }

    public void setPassAttempt(String patt) {
        this.passattempt = patt;
    }
    
    public boolean isAuthenticated() {
        if (this.password != "") {
            if(this.password.equals(this.passattempt)) {
                return true;
            }
        }
        return false;
    }
    
    @XmlTransient
    public Collection<Transcript> getTranscriptCollection() {
        return transcriptCollection;
    }

    public void setTranscriptCollection(Collection<Transcript> transcriptCollection) {
        this.transcriptCollection = transcriptCollection;
    }

    public String getStuInitial() {
        return stuInitial;
    }

    public void setStuInitial(String stuInitial) {
        this.stuInitial = stuInitial;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*public Collection<Enroll> getEnrollCollection() {
        return enrollCollection;
    }

    public void setEnrollCollection(Collection<Enroll> enrollCollection) {
        this.enrollCollection = enrollCollection;
    } */
    
}
