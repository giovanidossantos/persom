/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Conexao;
import model.Movimento;
import model.MovimentoPK;
import model.Produto;
import model.dao.MovimentoDAO;
import model.dao.ProdutoDAO;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


/**
 *
 * @author Giovani dos Santos
 */
public class MovimentoGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = 1793602771205005313L;
    
    Produto p = new Produto();
    ProdutoDAO pd = new ProdutoDAO();
    Movimento m = new Movimento();
    MovimentoDAO md = new MovimentoDAO();
    Conexao cone = new Conexao();
    NumberFormat f = NumberFormat.getCurrencyInstance();
    String movimento;
    Connection con = null;
    int valor;
    int valor1;
    int estoque;
    int valor2;
    int produto;
    String selecione;
    String usuario;
    int soma = 0;
    double somapreco = 0;
    int quantidade;
   
    
    public MovimentoGUI() {
        initComponents();
        this.getContentPane().setLayout(new FlowLayout());
        setIcon();
        datahora();   
    }

    @SuppressWarnings("unchecked")
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonPesquisa = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jDateChooserData = new com.toedter.calendar.JDateChooser();
        jButtonCompra = new javax.swing.JButton();
        jButtonOrcamento = new javax.swing.JButton();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelDataHora = new javax.swing.JLabel();
        jTextFieldFiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom - Tela de Movimento                                       ");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Código do Produto");

        jTextFieldCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Data");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade");

        jTextFieldQuantidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Selecione o que deseja pesquisar:");

        jButtonPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.setToolTipText("Pesquise informação do que deseja consultar");
        jButtonPesquisa.setFocusable(false);
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Save.png"))); // NOI18N
        jButtonSalvar.setText("Cadastrar");
        jButtonSalvar.setToolTipText("Cadastar produto pela primeira vez");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Preço de Compra");

        jComboBoxFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Tipo de Movimento", "Código do Produto" }));
        jComboBoxFiltro.setFocusable(false);
        jComboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFiltroActionPerformed(evt);
            }
        });

        jDateChooserData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButtonCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Business-32.png"))); // NOI18N
        jButtonCompra.setText("Compra");
        jButtonCompra.setToolTipText(" Cadastrar Compra do produto cadastrado");
        jButtonCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompraActionPerformed(evt);
            }
        });

        jButtonOrcamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Orçamento.png"))); // NOI18N
        jButtonOrcamento.setText("Orçamento");
        jButtonOrcamento.setToolTipText("Cadastrar produto utilizado no Orçamento");
        jButtonOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrcamentoActionPerformed(evt);
            }
        });

        jTextFieldPreco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabelDataHora.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jTextFieldFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jButtonCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jButtonOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
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

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
        m.setMovimentoPK(new MovimentoPK());
        m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        m.setDataMovimento(jDateChooserData.getDate());
        m.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
        m.setTipoMovimento("CADASTRO"); 
        m.setPrecocompra(Double.parseDouble(jTextFieldPreco.getText()));
      
            md.insert(m);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao cadastrar informação!","Cadastro",0);
        } catch (NumberFormatException p){
            JOptionPane.showMessageDialog(null,"Informe apenas ponto e número no campo Preco de Compra! ","Cadastro",0);
        }
        
        limpar();
        jTextFieldCodigo.grabFocus();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
       new TelaPrincipal().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompraActionPerformed
        try {
        m.setMovimentoPK(new MovimentoPK());
        m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        m.setDataMovimento(jDateChooserData.getDate());
        m.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
        m.setTipoMovimento("COMPRA"); 
         if(jTextFieldPreco.getText() != null && !jTextFieldPreco.getText().equals("")){
        m.setPrecocompra(Double.parseDouble(jTextFieldPreco.getText()));
         }else 
        m.setPrecocompra(0.00);
        
            md.insert(m);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar informação!","Cadastro de Compra",0);
        } catch (NumberFormatException p){
            JOptionPane.showMessageDialog(null,"Informe apenas ponto e número no campo Preco de Compra! ","Cadastro de Compra",0);
        }
        
         
        try {
            m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
            valor1 = md.selectCompra(m);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        m.setMovimentoPK(new MovimentoPK());
        m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));  
            try {
                md.updateCompra(m);  
            } catch (SQLException ex1) {
                Logger.getLogger(MovimentoGUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        limpar();
        jTextFieldCodigo.grabFocus();
    }//GEN-LAST:event_jButtonCompraActionPerformed

    private void jButtonOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrcamentoActionPerformed
        m.setMovimentoPK(new MovimentoPK());
        m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        m.setDataMovimento(jDateChooserData.getDate());
        m.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
        m.setTipoMovimento("ORÇAMENTO");
        m.setPrecocompra(0.00);
        try {
            md.insert(m);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar informação!","Cadastro de Orçamento",0);
        }
         try {
            m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
            valor = md.selectQuantidade(m);
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.setMovimentoPK(new MovimentoPK());
        m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        try {
            md.update(m);
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
            valor2 =  md.selectEstoque(m);
                    } catch (SQLException ex) {
            Logger.getLogger(MovimentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            p.setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
            estoque = pd.selectEstoque(p);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(valor2 <= estoque){
            JOptionPane.showMessageDialog(null,"O produto " + m.getMovimentoPK().getIdProduto() + " está com a quantidade de " + valor2 + " no estoque e o Estoque Mínimo dele é " + estoque,"Controle Estoque",2);
        }
        
        limpar();
        jTextFieldCodigo.grabFocus();
    }//GEN-LAST:event_jButtonOrcamentoActionPerformed

    private void jTextFieldCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyTyped
        
    }//GEN-LAST:event_jTextFieldCodigoKeyTyped

    private void jTextFieldCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyPressed
       
    }//GEN-LAST:event_jTextFieldCodigoKeyPressed

    private void jTextFieldCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyReleased
 
      
    }//GEN-LAST:event_jTextFieldCodigoKeyReleased

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
      Relatorio r = new Relatorio();
        try {       
            r.Gerar();
        } catch (JRException ex) {
            Logger.getLogger(MovimentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jComboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFiltroActionPerformed
        if(jComboBoxFiltro.getSelectedItem().toString().equals("Tipo de Movimento")){
            selecione = "Tipo_Movimento";
        }else if(jComboBoxFiltro.getSelectedItem().toString().equals("Código do Produto")){
            selecione = "movimento.idProduto";   
        }
    }//GEN-LAST:event_jComboBoxFiltroActionPerformed

           
       
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
            java.util.logging.Logger.getLogger(MovimentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimentoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCompra;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonOrcamento;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<Object> jComboBoxFiltro;
    private com.toedter.calendar.JDateChooser jDateChooserData;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldFiltro;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }
    
      public void limpar(){
        jTextFieldCodigo.setText("");
        jDateChooserData.setDate(null);
        jTextFieldQuantidade.setText("");
        jTextFieldPreco.setText(""); 
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

public class Relatorio{
    public void Gerar() throws JRException, SQLException{
       usuario = System.getProperty("user.name");

        con = cone.carrega();
          
         Map<String,Object> filtrar = new HashMap<>();
         
         filtrar.put("filtro",jTextFieldFiltro.getText().toUpperCase());
         
         InputStream inputStream = getClass().getResourceAsStream("/report/Movimento.jasper");
         
             JasperPrint print = JasperFillManager.fillReport(inputStream,filtrar,con);
         
            try {
             JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\" + usuario + "\\Documents\\Movimento.pdf");
             }catch(JRException ex) {
              JOptionPane.showMessageDialog(null,"Feche o arquivo que se encontra aberto!","Relatório",0);
             }
          
        File  pdf = new File("C:\\Users\\" + usuario + "\\Documents\\Movimento.pdf");
            
             try { 
                Desktop.getDesktop().open(pdf);   
               } catch(Exception ex) {  
                ex.printStackTrace();  
                JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
               }
        
             con.close();
             jTextFieldFiltro.setText("");
             jComboBoxFiltro.setSelectedItem("Selecione");
             pdf.deleteOnExit();
       
    }
  }
}
