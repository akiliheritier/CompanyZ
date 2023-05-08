/*
 * 
 */
package com.z.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author akili.heritier
 *
 * @version 1.0
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByNames", query = "SELECT u FROM User u WHERE u.names = :names")
    , @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender")
    , @NamedQuery(name = "User.findByDateOfBirth", query = "SELECT u FROM User u WHERE u.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "User.findByMaritalStatus", query = "SELECT u FROM User u WHERE u.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "User.findByNationality", query = "SELECT u FROM User u WHERE u.nationality = :nationality")
    , @NamedQuery(name = "User.findByNationalId", query = "SELECT u FROM User u WHERE u.nationalId = :nationalId")
    , @NamedQuery(name = "User.findByAccountStatus", query = "SELECT u FROM User u WHERE u.accountStatus = :accountStatus")})
public class User implements Serializable{
    /*id*/
    @Id
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId;

    /*names*/
    @Column(name = "names")
    private String userFullName;

    /*Gender*/
    @Column(name = "gender")
    private EGender gender;

    /*userDateOfBirth*/
    @Column(name = "date_of_birth")
    private Date userDateOfBirth;

    /*maritalStatus*/
    @Column(name = "marital_status")
    private EMaritalStatus maritalStatus;

    /*nationality*/
    @Column(name = "nationality")
    private Country nationality;

    /*nationalId*/
    @Column(name = "national_id")
    private String nationalId;

    /*accountStatus*/
    @Column(name = "account_status")
    private EAccountStatus accountStatus;

    /*accountStatus*/
    @Column(name = "photoId")
    private String photoId;

    /*email*/
    @Column(name = "username")
    private String username;

    /*password*/
    @Column(name = "password")
    private String password;
    
    @Column(name="role")
    private ERole role;

    /**
     *
     */
    public User() {
    }

    /**
     *
     * @param userId
     */
    public User(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public Date getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(Date userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public EMaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(EMaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public EAccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(EAccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userFullName=" + userFullName + ", gender=" + gender + ", userDateOfBirth=" + userDateOfBirth + ", maritalStatus=" + maritalStatus + ", nationality=" + nationality + ", nationalId=" + nationalId + ", accountStatus=" + accountStatus + ", photoId=" + photoId + ", username=" + username + ", password=" + password + '}';
    }

}
