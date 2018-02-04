/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yansi.noticiaapi.controller;


import com.yansi.noticiaapi.modelo.ModNotiTok;
import com.yansi.noticiaapi.modelo.ModNoticia;
import com.yansi.noticiaapi.modelo.ModToken;
import com.yansi.noticiaapi.util.JwtUtil;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author programador
 */
@Path("noticias")
public class AcessoRota {
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/cadastro")
    public String setCadNoticia(ModNotiTok modGeral) {
        String status = "";
        AutorizadorCtl autCtl = new AutorizadorCtl();
        NoticiaCtl notCtl = new NoticiaCtl();
        
        if (autCtl.validaToken(modGeral.getToken())) {
            status = notCtl.cadNoticia(modGeral.getCad());
        } else {
            status = "invalido";
        }
        
        return status;
    }
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/cadastroToken")
    public String setCadToken(ModToken tokenAu) {
        String status = "";
        AutorizadorCtl autCtl = new AutorizadorCtl();
        NoticiaCtl notCtl = new NoticiaCtl();
        
        if (autCtl.validaToken(tokenAu.getTokenSite())) {
            status = autCtl.cadToken(tokenAu);
        } else {
            status = "Token invalido";
        }
        
        return status;
    }
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/gerarToken")
    public String getGeraToken(ModToken modToken) {
        String status = "";
        AutorizadorCtl autCtl = new AutorizadorCtl();
        NoticiaCtl notCtl = new NoticiaCtl();
        
        String token = JwtUtil.create(modToken.getSite());
        
        return token;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/exibicao/{token}")
    public ArrayList<ModNoticia> getExibicaoNoticia(@PathParam("token") String token) {
        AutorizadorCtl autCtl = new AutorizadorCtl();
        NoticiaCtl notCtl = new NoticiaCtl();
        
        if (autCtl.validaToken(token)) {
            return notCtl.exibicaoTotal();
        } else {
            ModNoticia modNot = new ModNoticia();
            ArrayList<ModNoticia> arrayNot = new ArrayList<ModNoticia>();
            return arrayNot;
        }   
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consulta/{token}")
    public ArrayList<ModNoticia> getConsultaNoticia(@PathParam("token") String token) {
        AutorizadorCtl autCtl = new AutorizadorCtl();
        NoticiaCtl notCtl = new NoticiaCtl();
        
        if (autCtl.validaToken(token)) {
            return notCtl.exibicaoTotal();
        } else {
            ModNoticia modNot = new ModNoticia();
            ArrayList<ModNoticia> arrayNot = new ArrayList<ModNoticia>();
            return arrayNot;
        }   
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/edidaNoticia")
    public String getEditarNoticia(ModNotiTok modNotToken) {
        AutorizadorCtl autCtl = new AutorizadorCtl();
        NoticiaCtl notCtl = new NoticiaCtl();
        String status;
        
        if (autCtl.validaToken(modNotToken.getToken())) {
            
            status = notCtl.editarNoticia(modNotToken.getCad());
        
        } else {
            status = "Token invalido";
        }
                
        return status;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{token}")
    public void getDeleteToken(@PathParam("token") String token) {
        boolean status = false;
        
        AutorizadorCtl autCtl = new AutorizadorCtl();
        
        status = autCtl.deleteToken(token);
        
    }

}
