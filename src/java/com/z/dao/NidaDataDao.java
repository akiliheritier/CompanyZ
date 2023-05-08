/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.dao;

import com.z.domain.NidaData;
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
public class NidaDataDao implements INidaDataDao {

    private NidaData nidaData;
    private final List<NidaData> nidaList = new ArrayList<>();
    private final Connection con = DataSource.getConnection();
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public List<NidaData> findAll() {
        return getListData("select * from nida_data");
    }

    @Override
    public NidaData findById(String id) {
        return getSingleData("select * from nida_data where id='" + id + "'");
    }

    
    
    @Override
    public NidaData getSingleData(String query) {
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                nidaData= fillData();
            }
        } catch (SQLException e) {
        }
        return nidaData;
    }

    @Override
    public List<NidaData> getListData(String query) {
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                nidaList.add(fillData());
            }
            con.close();
        } catch (SQLException e) {
        }
        return nidaList;
    }

    @Override
    public NidaData fillData() {
        try {
            nidaData = new NidaData();
            nidaData.setId((rs.getString(1)));
            nidaData.setFirstname(rs.getString(2));
            nidaData.setLastName(rs.getString(3));
            nidaData.setDateOfBirth(rs.getDate(4));
            nidaData.setGender(rs.getString(5));
            nidaData.setMaritalStatus(rs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nidaData;
    }

}
