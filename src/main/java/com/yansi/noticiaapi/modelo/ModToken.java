/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yansi.noticiaapi.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programador
 */
@XmlRootElement
public class ModToken {
    
    private int idTok;
    private String token;
    private String tokenSite;
    private String site;

    public int getIdTok() {
        return idTok;
    }

    public void setIdTok(int idTok) {
        this.idTok = idTok;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTokenSite() {
        return tokenSite;
    }

    public void setTokenSite(String tokenSite) {
        this.tokenSite = tokenSite;
    }
    
    
}
