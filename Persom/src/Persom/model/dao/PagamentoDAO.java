/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import model.Conexao;
import model.Pagamento;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovani dos Santos
 */
public class PagamentoDAO {
     
    Conexao cone = new Conexao();
    Connection con = null; 
    
     public void Insert(Pagamento P) throws SQLException{
    
        con = cone.carrega();
        String sql = "insert into Pagamento (Data,OrdemPagamento,Tipo_Operacao,Valor_Total,Valor_Recebido,Troco,Cliente_CPF_CNPJ) values (?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
    
        ps.setDate(1, new Date(Calendar.getInstance().getTimeInMillis()));
        ps.setInt(2,P.getOrdemPagamento());
        ps.setString(3,P.getTipoOperacao());
        ps.setBigDecimal(4,P.getValorTotal());       
        ps.setBigDecimal(5,P.getValorRecebido());
        ps.setBigDecimal(6,P.getTroco());
        ps.setString(7,P.getPagamentoPK().getClienteCPFCNPJ());
                
        ps.execute();
        
        JOptionPane.showMessageDialog(null,"Pagamento efetuado com sucesso.","Cadastro Pagamento",JOptionPane.INFORMATION_MESSAGE);
        
        ps.close();
        con.close();    
        
        
    }
     
    public String selectOrdemPagamento() throws SQLException{
       
       con = cone.carrega();
       String sql = "select MAX(OrdemPagamento) from Pagamento where Tipo_Operacao = 'Manutencao' ";
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       int novaOrdem = 0;
       if(rs.next()){
           novaOrdem = rs.getInt("MAX(OrdemPagamento)");
       }
       con.close();
       st.close();
       rs.close();
       
       return String.valueOf(++novaOrdem);
   }
    
    public BigDecimal selectSaldoAtual() throws SQLException{
       
       con = cone.carrega();
       String sql = "select SUM(Valor_Total) from pagamento where Data = curdate()";
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       BigDecimal valor = null ;
       if(rs.next()){
           valor = rs.getBigDecimal("SUM(Valor_Total)");
       }
       con.close();
       st.close();
       rs.close();
       
       return valor;
   }
    
    public BigDecimal selectSaldoAnterior() throws SQLException{
       
       con = cone.carrega();
       String sql = "select SUM(Valor_Total) from pagamento where Data = curdate() - 1";
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       BigDecimal valor = null ;
       if(rs.next()){
           valor = rs.getBigDecimal("SUM(Valor_Total)");
       }
       con.close();
       st.close();
       rs.close();
       
       return valor;
   } 
}

 
