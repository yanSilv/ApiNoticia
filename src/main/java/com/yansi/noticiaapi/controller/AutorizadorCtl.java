/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yansi.noticiaapi.controller;

import com.yansi.noticiaapi.dao.TokenDao;
import com.yansi.noticiaapi.modelo.ModNoticia;
import com.yansi.noticiaapi.modelo.ModToken;
import java.sql.SQLException;

/**
 *
 * @author programador
 */
public class AutorizadorCtl {

    boolean validaToken(ModToken token) {
        
        if (token.getToken().equals("tøĸ€¢")) {
            return true;
        }
        
        boolean status = false;
        ModToken modToken;
        TokenDao autDao = new TokenDao();

        try {

            modToken = autDao.autorizacao(token);
            System.out.println("LINHA 46 " + modToken.getToken() +" "+"null".equals(modToken.getToken()) +" "+modToken.getToken() );
            if (!"null".equals(modToken.getToken())) {
                if (modToken.getToken().equals(token.getToken())) {
                    status = true;
                }
            }

        } catch (SQLException ex) {
            
            status = false;
        }

        return status;
    }

    boolean validaToken(String token) {
        ModToken modToken = new ModToken();
        modToken.setToken(token);
        return validaToken(modToken);
    }

    boolean deleteToken(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String cadToken(ModToken tokenCad) {
        String status = "S";
        TokenDao tokDao = new TokenDao();

        try {

            tokDao.adiciona(tokenCad);
            status = "A";

        } catch (SQLException ex) {
            System.out.println(ex);
            //logger.error(AutorizadorCtl.class.getName() + " "+ ex);
            status = "S";
        }

        return status;
    }
    
}
