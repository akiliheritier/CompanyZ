/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.viewmodel;

import com.z.api.client.NidaClient;
import com.z.api.client.NidaDataResponse;
import com.z.domain.Country;
import com.z.domain.EAccountStatus;
import com.z.domain.EGender;
import com.z.domain.EMaritalStatus;
import com.z.domain.ERole;
import com.z.domain.IConstant;
import com.z.domain.User;
import com.z.service.UserService;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author akili.heritier
 */
public class RegisterViewModel {

    private final UserService userService = new UserService();
    private User userData;
    private String nationalID;
    private String message = "";
    private String typedPassword="";
    private String confirmedPassword="";
    private String country="Rwanda";
    private boolean showUserDetails=false;
    private boolean showPasswordField=false;
    private String operator="Get Details";
    private String names="";
    private String gender="";
    private String maritalStatus="";
    private Date dob;
    private String title="Welcome! Provide Your ID or Passport";
    public void isUserValid(final User user,RegisterViewModel view) {
        userData=new User();
        userData.setNationalId(user.getNationalId());
        //JOptionPane.showInputDialog(userService.loadDataInSpace());
        if (userService.checkUserIfExist(userData)) {
             message = "<p style=color:red>Sorry User Already Exist</p>";
        } else {
            NidaDataResponse data = NidaClient.validateNID(userData.getNationalId());
            if (data.getStatus().equals("success")) {
                showUserDetails=true;
                title="Create Account By Filling The Below Form";
                names=data.getData().getFirstname()+" "+data.getData().getLastName();
                gender=data.getData().getGender();
                maritalStatus=data.getData().getMaritalStatus();
                dob=data.getData().getDateOfBirth();
                if (view.getTypedPassword().equals(view.getConfirmedPassword())) {
                    if (isValidPassword(view.getConfirmedPassword())) {
                        userData.setPassword(userService.md5(view.getConfirmedPassword()));
                        userData.setAccountStatus(EAccountStatus.PENDING_VERIFICATION);
                        userData.setGender(EGender.valueOf(data.getData().getGender()));
                        userData.setMaritalStatus(EMaritalStatus.valueOf(data.getData().getMaritalStatus()));
                        userData.setNationalId(user.getNationalId());
                        Country count=new Country();
                        count.setCountryName(country);
                        userData.setNationality(count);
                        userData.setPhotoId("Default.png");
                        userData.setUserDateOfBirth(data.getData().getDateOfBirth());
                        userData.setUserFullName(data.getData().getFirstname()+" "+data.getData().getLastName());
                        userData.setUserId(UUID.randomUUID());
                        userData.setUsername(user.getUsername());
                        userData.setRole(ERole.USER);
                        if (userService.registerNewUser(userData)) {
                            showUserDetails=false;
                            message = "<p style=color:green>Well Done, Account Created,You Can Login Now</p>";
                        } else {
                            message = "<p style=color:red>Oops! A System Error Occured! Contact The Admin</>";
                        }
                    } else {
                        if(!typedPassword.equals("")){
                        message = "<p style=color:red><em class=\"help-block\">A minimum 8 characters password contains a combination of <strong>uppercase and lowercase letter,symbols</strong> and <strong>number</strong>.</em></p>";
                        }
                    }

                } else {
                    
                    message = "<p style=color:red>Sorry, The Password Should Be The Same</p>";
                }

            } else {
                message = "<p style=color:red>Sorry No Data Found From NIDA</p>";
            }

        }

    }

    public boolean isValidPassword(final String password) {
        Pattern pattern = Pattern.compile(IConstant.REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public RegisterViewModel() {
    }

    public User getUserData() {
        return userData;
    }

    public void setUserData(User userData) {
        this.userData = userData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypedPassword() {
        return typedPassword;
    }

    public void setTypedPassword(String typedPassword) {
        this.typedPassword = typedPassword;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public UserService getUserService() {
        return userService;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isShowUserDetails() {
        return showUserDetails;
    }

    public void setShowUserDetails(boolean showUserDetails) {
        this.showUserDetails = showUserDetails;
    }

    public boolean isShowPasswordField() {
        return showPasswordField;
    }

    public void setShowPasswordField(boolean showPasswordField) {
        this.showPasswordField = showPasswordField;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
