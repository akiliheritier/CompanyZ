/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.viewmodel;

import com.z.domain.Country;
import com.z.domain.Setting;
import com.z.domain.User;
import com.z.service.CountryService;
import com.z.service.SettingService;
import com.z.service.UserService;
import java.util.ArrayList;
import java.util.List; 

  

/**
 *
 * @author akili.heritier
 */
public class LoginViewModel {
    private List<Country>countriesList=new ArrayList<>();
    private List<User>usersList=new ArrayList<>();
    private List<Setting>settingsList=new ArrayList<>();
    private Setting metaData=new Setting();
    private final SettingService settingService=new SettingService();
    private final UserService userService=new UserService();
    private final CountryService countryService=new CountryService();
    private String username;
    private String password;
    private User loggedUser;
    private String message="";
    
    public void init() {
        countriesList= countryService.loadDataInSpace();
        usersList=userService.loadDataInSpace();
        settingsList=settingService.loadDataInSpace();
        metaData=settingService.getMetaDataInSpace();
        
    }
    public User loginUser(){
          loggedUser=new User();
          loggedUser.setUsername(username);
          loggedUser.setPassword(userService.md5(password));
          loggedUser=userService.loginUser(loggedUser);
          if(null!=loggedUser){
              return loggedUser;
          }else{
              message="<p style=color:red>Invalid Username or Password<p>";
              return null;
          }
    }

    public List<Country> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(List<Country> countriesList) {
        this.countriesList = countriesList;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public Setting getMetaData() {
        return metaData;
    }
 

    public List<Setting> getSettingsList() {
        return settingsList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserService getUserService() {
        return userService;
    }
 
    
    
    
}
