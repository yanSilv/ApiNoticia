/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yansi.noticiaapi.dao;

import com.yansi.noticiaapi.modelo.ModNoticia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author programador
 */
public class NoticiasDao {
    
    public void adiciona(ModNoticia modNoticia) throws SQLException {
        Conexao conn = new Conexao();
        PreparedStatement ps;

        String sql = "insert into tab_noticias(data, cargo, titulo, conteudo) "
                + "values (?,?,?,?)";
        ps = conn.getConexao().prepareStatement(sql);

        ps.setString(1, modNoticia.getData());
        ps.setString(2, modNoticia.getCargo());
        ps.setString(3, modNoticia.getTitulo());
        ps.setString(4, modNoticia.getConteudo());

        ps.execute();
    }

    public ArrayList<ModNoticia> lista() throws SQLException {
        ArrayList<ModNoticia> lista = new ArrayList<ModNoticia>();

        Conexao conn = new Conexao();

        String sql = "select * from tab_noticias;";

        PreparedStatement ps;

        ps = conn.getConexao().prepareStatement(sql);

        ResultSet rs;

        rs = ps.executeQuery();

        while (rs.next()) {

            ModNoticia noticia = new ModNoticia();

            noticia.setId(rs.getInt("id"));
            noticia.setData(rs.getString("data"));
            noticia.setCargo(rs.getString("cargo"));
            noticia.setTitulo(rs.getString("titulo"));
            noticia.setConteudo(rs.getString("conteudo"));

            lista.add(noticia);

        }

        return lista;
    }
    

    public void editar(ModNoticia modNoticia) throws SQLException {
        Conexao conn = new Conexao();
        PreparedStatement ps;

            String sql = "UPDATE tab_noticias "
                    + "SET data = ?, cargo = ?, titulo = ?, conteudo = ? "
                    + "WHERE id = ?";
            ps = conn.getConexao().prepareStatement(sql);

            ps.setString(1, modNoticia.getData());
            ps.setString(2, modNoticia.getCargo());
            ps.setString(3, modNoticia.getTitulo());
            ps.setString(4, modNoticia.getConteudo());
            ps.setInt(5, modNoticia.getId());
       

        ps.executeUpdate();
    }
    
}
