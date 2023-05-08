/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.service;

import com.z.dao.CountryDao;
import com.z.dao.NidaDataDao;
import com.z.domain.Country;
import com.z.domain.NidaData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class NidaDataService implements INidaDataService {

    private final NidaDataDao dao = new NidaDataDao();

    public static void main(String[] args) {
        NidaDataService a=new NidaDataService();
        System.out.println(a.findById("1234567890123456"));
    }
    @Override
    public List<NidaData> findAll() {
       return dao.findAll();
    }

    @Override
    public NidaData findById(String id) {
      return dao.findById(id);
    }

    @Override
    public List<NidaData> loadDataInSpace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NidaData> getExistingDataFromSpace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
