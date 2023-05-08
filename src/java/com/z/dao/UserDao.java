/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.dao;

import com.z.domain.Country;
import com.z.domain.EAccountStatus;
import com.z.domain.EGender;
import com.z.domain.EMaritalStatus;
import com.z.domain.ERole;
import com.z.domain.User;
import datasource.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author akili.heritier
 */
public class UserDao implements IUserDao {

    private User userData = null;
    private final List<User> userList = new ArrayList<>();
    private final Connection con = DataSource.getConnection();
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean registerNewUser(User user) {
        try {
            Connection con = DataSource.getConnection();
            pst = con.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, user.getUserId().toString());
            pst.setString(2, user.getUserFullName());
            pst.setString(3, user.getGender().name());
            pst.setDate(4, new java.sql.Date(user.getUserDateOfBirth().getTime()));
            pst.setString(5, user.getMaritalStatus().name());
            pst.setString(6, user.getNationality().getCountryName());
            pst.setString(7, user.getNationalId());
            pst.setString(8, user.getAccountStatus().name());
            pst.setString(9, user.getPhotoId());
            pst.setString(10, user.getUsername());
            pst.setString(11, user.getPassword());
            pst.setString(12,user.getRole().name());
            pst.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean verifyUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User loginUser(User user) {
        System.out.println("PW:"+user.getPassword());
        return getSingleData("select * from users where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'"); 
    }

    @Override
    public boolean uploadUserPhoto(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getSingleData(String query) {
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
             while (rs.next())
            return fillData();
           } catch (SQLException e) {
        }
        return userData;

    }
     

    @Override
    public List<User> getListData(String query) {
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                userList.add(fillData());
           }
            con.close();
        } catch (SQLException e) {
        }
        return userList;
    }
    
    @Override
    public User findByNID(final String id) {
        return getSingleData("select * from users where national_id='"+id+"'"); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public User findById(final String id) {
        return getSingleData("select * from users where user_id='"+id+"'"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
     return getListData("select * from users order by names");   
    }

    @Override
    public User fillData() {
       try {
                userData = new User();
                userData.setUserId(UUID.fromString(rs.getString(1)));
                userData.setUserFullName(rs.getString(2));
                userData.setGender(EGender.valueOf(rs.getString(3)));
                userData.setUserDateOfBirth(rs.getDate(4));
                userData.setMaritalStatus(EMaritalStatus.valueOf(rs.getString(5)));
                Country country = new Country();
                country.setCountryName(rs.getString(6));
                userData.setNationality(country);
                userData.setNationalId(rs.getString(7));
                userData.setAccountStatus(EAccountStatus.valueOf(rs.getString(8)));
                userData.setPhotoId(rs.getString(9));
                userData.setUsername(rs.getString(10));
                userData.setPassword(rs.getString(11));
                userData.setRole(ERole.valueOf(rs.getString(12)));
               
            } catch (SQLException e) {
        }
        return userData;
    }

    @Override
    public User checkUserIfExist(String nationalId) {
        userData=null; 
        userData=getSingleData("select * from users where id='"+nationalId+"'"); //To change body of generated methods, choose Tools | Templates.
        return userData;
    }

    @Override
    public User updateUser(User user) {
       try {
            Connection con = DataSource.getConnection();
            pst = con.prepareStatement("update users set names=?,gender=?,date_of_birth=?,marital_status=?,nationality=?,national_id=?,account_status=?,photo_id=?,username=?,password=? where user_id=?");
            pst.setString(11, user.getUserId().toString());
            pst.setString(1, user.getUserFullName());
            pst.setString(2, user.getGender().name());
            pst.setDate(3, new java.sql.Date(user.getUserDateOfBirth().getTime()));
            pst.setString(4, user.getMaritalStatus().name());
            pst.setString(5, user.getNationality().getCountryName());
            pst.setString(6, user.getNationalId());
            pst.setString(7, user.getAccountStatus().name());
            pst.setString(8, user.getPhotoId());
            pst.setString(9, user.getUsername());
            pst.setString(10, user.getPassword());
            pst.execute();
            con.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
           return null;
        }    
    }
 

}
