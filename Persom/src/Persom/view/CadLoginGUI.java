/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Conexao;
import model.Login;
import model.ModeloTabela;
import model.dao.LoginDAO;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Giovani dos Santos
 */
public class CadLoginGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = 4128718581928994771L;

    Login l = new Login();
    LoginDAO ld = new LoginDAO();
    Conexao cone = new Conexao();
    ResultSet rs;
    Connection con = null;
    Statement st;
    
    public CadLoginGUI() {
        initComponents();
        setIcon();
         this.getContentPane().setLayout(new FlowLayout());
         jTextFieldUser.grabFocus();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLogin = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonConsultar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonLogar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom -  Tela de Cadastro de Login");

        jTableLogin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableLogin);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Usuário");

        jTextFieldUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Senha");

        jButtonConsultar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonConsultar.setText("Consultar");
        jButtonConsultar.setToolTipText("Consultar senha do Usuário");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Update.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar Usuário e Senha");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonLogar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/chave_login.png"))); // NOI18N
        jButtonLogar.setText("Logar");
        jButtonLogar.setToolTipText("Entrar no Sistema");
        jButtonLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogarActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Save.png"))); // NOI18N
        jButtonSalvar.setText("Cadastrar");
        jButtonSalvar.setToolTipText("Cadastar Usuário e Senha");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTextFieldSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSenhaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cadeado.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSalvar)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(63, 63, 63))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
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

    private void jButtonLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogarActionPerformed
        new LoginGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonLogarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
             String login = null;
            
               
             try {
                   
                  conexao("SELECT login FROM Login WHERE login ='"+ jTextFieldUser.getText() +"';");
                    
                    while(rs.next()){
                        
                     login = rs.getString("login");    
                    }
                    
                        if(jTextFieldUser.getText().equals(login)){
                           JOptionPane.showMessageDialog(null,"Nome de usuário já existe!!!! Por favor informe outro nome.","Cadastro de Usuário",0);
                           jTextFieldUser.setForeground(Color.red);
                           jTextFieldUser.grabFocus();
                          }else{
                             if(jTextFieldUser.getText().isEmpty() == true){
                              JOptionPane.showMessageDialog(null,"Informe um nome de usuário!","Cadastro de Usuário",0);
                              jTextFieldUser.grabFocus();
                             }else if(jTextFieldSenha.getText().isEmpty() == true){
                               JOptionPane.showMessageDialog(null,"Por favor informe uma senha!","Cadastro de Usuário",0);
                               jTextFieldSenha.grabFocus();
                             }else{
                                 l.setLogin(jTextFieldUser.getText());
                                 l.setSenha(jTextFieldSenha.getText());
                              try {
                               ld.insert(l);
                               }catch (SQLException ex) {
                                 JOptionPane.showMessageDialog(null,"Informe apenas 8 caracteres na senha","Cadastro de Usuário",0);  
                               }
                               jTextFieldUser.setText("");
                               jTextFieldSenha.setText("");
                             }
                          }
                            
                     con.close();
                     st.close();
                     rs.close();
                    } catch (SQLException ex) {
            Logger.getLogger(CadLoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTextFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSenhaActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        l.setLogin(jTextFieldUser.getText());
        l.setSenha(jTextFieldSenha.getText());
        
        if(jTextFieldSenha.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null,"Por favor informe uma senha!","Alteração de Senha",0); 
          }else if(jTextFieldUser.getText().isEmpty() == true){
             JOptionPane.showMessageDialog(null,"Por favor informe um nome de usuário!","Alteração de Senha",0);
              }else{
        try {
            ld.update(l);
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Informe apenas 8 caracteres na senha","Alteração de Senha",0);  
        }
      }
        jTextFieldUser.setText("");
        jTextFieldSenha.setText("");
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
                String x =  JOptionPane.showInputDialog(null,"Informe o seu nome de usuário","Consulta de Senha",3);
                
                String login = null;
       
             try {
                   
                  conexao("SELECT login FROM Login WHERE login ='"+ x +"';");
                    
                    while(rs.next()){
                        
                     login = rs.getString("login");    
                    }
                    
                        if(x.equals(login)){
                           try {
                            preenchertabela("select login,senha from Login where login = '" + x + "';");
                            } catch (SQLException ex) {
                            }

                             }else
                               JOptionPane.showMessageDialog(null," Usuário inválido! ","Consulta de Senha",0);
                                 
                    
                    } catch (SQLException ex) {
            Logger.getLogger(CadLoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButtonConsultarActionPerformed
    
    public void preenchertabela(String sql) throws SQLException{
        ArrayList<Object> dados = new ArrayList<>();
        String [] Colunas = new String[]{"Usuário","Senha"};
          
         conexao(sql);
        
         try{
            rs.first();
         
         do{
            dados.add(new Object[]{rs.getString("Login"),rs.getString("Senha")});
         }while(rs.next());
         
         }catch(SQLException ex) {
       }
       
       con.close();
       st.close();
       rs.close();
       
            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            jTableLogin.setModel(modelo);
            jTableLogin.getColumnModel().getColumn(0).setResizable(false);
            jTableLogin.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableLogin.getColumnModel().getColumn(1).setResizable(false);
            jTableLogin.getColumnModel().getColumn(1).setPreferredWidth(120);
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
            java.util.logging.Logger.getLogger(CadLoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadLoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadLoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadLoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadLoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonLogar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLogin;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }
    
    public void conexao(String sql) throws SQLException{
           con = cone.carrega();
           st = con.createStatement();
           rs = st.executeQuery(sql);
    }
}
