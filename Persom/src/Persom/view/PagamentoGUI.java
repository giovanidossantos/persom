/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.*;
import model.dao.PagamentoDAO;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Giovani dos Santos
 */
public class PagamentoGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = -4793934261978906881L;
    
    Pagamento P = new Pagamento();
    PagamentoDAO PD = new PagamentoDAO();
    Orcamento o = new Orcamento();
    Vendas v = new Vendas();
    Conexao cone = new Conexao();
    Connection con = null;
    NumberFormat f = NumberFormat.getCurrencyInstance();
    private static int servico;
    String tipooperacao;
    BigDecimal valorpagar;
    BigDecimal total;
    BigDecimal resultado;
    BigDecimal valor2;
    String valor;
    BigDecimal valorunit;
    String preco;
    BigDecimal sinal;
    Integer quantidade;
    String produto;
    String cpf;
    String nome;
    String municipal;
    String estadual;
    Integer pagamento;
    BigDecimal valortotal;
    BigDecimal valorfinal;
    String usuario;
    String query;
    ResultSet rs;
   
            
   
    private PagamentoGUI() {
        initComponents();
        this.getContentPane().setLayout(new FlowLayout());
        setIcon();
        datahora();
        
    }
  public PagamentoGUI(BigDecimal soma,Vendas v) {
   this();
   total = soma;
   valorpagar = soma;
   valorfinal = soma;
   jTextFieldValorTotal.setText(String.valueOf(f.format(soma)));
   jTextFieldValorPagar.setText(String.valueOf(f.format(soma)));
   tipooperacao = "Vendas";
   jTextFieldCliente.setText(v.getVendasPK().getClienteCPFCNPJ());
   servico = v.getOrdemServico();
   pagamento = v.getOrdemServico();
   jTextFieldValorRecebido.grabFocus();
  }
   
  public PagamentoGUI(Orcamento o,BigDecimal valor,BigDecimal valor1) {
   this();
   if(valor.doubleValue() == 0.00){
    tipooperacao = "Sinal Orçamento";
    sinal = valor1;
    jTextFieldValorTotal.setText(String.valueOf(f.format(valor)));
    jTextFieldSinal.setText(String.valueOf(f.format(valor1)));
    valorpagar = valor1;
    total = valor1;
    valorfinal = valor1;
    jTextFieldValorPagar.setText(String.valueOf(f.format(valor1)));
    jTextFieldCliente.setText(o.getOrcamentoPK().getClienteCPFCNPJ());
    servico = o.getOrdemPrestacao();
    pagamento = o.getOrdemPrestacao();
    jTextFieldValorRecebido.grabFocus();
   }else{
      sinal = valor1;
      jTextFieldValorTotal.setText(String.valueOf(f.format(valor)));
      jTextFieldSinal.setText(String.valueOf(f.format(valor1)));
      BigDecimal val = valor.subtract(valor1);
      valorpagar = val;
      total = val;
      valorfinal = valor;
      jTextFieldValorPagar.setText(String.valueOf(f.format(val)));
      tipooperacao = "Orçamento";
      jTextFieldCliente.setText(o.getOrcamentoPK().getClienteCPFCNPJ());
      servico = o.getOrdemPrestacao();
      pagamento = o.getOrdemPrestacao();
      jTextFieldValorRecebido.grabFocus();
      
   }
  }
  
  public PagamentoGUI(TelaPrincipal t){
   this();
    tipooperacao = "Manutenção";
    jTextFieldCliente.grabFocus();
    ordem();
    
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldValorTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldValorPagar = new javax.swing.JTextField();
        jTextFieldValorRecebido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSinal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTroco = new javax.swing.JTextField();
        jButtonOK = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelDataHora = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom - Tela de Pagamento");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Sinal");

        jTextFieldValorTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorTotalActionPerformed(evt);
            }
        });
        jTextFieldValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldValorTotalKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Valor Total");

        jTextFieldValorPagar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextFieldValorRecebido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldValorRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorRecebidoActionPerformed(evt);
            }
        });
        jTextFieldValorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorRecebidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldValorRecebidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValorRecebidoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Valor à Pagar");

        jTextFieldSinal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldSinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSinalActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Valor Recebido");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Troco");

        jTextFieldTroco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTrocoActionPerformed(evt);
            }
        });

        jButtonOK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Save.png"))); // NOI18N
        jButtonOK.setText("OK");
        jButtonOK.setToolTipText("Cadastrar Pagamento");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonImprimir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Imprimir.png"))); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.setToolTipText("Imprimir comprovante de pagamento");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
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

        jLabel3.setBackground(new java.awt.Color(0, 153, 255));
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logoatu.png"))); // NOI18N

        jTextFieldCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Cliente");

        jLabelDataHora.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185)
                                .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldTroco, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addComponent(jTextFieldValorRecebido, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addComponent(jTextFieldSinal, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addComponent(jTextFieldValorPagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDataHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSinal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
     try {   
      P.setData(new Date(Calendar.getInstance().getTimeInMillis()));
      P.setOrdemPagamento(pagamento);
      P.setTipoOperacao(tipooperacao);
      P.setValorTotal(total);
      P.setValorRecebido(valor2);
      P.setTroco(resultado);
      P.setPagamentoPK(new PagamentoPK());
      P.getPagamentoPK().setClienteCPFCNPJ(jTextFieldCliente.getText());
            
            PD.Insert(P);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar pagamento! ","Cadastro Pagamento",0);
        } catch (NumberFormatException n){
          JOptionPane.showMessageDialog(null,"Informe apenas ponto e número!","Cadastro Pagamento",0);
        }
      
         
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jTextFieldValorRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorRecebidoActionPerformed
        
    }//GEN-LAST:event_jTextFieldValorRecebidoActionPerformed

    private void jTextFieldValorRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorRecebidoKeyPressed
         
    }//GEN-LAST:event_jTextFieldValorRecebidoKeyPressed

    private void jTextFieldValorRecebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorRecebidoKeyReleased
       try{
        if(tipooperacao.equals("Manutenção")){
       valor2 = new BigDecimal(jTextFieldValorRecebido.getText());
       resultado = valor2.subtract(new BigDecimal(jTextFieldValorTotal.getText()));
       jTextFieldTroco.setText(f.format(resultado));
       }else if(tipooperacao.equals("Sinal Orçamento")){    
        valor2 = new BigDecimal(jTextFieldValorRecebido.getText());
        resultado = valor2.subtract(valorpagar);
        jTextFieldTroco.setText(f.format(resultado));   
       }else{
        valor2 = new BigDecimal(jTextFieldValorRecebido.getText());
        resultado = valor2.subtract(valorpagar);
        jTextFieldTroco.setText(f.format(resultado));   
       }
       } catch (NumberFormatException n){
          JOptionPane.showMessageDialog(null,"Informe apenas ponto e número!","Valor Recebido",0);
       }
    }//GEN-LAST:event_jTextFieldValorRecebidoKeyReleased

    private void jTextFieldValorRecebidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorRecebidoKeyTyped
       
    }//GEN-LAST:event_jTextFieldValorRecebidoKeyTyped

    private void jTextFieldValorTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorTotalKeyReleased
        try{
        total = new BigDecimal(jTextFieldValorTotal.getText());
        jTextFieldValorPagar.setText(f.format(total));
        } catch (NumberFormatException n){
          JOptionPane.showMessageDialog(null,"Informe apenas ponto e número!","Valor Total",0);
       }
    }//GEN-LAST:event_jTextFieldValorTotalKeyReleased

    private void jTextFieldValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorTotalActionPerformed

    private void jTextFieldSinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSinalActionPerformed

    private void jTextFieldTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTrocoActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        if(tipooperacao.equals("Vendas")){
        try {
           new Relatorio().GerarVendas();
       } catch (JRException ex) {
           Logger.getLogger(PagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(PagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
       }
        }else if(tipooperacao.equals("Orçamento")){
            try {
                new Relatorio().GerarOrcamento();
            } catch (JRException ex) {
                Logger.getLogger(PagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                new Relatorio().GerarPagamento();
            } catch (JRException ex) {
                Logger.getLogger(PagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        jTextFieldCliente.setText("");
        jTextFieldSinal.setText("");
        jTextFieldTroco.setText("");
        jTextFieldValorPagar.setText("");
        jTextFieldValorRecebido.setText("");
        jTextFieldValorTotal.setText("");
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PagamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PagamentoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldSinal;
    private javax.swing.JTextField jTextFieldTroco;
    private javax.swing.JTextField jTextFieldValorPagar;
    private javax.swing.JTextField jTextFieldValorRecebido;
    private javax.swing.JTextField jTextFieldValorTotal;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }
    
     public void ordem(){
      try {
            pagamento = Integer.parseInt(PD.selectOrdemPagamento());
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
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

public class Relatorio{
    public void GerarPagamento() throws JRException, SQLException{
       
       usuario = System.getProperty("user.name");
       con = cone.carrega();
                      Statement stmt = con.createStatement();
                      
                     if(tipooperacao.equals("Manutenção")){
                     query = "select * from cliente c \n" +
             "inner join pagamento p on(p.Cliente_CPF_CNPJ = c.CPF_CNPJ)\n" +
             "where Tipo_Operacao = 'Manutenção' and OrdemPagamento = " + pagamento;
                        
                     rs = stmt.executeQuery(query);
                      
                        rs.first();
                       
                        cpf = rs.getString("CPF_CNPJ");
                        nome = rs.getString("Nome_Razao");
                        municipal = rs.getString("Inscricao_Municipal");
                        estadual = rs.getString("Inscricao_Estadual");
                        produto = "Outros Serviços";
                        valortotal = total;
                        valorfinal = total;
                        
                     }else if(tipooperacao.equals("Sinal Orçamento")){
                         
                        query = "select * from cliente c \n" +
             "inner join pagamento p on(p.Cliente_CPF_CNPJ = c.CPF_CNPJ)\n" +
             "where Tipo_Operacao = 'Sinal Orçamento' and OrdemPagamento = " + pagamento;
                        
                        rs = stmt.executeQuery(query);
                      
                        rs.first();
                        
                        cpf = rs.getString("CPF_CNPJ");
                        nome = rs.getString("Nome_Razao");
                        municipal = rs.getString("Inscricao_Municipal");
                        estadual = rs.getString("Inscricao_Estadual");
                        produto = "Sinal do Orçamento";
                        valortotal = total; 
                     }
                     
                     JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                     
                        Map<String,Object> filtro = new HashMap<>();
                        
                        filtro.put("SQL",query);
                        filtro.put("nome",nome);
                        filtro.put("cpf",cpf);
                        filtro.put("municipal",municipal);
                        filtro.put("estadual",estadual);
                        filtro.put("produto",produto);
                        filtro.put("valortotal",valortotal);
                        filtro.put("valorfinal",valorfinal);
                        filtro.put("sinal",sinal);
                        filtro.put("valor2",valor2);
                        filtro.put("resultado",resultado);
                        
                        
                         
           InputStream inputStream = getClass().getResourceAsStream("/report/Pagamento.jasper");    
           
          JasperPrint print = JasperFillManager.fillReport(inputStream,filtro,jrRS);
          
           try {
             JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\" + usuario + "\\Documents\\RelatórioPagamento.pdf");
             }catch(JRException ex) {
              JOptionPane.showMessageDialog(null,"Feche o arquivo que se encontra aberto!","Relatório",0);
             }
          
          File pdf = new File("C:\\Users\\" + usuario + "\\Documents\\RelatórioPagamento.pdf");
            
             try { 
                Desktop.getDesktop().open(pdf);   
               } catch(Exception ex) {  
                ex.printStackTrace();  
                JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
               }


          con.close();
          pdf.deleteOnExit();
    }
    
      public void GerarVendas() throws JRException, SQLException{
         usuario = System.getProperty("user.name");
      
        con = cone.carrega();
         
         Map<String,Object> filtro = new HashMap<>();
         
         filtro.put("servico",servico);
         filtro.put("buy",servico);
         filtro.put("tipooperacao",tipooperacao);
         
          InputStream inputStream = getClass().getResourceAsStream("/report/Vendas.jasper");    
           
          JasperPrint print = JasperFillManager.fillReport(inputStream,filtro,con);
          
           try {
             JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\" + usuario + "\\Documents\\Vendas.pdf");
             }catch(JRException ex) {
              JOptionPane.showMessageDialog(null,"Feche o arquivo que se encontra aberto!","Relatório",0);
             }
          
           File  pdf = new File("C:\\Users\\" + usuario + "\\Documents\\Vendas.pdf");
            
             try { 
                Desktop.getDesktop().open(pdf);   
               } catch(Exception ex) {  
                ex.printStackTrace();  
                JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
               }
        
          con.close();
          pdf.deleteOnExit();
    }
      
    public void GerarOrcamento() throws JRException, SQLException{
         usuario = System.getProperty("user.name");
      
        con = cone.carrega();
         
         Map<String,Object> filtro = new HashMap<>();
         
         filtro.put("ordem",servico);
         filtro.put("valorfinal",valorfinal);
         filtro.put("sinal",sinal);
         filtro.put("valor2",valor2);
         filtro.put("resultado",resultado);
         
          InputStream inputStream = getClass().getResourceAsStream("/report/Orcamento.jasper");    
           
          JasperPrint print = JasperFillManager.fillReport(inputStream,filtro,con);
          
           try {
             JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\" + usuario + "\\Documents\\Orçamento.pdf");
             }catch(JRException ex) {
              JOptionPane.showMessageDialog(null,"Feche o arquivo que se encontra aberto!","Relatório",0);
             }
          
           File  pdf = new File("C:\\Users\\" + usuario + "\\Documents\\Orçamento.pdf");
            
             try { 
                Desktop.getDesktop().open(pdf);   
               } catch(Exception ex) {  
                ex.printStackTrace();  
                JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
               }
        
          con.close();
          pdf.deleteOnExit();
    }
}

 }




