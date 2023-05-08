/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.service;

import com.z.domain.EAccountStatus;
import com.z.domain.User;
import java.util.List;

/**
 *
 * @author akili.heritier
 */
public interface IUserService extends IService<User>{
    public  boolean registerNewUser(User user);
    public boolean  checkUserIfExist(User user);
    public boolean verifyUser(User user);
    public User loginUser(User user);
     public User updateUser(User user);
    public boolean uploadUserPhoto(User user);
    public long countUsersByStatus(EAccountStatus accountStatus,final List<User> list);
    public User findByNID(final String nid);
    
    
    @Override
     public List<User> findAll();
    @Override
     public User findById(final String id);
     
}
