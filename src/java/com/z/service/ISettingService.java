/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.service;

import com.z.domain.Setting;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ISettingService extends IService<Setting>{
    @Override
     public List<Setting> findAll();
    
     @Override
     public Setting findById(final String id);
     
}
