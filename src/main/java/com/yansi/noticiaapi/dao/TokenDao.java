/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yansi.noticiaapi.dao;

import com.yansi.noticiaapi.modelo.ModToken;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author programador
 */
public class TokenDao {
    public void adiciona(ModToken modToken) throws SQLException {
        Conexao conn = new Conexao();
        PreparedStatement ps;
        
        String sql = "insert into tb_token(token, site) "
                + "values (?, ?)";
        ps =  conn.getConexao().prepareStatement(sql);
        
        ps.setString(1, modToken.getToken());
        ps.setString(2, modToken.getSite());
        
        ps.execute();
    }

    public ModToken autorizacao(ModToken modToken) throws SQLException {
        boolean status = false;
        ModToken modTok = new ModToken();
        
        Conexao conn = new Conexao();
        
        String sql = "SELECT * FROM tb_token "
                + "WHERE token = ? ;";
        
        PreparedStatement ps;
        
        ps = conn.getConexao().prepareStatement(sql);
        ps.setString(1, modToken.getToken());
        
        ResultSet rs;
        
        rs = ps.executeQuery();
        
        if(rs.next()) {
            modTok.setIdTok(rs.getInt("id_token"));
            modTok.setSite(rs.getString("site"));
            modTok.setToken(rs.getString("token"));
        } else {
            modTok.setIdTok(0);
            modTok.setSite("null");
            modTok.setToken("null");
        }
        
        return modTok;
    }

    public boolean deleteToken(ModToken modToken) throws SQLException {
        
        Conexao conn = new Conexao();
        
        String sql = "DELETE FROM tb_token "
                + "WHERE token = ? ;";
        
        PreparedStatement ps;
        
        ps = conn.getConexao().prepareStatement(sql);
        ps.setString(1, modToken.getToken());
        
        ps.executeUpdate();
        
        return true;
    }
}
