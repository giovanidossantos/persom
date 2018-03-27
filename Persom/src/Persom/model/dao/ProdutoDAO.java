/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;


import model.Conexao;
import model.Produto;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno noite
 */
public class ProdutoDAO {
    
    Conexao cone = new Conexao();
    Connection con = null;
    
    public void insert(Produto P) throws SQLException {
        
        con = cone.carrega();
        String sql = "insert into Produto values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
         
         ps.setInt(1,P.getIdProduto());       
         ps.setDate(2,new Date(Calendar.getInstance().getTimeInMillis()));                 
         ps.setString(3,P.getNome());
         ps.setString(4,P.getFornecedor());
         ps.setString(5,P.getModelo());
         ps.setInt(6,P.getEstoqueMinimo());
         ps.setString(7,P.getUnidMedida());
         ps.setBigDecimal(8,P.getPrecovenda());
         
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Produto Cadastrado Com Sucesso","Cadastro Produto",1);
         ps.close();
         con.close();
         
    }
    
    public Produto selectProduto(Produto p) throws SQLException{
        
        con = cone.carrega();
        String sql = "select * from Produto where idProduto=" + p.getIdProduto();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            p.setNome(rs.getString("Nome"));
            p.setModelo(rs.getString("Modelo"));
            p.setFornecedor(rs.getString("Fornecedor"));
            p.setPrecovenda(rs.getBigDecimal("Preco_Venda"));
        }else{
           JOptionPane.showMessageDialog(null,"Nenhum Dado Encontrado","Consulta Produto",JOptionPane.ERROR_MESSAGE);
        }
        
        con.close();
        st.close();
        rs.close();
            
        
        return p;
        
    }
    
     public void update(Produto p) throws SQLException{
        
        con = cone.carrega();
        Statement st = con.createStatement();
        
        int registro = st.executeUpdate("Update Produto set Nome='" + p.getNome() + "',Fornecedor='" + p.getFornecedor() + "',Modelo='" + p.getModelo() + "',Estoque_Minimo=" + p.getEstoqueMinimo() +
         ",Unid_Medida='" + p.getUnidMedida() + "',Preco_venda='" + p.getPrecovenda() + "'where idProduto=" + p.getIdProduto());
        
        if(registro != 0){
            JOptionPane.showMessageDialog(null,"Dados Alterados com sucesso.","Alteração de dados",1);
        }else{
            JOptionPane.showMessageDialog(null,"Dados não foram alterados.","Alteração de dados",JOptionPane.ERROR_MESSAGE);
        }
        st.close();
        con.close();
    }
    
      public int selectEstoque(Produto p) throws SQLException{
       
       con = cone.carrega();
       String sql = "select Estoque_Minimo from Produto where idProduto=" + p.getIdProduto();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       int estoque = 0;
       if(rs.next()){
          estoque = rs.getInt("Estoque_Minimo");
           
       }
       con.close();
       st.close();
       rs.close();
       
       return estoque;
   }
     
    
}
