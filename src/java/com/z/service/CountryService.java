/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.service;

import com.z.dao.CountryDao;
import com.z.domain.Country;
import java.util.ArrayList;
import java.util.List;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 *
 * @author DELL
 */
public class CountryService implements ICountrySevice {

    private final CountryDao dao = new CountryDao();
    private CachingProvider cachingProvider = null;
    private CacheManager cacheManager = null;
    private List<Country>list=new ArrayList<>();
    @Override
    public List<Country> findAll() {
        return dao.findAll();
    }

    @Override
    public Country findById(String id) {
        return dao.findById(id);
    }

    
    @Override
    public List<Country> loadDataInSpace() {
         
        if (Caching.getCachingProvider() != null) {
            cachingProvider = Caching.getCachingProvider();
            //System.out.println("Caching Provider:"+cachingProvider);
            if (cachingProvider.getCacheManager() != null) {

                cacheManager = cachingProvider.getCacheManager();
                MutableConfiguration<String, List<Country>> config = new MutableConfiguration();
                Cache<String, List<Country>> cache = cacheManager.getCache("CountryCache");
                if(cache==null){
                 list= dao.findAll();
                 cache=cacheManager.createCache("CountryCache", config);
                 cache.put("countries",list);
                 }else{
                  list= getExistingDataFromSpace();
                 }
             }
        }
        return list;
    }

    @Override
    public List<Country> getExistingDataFromSpace() {
        if (Caching.getCachingProvider() != null) {
            cachingProvider = Caching.getCachingProvider();
            //System.out.println("Caching Provider:"+cachingProvider);
            if (cachingProvider.getCacheManager() != null) {
                cacheManager = cachingProvider.getCacheManager();
                Cache<String, List<Country>> cache = cacheManager.getCache("CountryCache");
                list = cache.get("countries");
              }
            
        } 
        return list;
    } 
}
