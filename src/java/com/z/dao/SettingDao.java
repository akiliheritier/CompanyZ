/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.dao;

 
import com.z.domain.Setting;
import datasource.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

/**
 *
 * @author DELL
 */
public class SettingDao implements ISettingDao{

    private Setting settingData = null;
    private final List<Setting> settingList = new ArrayList<>();
    private final Connection con = DataSource.getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public Setting fillData() {
        try {
                settingData = new Setting();
                settingData.setSettingId((rs.getInt(1)));
                settingData.setPath(rs.getString(2));
                settingData.setDomain(rs.getString(3));
                settingData.setADServerIP(rs.getString(4));
                settingData.setADUser(rs.getString(5));
                settingData.setADPassword(rs.getString(6));
                settingData.setDefaultOU(rs.getString(7));
                settingData.setAdditionalOU(rs.getString(8));
                settingData.setMailSenderID(rs.getString(9));
                settingData.setMailSenderName(rs.getString(10));
                settingData.setBulkSmsUrl(rs.getString(11));
                settingData.setBase_url(rs.getString(12));
                settingData.setApp_title(rs.getString(13));
                settingData.setApp_footer(rs.getString(14));
                settingData.setMax_sms_trial(rs.getInt(15));
                settingData.setMax_users((rs.getInt(16)));
                settingData.setMax_email((rs.getInt(17)));
                settingData.setMail_host(rs.getString(18));
                settingData.setApp_moto(rs.getString(19));
               
            } catch (SQLException e) {
        }
        return settingData;
    }

    @Override
    public Setting getSingleData(String query) {
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            return fillData();
           } catch (SQLException e) {
        }
        return settingData;

    } 

    @Override
    public List<Setting> getListData(String query) {
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                settingList.add(fillData());
           }
            con.close();
         } catch (SQLException e) {
        }
        return settingList;
    }

    @Override
    public Setting findById(final String id) {
        return getSingleData("select * from settings where setting_id="+id+"");
    }

    @Override
    public List<Setting> findAll() {
     return getListData("select * from settings");   
    }
 
    
}
