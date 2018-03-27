/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Conexao;
import model.Fornecedor;
import model.ModeloTabela;
import model.dao.FornecedorDAO;
import java.awt.FlowLayout;
import java.sql.*;
import java.text.DateFormat;
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
public class FornecedoGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = -469534998616150308L;
     
     Fornecedor f = new Fornecedor();
     FornecedorDAO fd = new FornecedorDAO();
     Conexao cone = new Conexao();
     Connection con = null;
     
    public FornecedoGUI() {
        initComponents();
       codigo(); 
       preencher();
       this.getContentPane().setLayout(new FlowLayout());
       setIcon();
       datahora();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldContato = new javax.swing.JTextField();
        jButtonPesquisa = new javax.swing.JButton();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonVerificar = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFornecedor = new javax.swing.JTable();
        jLabelDataHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom - Tela de Fornecedor");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nome");

        jTextFieldNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Telefone");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        jTextFieldEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Contato");

        jTextFieldContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButtonPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.setToolTipText("Selecione o  Nome que deseja cadastrar");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldContato, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldContato, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Save.png"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setToolTipText("Cadastrar Fornecedor");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Update.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar informações do fornecedor");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonVerificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Verificar.png"))); // NOI18N
        jButtonVerificar.setText("Verificar");
        jButtonVerificar.setToolTipText("Veirificar informações do fornecedor");
        jButtonVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerificarActionPerformed(evt);
            }
        });

        jButtonMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Menu.png"))); // NOI18N
        jButtonMenu.setText("Menu");
        jButtonMenu.setToolTipText("Ir para Tela Principal");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Código");

        jTableFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableFornecedor);

        jLabelDataHora.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButtonCadastrar)
                .addGap(36, 36, 36)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtonVerificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addComponent(jScrollPane2)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 687, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
         try {
             preenchertabela("select * from Fornecedor where Nome like '%" + jTextFieldNome.getText().toUpperCase() + "%'");
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao consultar nome do Fornecedor! ","Consulta Fornecedor",0);
         }
       
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        f.setNome(jTextFieldNome.getText().toUpperCase());
        f.setTelefone(jFormattedTextFieldTelefone.getText());
        f.setContato(jTextFieldContato.getText().toUpperCase());
        f.setEmail(jTextFieldEmail.getText().toUpperCase());
         try {
             fd.insert(f);
         } catch (SQLException ex) {
             Logger.getLogger(FornecedoGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         limpar();
         codigo();
         preencher();
         jTextFieldNome.grabFocus();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        f.setNome(jTextFieldNome.getText().toUpperCase());
        f.setTelefone(jFormattedTextFieldTelefone.getText());
        f.setContato(jTextFieldContato.getText().toUpperCase());
        f.setEmail(jTextFieldEmail.getText().toUpperCase());
        f.setIdFornecedor(Integer.parseInt(jTextFieldCodigo.getText()));
         try {
             fd.update(f);
         } catch (SQLException ex) {
             Logger.getLogger(FornecedoGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        limpar();
        preencher();
        codigo();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerificarActionPerformed
        int row = jTableFornecedor.getSelectedRow();
        jTextFieldCodigo.setText(String.valueOf(jTableFornecedor.getValueAt(row,0).toString()));
        jTextFieldNome.setText(jTableFornecedor.getValueAt(row,1).toString());
        jFormattedTextFieldTelefone.setText(jTableFornecedor.getValueAt(row,2).toString());
        jTextFieldContato.setText(jTableFornecedor.getValueAt(row,3).toString());
        jTextFieldEmail.setText(jTableFornecedor.getValueAt(row,4).toString());
    }//GEN-LAST:event_jButtonVerificarActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed
     public void limpar(){
        jTextFieldNome.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldContato.setText("");
        jTextFieldEmail.setText("");
        jTextFieldNome.grabFocus(); 
     }
     public void preenchertabela(String sql) throws SQLException{
       ArrayList<Object> dados = new ArrayList<>();
       String [] Colunas = new String[]{"Código","Nome","Telefone","Contato","Email"};
       
     con = cone.carrega();
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
         try{
            rs.first();
            
        do{
            dados.add(new Object[]{rs.getInt("IdFornecedor"),rs.getString("Nome"),rs.getString("Telefone"),rs.getString("Contato"),rs.getString("Email")});
        }while(rs.next());
        
         }catch(SQLException ex) {
          }
      con.close();
      st.close();
      rs.close();
            
            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            jTableFornecedor.setModel(modelo);
            jTableFornecedor.getColumnModel().getColumn(0).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableFornecedor.getColumnModel().getColumn(1).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableFornecedor.getColumnModel().getColumn(2).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableFornecedor.getColumnModel().getColumn(3).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableFornecedor.getColumnModel().getColumn(4).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(180);
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
            java.util.logging.Logger.getLogger(FornecedoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FornecedoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FornecedoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FornecedoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FornecedoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonVerificar;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFornecedor;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldContato;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
      this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }
    
      public void preencher(){
       try {
             preenchertabela("select * from Fornecedor order by IdFornecedor");
         } catch (SQLException ex) {
             Logger.getLogger(FornecedoGUI.class.getName()).log(Level.SEVERE, null, ex);
         } 
    }

    public void codigo(){
         try {
             jTextFieldCodigo.setText(fd.selectCodigo());
         } catch (SQLException ex) {
             Logger.getLogger(FornecedoGUI.class.getName()).log(Level.SEVERE, null, ex);
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
