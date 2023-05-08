/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.service;

import com.z.dao.SettingDao;
import com.z.domain.IConstant;
import com.z.domain.Setting;
import java.util.ArrayList;
import java.util.List;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 *
 * @author akili.heritier
 */
public class SettingService implements ISettingService {

    private final SettingDao dao = new SettingDao();
    private CachingProvider cachingProvider;
    private CacheManager cacheManager;
    Cache<String, List<Setting>> cache;
    private List<Setting> list = new ArrayList<>();
    Setting metData=new Setting();
    
    @Override
    public List<Setting> findAll() {
        return dao.findAll();
    }

    @Override
    public Setting findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Setting> loadDataInSpace() {

        if (Caching.getCachingProvider() != null) {
            cachingProvider = Caching.getCachingProvider();
            if (cachingProvider.getCacheManager() != null) {
                cacheManager = cachingProvider.getCacheManager();
                MutableConfiguration<String, List<Setting>> config = new MutableConfiguration();
                cache = cacheManager.getCache(IConstant.SETTINGCACHE);
                if (cache == null) {
                    list = dao.findAll();
                    cache = cacheManager.createCache(IConstant.SETTINGCACHE, config);
                    cache.put(IConstant.SETTINGS, list);
                } else {
                    list = getExistingDataFromSpace();
                }
            }
        }
        return list;
    }

    @Override
    public List<Setting> getExistingDataFromSpace() {
        if (Caching.getCachingProvider() != null) {
            cachingProvider = Caching.getCachingProvider();
            if (cachingProvider.getCacheManager() != null) {
                cacheManager = cachingProvider.getCacheManager();
                cache = cacheManager.getCache(IConstant.SETTINGCACHE);
                list = cache.get(IConstant.SETTINGS);
            }

        }
        return list;
    }
     
    public  Setting getMetaDataInSpace() {
        metData=  getExistingDataFromSpace().stream().findFirst().orElse(null);
        return metData;
    }

}
