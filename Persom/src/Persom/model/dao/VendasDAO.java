/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import model.Conexao;
import model.Vendas;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno noite
 */
public class VendasDAO {
    
    Conexao cone = new Conexao();
    Connection con = null;
    
    public void insert(Vendas v) throws SQLException{
        
        con = cone.carrega();
        String sql = "insert into Vendas(Ordem_Servico,Data_Venda,NomeProduto,ModeloProduto,MarcaProduto,PrecoUnit,Quantidade_Produto,Valor_Total,Garantia,Cliente_CPF_CNPJ,idProduto) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1,v.getOrdemServico());
        ps.setDate(2,new Date(Calendar.getInstance().getTimeInMillis()));
        ps.setString(3,v.getNomeProduto());
        ps.setString(4,v.getModeloProduto());
        ps.setString(5,v.getMarcaProduto());
        ps.setBigDecimal(6,v.getPrecoUnit());
        ps.setInt(7,v.getQuantidadeProduto());
        ps.setBigDecimal(8,v.getValorTotal());
        ps.setString(9,v.getGarantia());
        ps.setString(10,v.getVendasPK().getClienteCPFCNPJ());
        ps.setInt(11,v.getVendasPK().getIdProduto());
        
        ps.execute();
        JOptionPane.showMessageDialog(null,"Venda realizada com Sucesso","Cadastro Venda",1);
        
        ps.close();
        con.close();
    }
    
    public String selectOrdemServico() throws SQLException{
       
       con = cone.carrega();
       String sql = "select MAX(Ordem_Servico) from Vendas" ;
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       int novaOrdem = 0;
       if(rs.next()){
          novaOrdem = rs.getInt("MAX(Ordem_Servico)");
       }
       con.close();
       st.close();
       rs.close();
       
       return String.valueOf(++novaOrdem);
   }
    
      public void delete(Vendas v) throws SQLException{
        
        con = cone.carrega();
        String sql = "delete from Vendas where Ordem_Servico= ? and idProduto=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,v.getOrdemServico());
        ps.setInt(2,v.getVendasPK().getIdProduto());
        
        ps.execute();
        JOptionPane.showMessageDialog(null,"Produto excluído da venda realizada com Sucesso","Exclusão Produto",1);
        
        ps.close();
        con.close();

   }
      
   public BigDecimal select(Vendas v) throws SQLException{
       
       con = cone.carrega();
       String sql = "SELECT sum(Valor_Total) from Vendas where Ordem_Servico=" + v.getOrdemServico();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       
       BigDecimal valor = null;
       
       if(rs.next()){
           valor = rs.getBigDecimal("sum(Valor_Total)");
       }
       
       con.close();
       st.close();
       rs.close();
       
       
       return valor;
       
   }
    
}
