/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.service;

import com.z.dao.UserDao;
import com.z.domain.Country;
import com.z.domain.EAccountStatus;
import com.z.domain.IConstant;
import com.z.domain.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UserService implements IUserService {

    private final UserDao dao = new UserDao();
    private CachingProvider cachingProvider;
    private CacheManager cacheManager;
    private Cache<String, List<User>> cache;
    private List<User> list = new ArrayList<>();
    private User user;

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findByNID(final String id) {
        return dao.findByNID(id);
    }

    @Override
    public User findById(final String id) {
        return dao.findById(id);
    }

    @Override
    public List<User> loadDataInSpace() {

        if (Caching.getCachingProvider() != null) {

            CachingProvider cachingProvider1 = Caching.getCachingProvider();
            if (cachingProvider1.getCacheManager() != null) {

                CacheManager cacheManager1 = cachingProvider1.getCacheManager();
                MutableConfiguration<String, List<User>> config = new MutableConfiguration();
                //config.setTypes(String.class, User.class);
                Cache<String, List<User>> cache1 = cacheManager1.getCache(IConstant.USERCACHE);
                if (cache1 == null) {
                    //loading data in the cache for the first time
                    list = dao.findAll();
                    cache1 = cacheManager1.createCache(IConstant.USERCACHE, config);
                    cache1.put(IConstant.USERS, list);
                    cache1.putIfAbsent("usersList", list);

                    System.out.println("The value is " + cache1.get("usersList") + "\n");

//cache1.invoke("usersList", new EntryProcessor());
                    System.out.println("The value is now " + list.get(0) + "\n");

                    System.out.println(">>>>>>>>><<<<<<<");
                    System.out.println("*********************************");
                    System.out.println("*                               *");
                    System.out.println("* First Data " + list.size() + " Loaded In Memory   *");
                    System.out.println("*                               *");
                    System.out.println("*********************************");

                } else {
                    System.out.println("************ndahageze bwa 2 kandi nitwa " + cache1.getName() + "*********************");

                    System.out.println("***************" + cacheManager1.getCacheNames()
                            + "******************");

//get data from cache
                    //list =cache1.get("usersList");
                    //getExistingDataFromSpace();
                    list = dao.findAll();
                    System.out.println("*********************************");
                    System.out.println("*                               *");
                    System.out.println("* Second Data " + list + " Loaded In Memory  *");
                    System.out.println("*                               *");
                    System.out.println("*********************************");
                }
            }
        }
        return list;
    }

    @Override
    public List<User> getExistingDataFromSpace() {
        if (Caching.getCachingProvider() != null) {
            cachingProvider = Caching.getCachingProvider();
            //System.out.println("Caching Provider:"+cachingProvider);
            if (cachingProvider.getCacheManager() != null) {
                cacheManager = cachingProvider.getCacheManager();
                Cache<String, List<User>> userCache = cacheManager.getCache("UserCache");
                System.out.println(userCache.containsKey("usersList"));
                //cacheManager.
                //list = userCache.get("usersList");
            }

        }
        return list;
    }

    //@Override
    public List<User> loadDataInSpace1() {

        if (Caching.getCachingProvider() != null) {
            cachingProvider = Caching.getCachingProvider();
            if (cachingProvider.getCacheManager() != null) {

                cacheManager = cachingProvider.getCacheManager();
                MutableConfiguration<String, List<User>> config = new MutableConfiguration();
                cache = cacheManager.getCache(IConstant.USERCACHE);
                if (cache == null) {
                    //loading data in the cache for the first time
                    list = dao.findAll();
                    cache = cacheManager.createCache(IConstant.USERCACHE, config);
                    cache.put(IConstant.USERS, list);
                    cache.putIfAbsent("usersList", list);
                    System.out.println(">>>>>>>>><<<<<<<" + cache.containsKey("usersList"));
                    System.out.println("*********************************");
                    System.out.println("*                               *");
                    System.out.println("* First Data " + list.size() + " Loaded In Memory   *");
                    System.out.println("*                               *");
                    System.out.println("*********************************");

                } else {
                    //get data from cache
                    list = getExistingDataFromSpace();
                    System.out.println("*********************************");
                    System.out.println("*                               *");
                    System.out.println("* Second Data " + list.size() + " Loaded In Memory  *");
                    System.out.println("*                               *");
                    System.out.println("*********************************");
                }
            }
        }
        return list;
    }

    //@Override
    public List<User> getExistingDataFromSpace1() {
        if (Caching.getCachingProvider() != null) {
            cachingProvider = Caching.getCachingProvider();
            //System.out.println("Caching Provider:"+cachingProvider);
            if (cachingProvider.getCacheManager() != null) {
                cacheManager = cachingProvider.getCacheManager();
                Cache<String, List<User>> userCache = cacheManager.getCache("UserCache");
                System.out.println(userCache.containsKey("usersList"));
                //cacheManager.
                //list = userCache.get("usersList");
            }

        }
        return list;
    }

    @Override
    public boolean registerNewUser(User user) {
        if (checkUserIfExist(user)) {
            return false;
        } else {
            return dao.registerNewUser(user);
        }
    }

    @Override
    public boolean verifyUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        User u = new User();
        UserDao dd = new UserDao();
        u.setUsername("heritierakili@gmail.com");
        u.setPassword("1g3ce53fg1b2eb8c77267ee2f57aj5");
        System.out.println(dd.loginUser(u));
    }

    @Override
    public User loginUser(User user) {

        return dao.loginUser(user);

    }

    @Override
    public boolean uploadUserPhoto(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkUserIfExist(User user) {
        boolean flag = false;
        for (User currentUser : loadDataInSpace()) {
            if (user.getNationalId().equals(currentUser.getNationalId())) {
                flag = true;
            }
        }
        return flag;
    }

    public String md5(final String input) {
        String md5 = null;
        if (null == input) {
            return null;
        }
        try {
            final MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes(), 0, input.length());
            md5 = new BigInteger(1, digest.digest()).toString(20);
        } catch (NoSuchAlgorithmException e) {
        }
        return md5;
    }

    @Override
    public User updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public long countUsersByStatus(EAccountStatus accountStatus, List<User> userList) {
        int countResult = 0;
        countResult = userList.stream().filter((u) -> (u.getAccountStatus().equals(accountStatus))).map((_item) -> 1).reduce(countResult, (accumulator, _item) -> accumulator + 1);
        return countResult;
    }
}
