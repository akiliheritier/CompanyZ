/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.dao;

import com.z.domain.User;

/**
 *
 * @author akili.heritier
 */
public interface IUserDao extends IDao{
    public boolean registerNewUser(User user);
    public boolean verifyUser(User user);
    public User loginUser(User user);
    public User updateUser(User user);
    public boolean uploadUserPhoto(User user);
    public User checkUserIfExist(final String nationalId);
    public User findByNID(final String nid);
 }
