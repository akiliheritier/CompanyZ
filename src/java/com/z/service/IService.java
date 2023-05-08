/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.service;
 
import java.util.List; 

/**
 *
 * @author DELL
 * @param <T>
 */
public interface IService<T> {
    public List<T> findAll();
    public T findById(final String id); 
    
    public List<T> loadDataInSpace();
     public List<T> getExistingDataFromSpace();
}
