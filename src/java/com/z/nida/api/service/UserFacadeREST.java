/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.nida.api.service;

import com.z.domain.User;
import com.z.service.UserService;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author akili.heritier
 */
@Path("com.z.api")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "company_zPU")
    
    private EntityManager em;
    private final UserService userService = new UserService();
    private UserData data;
    private User user = null;
    private UserResponse res;

    public UserFacadeREST() {
        super(User.class);
    }
    
    @GET
    @Path("findUserVerification/")
    @Produces({MediaType.APPLICATION_JSON})
    public UserResponse findUserDataByID(@QueryParam("nid") String nid) {

        res = new UserResponse();
 
            user = userService.findByNID(nid);
            if (user != null) {
                res.setCode("200");
                res.setStatus("Ok");
                data = new UserData();
                data.setAccountStatus(user.getAccountStatus().getDescription());
                data.setDateOfBirth(user.getUserDateOfBirth());
                data.setGender(user.getGender().getDescription());
                data.setMaritalStatus(user.getMaritalStatus().getDescription());
                data.setNames(user.getUserFullName());
                data.setNationalId(user.getNationalId());
                data.setNationality(user.getNationality().getCountryName());
                data.setUsername(user.getUsername());
                Calendar cal = new GregorianCalendar();
                Calendar cal2 = new GregorianCalendar();
                cal2.setTime(user.getUserDateOfBirth());
                data.setAge(cal.get(Calendar.YEAR) - cal2.get(Calendar.YEAR));
                res.setData(data);
            } else {
                res.setCode("09");
                res.setStatus("fail");
            }
        
        return res;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") UUID id, User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") UUID id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") UUID id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
