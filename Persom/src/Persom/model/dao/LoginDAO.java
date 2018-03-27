/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import model.Conexao;
import model.Login;
import java.sql.*;
import javax.swing.JOptionPane;



public class LoginDAO {
    
    Conexao cone = new Conexao();
    Connection con = null;
    
    public void insert(Login l) throws SQLException{
        
        con = cone.carrega();
        String sql = "insert into login(Login,Senha) values (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, l.getLogin());
        ps.setString(2, l.getSenha());
        
        ps.execute();
        JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso.","Usuário",JOptionPane.INFORMATION_MESSAGE);
        
        ps.close();
        con.close();
    }
    
    public Login select(Login l) throws SQLException{
      
        con = cone.carrega();
        String sql = "select Login, Senha from Login where Login ='" + l.getLogin() + "'";
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
          l.setLogin(rs.getString("Login"));
          l.setSenha(rs.getString("Senha"));   
        }
        
        con.close();
        st.close();
        rs.close();
        
      return l;  
    }
    
    public void update(Login l) throws SQLException{
        
        con = cone.carrega();
        Statement st = con.createStatement();
        
        int registro = st.executeUpdate("Update Login set Senha ='" + l.getSenha() + "' where Login ='" + l.getLogin() + "'");
        
        if(registro != 0){
            JOptionPane.showMessageDialog(null,"Senha alterada com sucesso.","Usuário",1);
        }else{
            JOptionPane.showMessageDialog(null,"Senha não foi alterada.","Usuário",JOptionPane.ERROR_MESSAGE);
        }
        st.close();
        con.close();
    }
     
}
