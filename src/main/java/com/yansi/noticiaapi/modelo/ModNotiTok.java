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
public class ModNotiTok {
    ModNoticia cad;
    ModToken   token;

    public ModNoticia getCad() {
        return cad;
    }

    public void setCad(ModNoticia cad) {
        this.cad = cad;
    }

    public ModToken getToken() {
        return token;
    }

    public void setToken(ModToken token) {
        this.token = token;
    }

    
    
    
}
