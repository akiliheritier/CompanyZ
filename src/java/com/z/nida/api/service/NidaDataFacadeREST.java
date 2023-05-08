/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.nida.api.service;

import com.z.domain.NidaData;
import com.z.service.NidaDataService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET; 
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author akili.heritier
 */
@Path("nida.gov.api")
public class NidaDataFacadeREST extends AbstractFacade<NidaData> {

    @PersistenceContext(unitName = "company_zPU")
    private EntityManager em;
    private final NidaDataService nidaDataService = new NidaDataService();
    private NidaData data = null;
    private Response res;

    public NidaDataFacadeREST() {
        super(NidaData.class);
    }

    
    @POST
    @Path("findNidaData/{nid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findNidaDataByID(@PathParam("nid") String nid) {
        res= new Response();
        data = nidaDataService.findById(nid);
        if (data!=null) {
            res.setCode("00");
            res.setStatus("success");
            res.setData(data);
            
        } else {
            res.setCode("09");
            res.setStatus("fail");
          }
        return res;
    }
  
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<NidaData> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
