/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.domain;

/**
 *
 * @author akili.heritier
 */
public enum EMaritalStatus {
    
    /*SINGLE*/
    SINGLE("Single"),
    
    /*MARRIED*/
    MARRIED("Married"),
    
    /*DIVORCED*/
    DIVORCED("Divorced"),
    
    /*WIDOWED*/
    WIDOWED("Widowed");
    
    /*description*/
    private String description;

    private EMaritalStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
