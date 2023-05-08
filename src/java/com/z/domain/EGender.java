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
public enum EGender {
    MALE("Male"),
    FEMALE("Female");
    
    /*description*/
    private String description;

    private EGender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
