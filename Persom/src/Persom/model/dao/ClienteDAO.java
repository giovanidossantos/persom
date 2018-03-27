/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;


import model.Cliente;
import model.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class ClienteDAO {
    Conexao cone = new Conexao();
    Connection con = null;
    public void insert(Cliente c) throws SQLException{
        
        con = cone.carrega();
        String sql = "insert into Cliente values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1,c.getCpfCnpj());
        ps.setString(2,c.getNomeRazao());
        ps.setString(3,c.getTipoPessoa());
        ps.setString(4,c.getInscricaoMunicipal());
        ps.setString(5,c.getInscricaoEstadual());
        ps.setString(6,c.getEmail());
        
        ps.execute();
        
        JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso.","Cadastro Cliente",JOptionPane.INFORMATION_MESSAGE);
        
        ps.close();
        con.close();
        
    }
    
    public Cliente select(Cliente c) throws SQLException{
        
        con = cone.carrega();
        String sql = "select * from Cliente where CPF_CNPJ='" + c.getCpfCnpj() + "'";
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            c.setNomeRazao(rs.getString("Nome_Razao"));
            c.setTipoPessoa(rs.getString("Tipo_Pessoa"));
            c.setInscricaoMunicipal(rs.getString("Inscricao_Municipal"));
            c.setInscricaoEstadual(rs.getString("Inscricao_Estadual"));
            c.setEmail(rs.getString("Email"));
           
        }else{
            JOptionPane.showMessageDialog(null,"Nenhum Dado Encontrado para este Cliente","Consulta Cliente",JOptionPane.ERROR_MESSAGE);
        }
        con.close();
        st.close();
        rs.close();
        
      return c;  
    }
    
     public void update(Cliente c) throws SQLException{
        
        con = cone.carrega();
        Statement st = con.createStatement();
        
        int registro = st.executeUpdate("Update Cliente set Nome_Razao='" + c.getNomeRazao() + "',Tipo_Pessoa='" + c.getTipoPessoa() + 
                "',Inscricao_Municipal='" + c.getInscricaoMunicipal() + "',Inscricao_Estadual='" + c.getInscricaoEstadual() + "',Email='" + c.getEmail() +
                "'where CPF_CNPJ='" + c.getCpfCnpj() + "'");
        
        if(registro != 0){
            JOptionPane.showMessageDialog(null,"Dados Alterados com sucesso.","Alteração de dados",1);
        }else{
            JOptionPane.showMessageDialog(null,"Dados não foram alterados.","Alteração de dados",JOptionPane.ERROR_MESSAGE);
        }
        st.close();
        con.close();
    }
}
