/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yansi.noticiaapi.controller;

import com.yansi.noticiaapi.dao.NoticiasDao;
import com.yansi.noticiaapi.modelo.ModNoticia;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author programador
 */
public class NoticiaCtl {

    String cadNoticia(ModNoticia noticia) {
        String status = "S";
        NoticiasDao daoNotic = new NoticiasDao();

        try {

            daoNotic.adiciona(noticia);
            status = "A";

        } catch (SQLException ex) {
            System.out.println(ex);
            status = "S";
        }

        return status;
    }

    ArrayList<ModNoticia> exibicaoTotal() {
        ArrayList<ModNoticia> modNotci = new ArrayList<ModNoticia>();
        NoticiasDao noticDao = new NoticiasDao();

        try {
            modNotci = noticDao.lista();
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar a lista de usuario");
        }

        return modNotci;
    }

    String editarNoticia(ModNoticia noticia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
