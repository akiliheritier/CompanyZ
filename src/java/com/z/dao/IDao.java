/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.dao;
 
import java.util.List;

/**
 *
 * @author DELL
 * @param <T>
 */
public interface IDao<T> {
    public List<T> findAll();
    public T findById(final String id);
    
    public T getSingleData(final String query);
    public List<T> getListData(final String query);
    public T fillData();
}
