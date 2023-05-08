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
 * @author DELL
 */
public class CountryDao implements ICountryDao{

    private Country countryData = null;
    private final List<Country> countryList = new ArrayList<>();
    private final Connection con = DataSource.getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    @Override
    public List<Country> findAll() {
        return getListData("select * from apps_countries order by country_name");
    }

    @Override
    public Country findById(String id) {
        return getSingleData("select * from apps_countries where id="+id+"");
    }

    
    @Override
    public Country getSingleData(String query) {
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            return fillData();
           } catch (SQLException e) {
        }
        return countryData;
    }
     

    @Override
    public List<Country> getListData(String query) {
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                countryList.add(fillData());
           }
            con.close();
        } catch (SQLException e) {
        }
        return countryList;
    }

    @Override
    public Country fillData() {
       try {
                countryData = new Country();
                countryData.setId((rs.getInt(1)));
                countryData.setCountryCode(rs.getString(2));
                countryData.setCountryName((rs.getString(3)));
           } catch (SQLException e) {
        }
        return countryData;
    
    }
    
}
