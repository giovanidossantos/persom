/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import model.Conexao;
import model.Telefone;
import java.sql.*;


/**
 *
 * @author Aluno
 */
public class TelefoneDAO {
    
    Conexao cone = new Conexao();
    Connection con = null;
    
    public void insert(Telefone t) throws SQLException{
        
        con = cone.carrega();
        String sql = "insert into Telefone(Telefone_Residencial,Telefone_Comercial,Celular,Operadora,Cliente_CPF_CNPJ) values (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1,t.getTelefoneResidencial());
        ps.setString(2,t.getTelefoneComercial());
        ps.setString(3,t.getCelular());
        ps.setString(4,t.getOperadora());
        ps.setString(5,t.getCliente().getCpfCnpj());
        
        ps.execute();
        
        ps.close();
        con.close();
    }
    
    public Telefone select(Telefone t) throws SQLException{
        
        con = cone.carrega();
        String sql = "select * from Telefone where Cliente_CPF_CNPJ='" + t.getCliente().getCpfCnpj() + "'";
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            t.setTelefoneResidencial(rs.getString("Telefone_Residencial"));
            t.setTelefoneComercial(rs.getString("Telefone_Comercial"));
            t.setCelular(rs.getString("Celular"));
            t.setOperadora(rs.getString("Operadora"));
        }else{
        }
        con.close();
        st.close();
        rs.close();
        
        return t;
    }
    
    public void update(Telefone t) throws SQLException{
        
        con = cone.carrega();
        Statement st = con.createStatement();
        
    int registro = st.executeUpdate("Update Telefone set Telefone_Residencial='" + t.getTelefoneResidencial() + "',Telefone_Comercial='" + t.getTelefoneComercial() + 
                "',Celular='" + t.getCelular() + "',Operadora='" + t.getOperadora() + "'where Cliente_CPF_CNPJ='" + t.getCliente().getCpfCnpj() + "'");
        
        if(registro != 0){
        }else{
        }
        
        st.close();
        con.close();
    }
    
}
