/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;


import model.Conexao;
import model.Orcamento;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/*
 *
 * @author Giovani dos Santos
 */
public class OrcamentoDAO {
    
    Conexao cone = new Conexao();
    Connection con = null;
    DateFormat f = DateFormat.getDateInstance();
   
    
  public void insert(Orcamento o) throws SQLException{
    
      con = cone.carrega();
      String sql = "insert into Orcamento(Ordem_Prestacao,Data_Orcamento,Data_Prevista_Orca,Data_Entrega_Prod,Valor_Reparo,Sinal,idSerie,Tipo_Produto,Modelo,Marca,Defeito_Reclamado,Causa_Provavel,Defeito_Encontrado,Observacoes_Tecnicas,Cliente_CPF_CNPJ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      
      ps.setInt(1,o.getOrdemPrestacao());
      ps.setDate(2,new Date(Calendar.getInstance().getTimeInMillis()));
      ps.setDate(3,new Date(o.getDataPrevistaOrca().getTime()));
      if (o.getDataEntregaProd()!=null && o.getDataEntregaProd().getTime() > 0){
          ps.setDate(4,new Date(o.getDataEntregaProd().getTime()));
      }else{
       Calendar c = Calendar.getInstance();
       c.set(2014,Calendar.ALL_STYLES,00);
       ps.setDate(4,new Date(c.getTime().getTime()));
      }
      ps.setBigDecimal(5,o.getValorReparo());
      ps.setBigDecimal(6,o.getSinal());
      ps.setInt(7,o.getIdSerie());
      ps.setString(8,o.getTipoProduto());
      ps.setString(9,o.getModelo());
      ps.setString(10,o.getMarca());
      ps.setString(11,o.getDefeitoReclamado());
      ps.setString(12,o.getCausaProvavel());
      ps.setString(13,o.getDefeitoEncontrado());
      ps.setString(14,o.getObservacoesTecnicas());
      ps.setString(15,o.getOrcamentoPK().getClienteCPFCNPJ());
      
      ps.execute();
      
      JOptionPane.showMessageDialog(null,"Dados Cadastrados com Sucesso","Cadastro Orçamento",1);
      
      ps.close();
      con.close();
  }
   
   public Orcamento select(Orcamento o) throws SQLException{
       
       con = cone.carrega();
       String sql = "select * from Orcamento where idOrcamento=" + o.getOrcamentoPK().getIdOrcamento();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       
       if(rs.next()){
           o.setOrdemPrestacao(rs.getInt("Ordem_Prestacao"));
           o.setDataOrcamento(rs.getDate("Data_Orcamento"));
           o.setDataPrevistaOrca(rs.getDate("Data_Prevista_Orca"));
           o.setDataEntregaProd(rs.getDate("Data_Entrega_Prod"));
           o.setValorReparo(rs.getBigDecimal("Valor_Reparo"));
           o.setSinal(rs.getBigDecimal("Sinal"));
           o.setModelo(rs.getString("Modelo"));
           o.setMarca(rs.getString("Marca"));
           o.setIdSerie(rs.getInt("idSerie"));
           o.setDefeitoReclamado(rs.getString("Defeito_Reclamado"));
           o.setCausaProvavel(rs.getString("Causa_Provavel"));
           o.setDefeitoEncontrado(rs.getString("Defeito_Encontrado"));
           o.setObservacoesTecnicas(rs.getString("Observacoes_Tecnicas"));
           o.setTipoProduto(rs.getString("Tipo_Produto"));
           o.getOrcamentoPK().setClienteCPFCNPJ(rs.getString("Cliente_CPF_CNPJ"));
          
       }else{
             JOptionPane.showMessageDialog(null,"Nenhum Dado Encontrado","Consulta Orçamento",JOptionPane.ERROR_MESSAGE);
       }
       con.close();
       st.close();
       rs.close();
       
       return o;
   }
   
   public String selectOrdemPrestacao() throws SQLException{
       
       con = cone.carrega();
       String sql = "select MAX(Ordem_Prestacao) from Orcamento";
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       int novaOrdem = 0;
       if(rs.next()){
           novaOrdem = rs.getInt("MAX(Ordem_Prestacao)");
       }
       con.close();
       st.close();
       rs.close();
       
       return String.valueOf(++novaOrdem);
   }
   
   public void update(Orcamento o) throws SQLException{
       
       con = cone.carrega();
       Statement st = con.createStatement();
       
       int registro = st.executeUpdate("Update Orcamento set Data_Prevista_Orca='" + o.getDataPrevistaOrca() + "',Data_Entrega_Prod='" + o.getDataEntregaProd() + "',Valor_Reparo='" + o.getValorReparo() +
         "',Sinal='" + o.getSinal() + "',Tipo_Produto='" + o.getTipoProduto() + "',Modelo='" + o.getModelo() + "',Marca='" + o.getMarca() + "',Defeito_Reclamado='" + o.getDefeitoReclamado() +
         "',Causa_Provavel='" + o.getCausaProvavel() + "',Defeito_Encontrado='" + o.getDefeitoEncontrado() + "',Observacoes_Tecnicas='" + o.getObservacoesTecnicas() + "'where Cliente_CPF_CNPJ='" + o.getOrcamentoPK().getClienteCPFCNPJ() + "' and idSerie = " + o.getIdSerie());
       
         if(registro != 0){
            JOptionPane.showMessageDialog(null,"Dados Alterados com sucesso.","Alteração de dados",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Dados não foram alterados.","Alteração de dados",JOptionPane.ERROR_MESSAGE);
        }
        st.close();
        con.close();
   }
   
   public void delete(Orcamento o) throws SQLException{
        
        con = cone.carrega();
        String sql = "delete from Orcamento where idOrcamento = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,o.getOrcamentoPK().getIdOrcamento());
        
        ps.execute();
        JOptionPane.showMessageDialog(null,"Dados Excluídos com Sucesso","Exclusão Orçamento",1);
        
        ps.close();
        con.close();

   }
   
   public BigDecimal selectValor(Orcamento o) throws SQLException{
       
       con = cone.carrega();
       String sql = "SELECT sum(Valor_Reparo) from Orcamento where Ordem_Prestacao=" + o.getOrdemPrestacao();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       
       BigDecimal valor = null;
       
       if(rs.next()){
           valor = rs.getBigDecimal("sum(Valor_Reparo)");
       }
       
       con.close();
       st.close();
       rs.close();
       
       
       return valor;
       
   }
   
    public BigDecimal selectSinal(Orcamento o) throws SQLException{
       
       con = cone.carrega();
       String sql = "SELECT sum(Sinal) from Orcamento where Ordem_Prestacao=" + o.getOrdemPrestacao();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       
       BigDecimal valor = null;
       
       if(rs.next()){
           valor = rs.getBigDecimal("sum(Sinal)");
       }
       
       con.close();
       st.close();
       rs.close();
       
       
       return valor;
       
   }
}
