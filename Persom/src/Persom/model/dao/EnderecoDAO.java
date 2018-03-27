/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import model.Conexao;
import model.Endereco;
import java.sql.*;


/**
 *
 * @author Aluno
 */
public class EnderecoDAO {
    
    Conexao cone = new Conexao();
    Connection con = null;
    
    public void insert(Endereco e) throws SQLException{
        
        con = cone.carrega();
        String sql = "insert into Endereco(Nome_Endereco,Bairro,CEP,Cidade,Estado,Cliente_CPF_CNPJ) values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1,e.getNomeendereco());
        ps.setString(2,e.getBairro());
        ps.setString(3,e.getCep());
        ps.setString(4,e.getCidade());
        ps.setString(5,e.getEstado());
        ps.setString(6,e.getCliente().getCpfCnpj());
       
        
        ps.execute();
        
        ps.close();
        con.close();
        
       }
    
    public Endereco select(Endereco e) throws SQLException{
        
        con = cone.carrega();
        String sql = "Select * from Endereco where Cliente_CPF_CNPJ='" + e.getCliente().getCpfCnpj() + "'";
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            e.setNomeendereco(rs.getString("Nome_endereco"));
            e.setBairro(rs.getString("Bairro"));
            e.setCep(rs.getString("CEP"));
            e.setCidade(rs.getString("Cidade"));
            e.setEstado(rs.getString("Estado"));
            
            
        }else{
    }
        con.close();
        st.close();
        rs.close();
        
        return e;
    }
    
    public void update(Endereco e) throws SQLException{
        
        con = cone.carrega();
        Statement st = con.createStatement();
        
        int registro = st.executeUpdate("Update Endereco set Nome_endereco='" + e.getNomeendereco() + "',Bairro='" + e.getBairro() + "',CEP='" + e.getCep() +
             "',Cidade='" + e.getCidade() + "',Estado='" + e.getEstado() + "'where Cliente_CPF_CNPJ='" + e.getCliente().getCpfCnpj() + "'");
        
        if(registro != 0){
        }else{
         }
        st.close();
        con.close();
    }
    }
    
