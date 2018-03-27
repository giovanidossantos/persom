/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;


import model.Conexao;
import model.Fornecedor;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno noite
 */
public class FornecedorDAO {
    
    Conexao cone = new Conexao();
    Connection con = null;
   
    public void insert(Fornecedor f) throws SQLException{
            
            con = cone.carrega();
            String sql = "insert into fornecedor(Nome,Telefone,Email,Contato) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1,f.getNome());
            ps.setString(2,f.getTelefone());
            ps.setString(3,f.getEmail());            
            ps.setString(4,f.getContato());
            
            ps.execute();
            
             JOptionPane.showMessageDialog(null,"Fornecedor cadastrado com sucesso.","Cadastro Fornecedor",1);
                               
            ps.close();
            con.close();
   
     }
     
     public void update(Fornecedor f) throws SQLException{
       
         con = cone.carrega();
         Statement st = con.createStatement();
         
         int registro = st.executeUpdate("Update Fornecedor set Nome='" + f.getNome() + "',Telefone='" + f.getTelefone() + "',Email='" + f.getEmail() + "',Contato='" + f.getContato() +
                  "'where IdFornecedor=" + f.getIdFornecedor());
         
         if(registro != 0){
            JOptionPane.showMessageDialog(null,"Dados Alterados com sucesso.","Alteração de dados",1);
         }else{
            JOptionPane.showMessageDialog(null,"Dados não foram alterados.","Alteração de dados",JOptionPane.ERROR_MESSAGE);
         }
         
         st.close();
         con.close();
             
     }
     
      public String selectCodigo() throws SQLException{
       
       con = cone.carrega();
       String sql = "select MAX(IdFornecedor) from Fornecedor" ;
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       int novoCodigo = 0;
       if(rs.next()){
           novoCodigo = rs.getInt("MAX(IdFornecedor)");
       }
       con.close();
       st.close();
       rs.close();
       
       return String.valueOf(++novoCodigo);
   }
  
   
    
	
}
