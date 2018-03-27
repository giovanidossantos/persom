/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import model.Conexao;
import model.Movimento;
import model.Vendas;
import java.math.BigDecimal;
import java.sql.*;
import javax.swing.JOptionPane;
 
/**
 *
 * @author Giovani dos Santos
 */
public class MovimentoDAO {
     
     Conexao cone = new Conexao();
     Connection con = null;
     int valor;
     int valor1;
   
   
    public void insert(Movimento m) throws SQLException {
        
        con = cone.carrega();
        String sql = "insert into movimento(Data_Movimento,Tipo_Movimento,Quantidade,Preco_compra,idProduto) values (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
         
        
      ps.setDate(1,new Date(m.getDataMovimento().getTime()));
      ps.setString(2,m.getTipoMovimento());
      ps.setInt(3,m.getQuantidade());
      ps.setDouble(4,m.getPrecocompra());
      ps.setInt(5,m.getMovimentoPK().getIdProduto());
      
      
      ps.execute();  
      JOptionPane.showMessageDialog(null,"Dados Gravados Com Sucesso","Cadastro",1);
      ps.close();
      con.close();
      
     }
    
     public int selectEstoque(Movimento m) throws SQLException{
       
       con = cone.carrega();
       String sql = "select Quantidade from Movimento where idProduto=" + m.getMovimentoPK().getIdProduto() ;
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
        int qtd = 0;
       if(rs.next()){
           qtd = rs.getInt("Quantidade");
           
       }
      
       con.close();
       st.close();
       rs.close();
       
       return qtd;
    }
     
       public int selectQuantidade(Movimento m) throws SQLException{
       
       con = cone.carrega();
       String sql = "select Quantidade from Movimento where idProduto=" + m.getMovimentoPK().getIdProduto() ;
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
        int qtd = 0;
       if(rs.next()){
           qtd = rs.getInt("Quantidade");
           
       }
       valor = qtd - m.getQuantidade();
      
       con.close();
       st.close();
       rs.close();
       
       return qtd;
    }
       
    
       
    
       
    public int selectCompra(Movimento m) throws SQLException{
       
       con = cone.carrega();
       String sql = "select Quantidade from Movimento where idProduto=" + m.getMovimentoPK().getIdProduto() ;
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
        int qtd = 0;
       if(rs.next()){
           qtd = rs.getInt("Quantidade");
           
       }
       valor1 = qtd + m.getQuantidade();
      
       con.close();
       st.close();
       rs.close();
       
       return qtd;
    }
     
    public void update(Movimento m) throws SQLException{
        
        con = cone.carrega();
        Statement st = con.createStatement();
        
        st.executeUpdate("Update Movimento set Quantidade = '" + valor + 
                "'where idProduto = '" + m.getMovimentoPK().getIdProduto() + 
                "' and Tipo_Movimento = 'CADASTRO'");
        
           
       st.close();
       con.close();
    }
    
    public void updateCompra(Movimento m) throws SQLException{
        
        con = cone.carrega();
        Statement st = con.createStatement();
       
        st.executeUpdate("Update Movimento set Quantidade = '" + valor1 + 
                "'where idProduto = '" + m.getMovimentoPK().getIdProduto() + 
                "' and Tipo_Movimento = 'CADASTRO'");
        
           
       st.close();
       con.close();
       
      
    }
    
     public BigDecimal selectSaida() throws SQLException{
       
       con = cone.carrega();
       String sql = "select SUM(Preco_compra * Quantidade) from movimento where Data_Movimento = curdate() and Tipo_Movimento = 'COMPRA' ";
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       BigDecimal valor = null ;
       if(rs.next()){
           valor = rs.getBigDecimal("SUM(Preco_compra * Quantidade)");
       }
       con.close();
       st.close();
       rs.close();
       
       return valor;
   }
     
    public BigDecimal selectSaldoAnterior() throws SQLException{
       
       con = cone.carrega();
       String sql = "select SUM(Preco_compra * Quantidade) from movimento where Data_Movimento = curdate() - 1 and Tipo_Movimento = 'COMPRA' ";
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       BigDecimal valor = null ;
       if(rs.next()){
           valor = rs.getBigDecimal("SUM(Preco_compra * Quantidade)");
       }
       con.close();
       st.close();
       rs.close();
       
       return valor;
   }
    
   public void delete(Movimento m,Vendas v) throws SQLException{
        
        con = cone.carrega();
        String sql = "delete m from Movimento m\n" +
        "inner join Vendas on m.idProduto = Vendas.idProduto\n" +
        "where m.Tipo_Movimento = 'Vendas' and Vendas.Ordem_Servico = ? and m.idProduto = ? ;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,v.getOrdemServico());
        ps.setInt(2,m.getMovimentoPK().getIdProduto());
       
        
        
        ps.execute();
        
        ps.close();
        con.close();

   }
    
    
    
}
