/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.nida.api.service;

import com.z.domain.NidaData;

/**
 *
 * @author akili.heritier
 */
public class Response {
    private String code,status;
    
    private NidaData data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NidaData getData() {
        return data;
    }

    public void setData(NidaData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + "code:" + code + ",status:" + status + ",data:" + data + '}';
    }

     
    
    
    
}
