/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Conexao;
import model.ModeloTabela;
import java.awt.FlowLayout;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovani dos Santos
 */
public class ConsultaVendasGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = -4114237486215613681L;
   
   Conexao cone = new Conexao();
   Connection con = null;
   String pesquisa;
    public ConsultaVendasGUI() {
        initComponents();
        preencher();
        this.getContentPane().setLayout(new FlowLayout());
        setIcon();
        datahora();
  }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxPesquisa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonPequisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jButtonMenu = new javax.swing.JButton();
        jLabelDataHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom -  Tela de Consulta de Vendas");

        jComboBoxPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a opção", "Código do Produto", "Ordem de Serviço", "CPF/CNPJ do Cliente", " " }));
        jComboBoxPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPesquisaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Opções de pesquisa");

        jTextFieldFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButtonPequisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPequisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonPequisa.setText("Pesquisar");
        jButtonPequisa.setToolTipText("Pesquise o que deseja consultar");
        jButtonPequisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPequisaActionPerformed(evt);
            }
        });

        jTableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableVendas);

        jButtonMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Menu.png"))); // NOI18N
        jButtonMenu.setText("Menu");
        jButtonMenu.setToolTipText("Ir para Tela Principal");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jLabelDataHora.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 738, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonPequisa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPequisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPesquisaActionPerformed
         if (jComboBoxPesquisa.getSelectedItem().toString().equals("Código do Produto")) {
              pesquisa = "idProduto";
        } else if (jComboBoxPesquisa.getSelectedItem().toString().equals("Ordem de Serviço")) {
              pesquisa = "Ordem_Servico";
        } else if (jComboBoxPesquisa.getSelectedItem().toString().equals("CPF/CNPJ do Cliente")) {
              pesquisa = "Cliente_CPF_CNPJ";
    }//GEN-LAST:event_jComboBoxPesquisaActionPerformed
 }
    private void jButtonPequisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPequisaActionPerformed
         try {
           preenchertabela("SELECT * FROM Vendas WHERE " + pesquisa + " like '%" + jTextFieldFiltro.getText().toUpperCase() + "%'");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao cosultar informação! \n Verifique o que deseja pesquisar!","Consulta de Venda",0);
       }
         jComboBoxPesquisa.setSelectedItem("Selecione a opção");
         jTextFieldFiltro.setText("");
    }//GEN-LAST:event_jButtonPequisaActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

   
    
    public void preenchertabela(String sql) throws SQLException{
        ArrayList<Object> dados = new ArrayList<>();
        DateFormat  df = DateFormat.getDateInstance();
        NumberFormat f = NumberFormat.getCurrencyInstance();
        String [] Colunas = new String[]{"id","Ordem Serviço","Data da Venda","Código do Produto","Quantidade","Valor Total",
        "Garantia do Produto","Cliente"};
          
      con = cone.carrega();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
        try{
            rs.first();
           do{
           dados.add(new Object[]{rs.getInt("idVendas"),rs.getInt("Ordem_Servico"),df.format(rs.getDate("Data_Venda")),rs.getInt("idProduto"),rs.getInt("Quantidade_Produto"),f.format(rs.getBigDecimal("Valor_Total")),
           rs.getString("Garantia"),rs.getString("Cliente_CPF_CNPJ")});
         }while(rs.next());
            } catch (SQLException ex){
        } 
                
       con.close();
       st.close();
       rs.close();
       
       
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            jTableVendas.setModel(modelo);
            jTableVendas.getColumnModel().getColumn(0).setResizable(false);
            jTableVendas.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTableVendas.getColumnModel().getColumn(1).setResizable(false);
            jTableVendas.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTableVendas.getColumnModel().getColumn(2).setResizable(false);
            jTableVendas.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableVendas.getColumnModel().getColumn(3).setResizable(false);
            jTableVendas.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableVendas.getColumnModel().getColumn(4).setResizable(false);
            jTableVendas.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTableVendas.getColumnModel().getColumn(5).setResizable(false);
            jTableVendas.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTableVendas.getColumnModel().getColumn(6).setResizable(false);
            jTableVendas.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTableVendas.getColumnModel().getColumn(7).setResizable(false);
            jTableVendas.getColumnModel().getColumn(7).setPreferredWidth(100);
               
               
    }  
            
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaVendasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaVendasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaVendasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaVendasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultaVendasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonPequisa;
    private javax.swing.JComboBox<Object> jComboBoxPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }
    
       public void preencher(){
       try {
           preenchertabela("select * from Vendas order by idVendas");
       } catch (SQLException ex) {
           Logger.getLogger(ConsultaVendasGUI.class.getName()).log(Level.SEVERE, null, ex);
       } 
     }
     
  public void datahora(){
     Thread threadRelogio = new Thread() {    
     public void run() {    
       rodaRelogio();    
     }    
   };
   threadRelogio.start();  
  }    
     
     
   
public void rodaRelogio() {    
   try {    
     while(true) {    
       Calendar c = Calendar.getInstance();
       java.util.Date date = c.getTime();
       DateFormat  d = DateFormat.getDateTimeInstance();   
       jLabelDataHora.setText(String.valueOf(d.format(date)));    
       Thread.sleep(1000);    
     }    
   }    
   catch (InterruptedException ex) {    
   }    
 }   
}
