/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "nida_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NidaData.findAll", query = "SELECT n FROM NidaData n")
    , @NamedQuery(name = "NidaData.findById", query = "SELECT n FROM NidaData n WHERE n.id = :id")
    , @NamedQuery(name = "NidaData.findByFirstname", query = "SELECT n FROM NidaData n WHERE n.firstname = :firstname")
    , @NamedQuery(name = "NidaData.findByLastName", query = "SELECT n FROM NidaData n WHERE n.lastName = :lastName")
    , @NamedQuery(name = "NidaData.findByDateOfBirth", query = "SELECT n FROM NidaData n WHERE n.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "NidaData.findByGender", query = "SELECT n FROM NidaData n WHERE n.gender = :gender")
    , @NamedQuery(name = "NidaData.findByMaritalStatus", query = "SELECT n FROM NidaData n WHERE n.maritalStatus = :maritalStatus")})
public class NidaData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "marital_status")
    private String maritalStatus;

    public NidaData() {
    }

    public NidaData(String id) {
        this.id = id;
    }

    public NidaData(String id, String firstname, String lastName) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NidaData)) {
            return false;
        }
        NidaData other = (NidaData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
 

     
    
}
