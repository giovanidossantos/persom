/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Conexao;
import model.ModeloTabela;
import model.Pagamento;
import model.dao.MovimentoDAO;
import model.dao.PagamentoDAO;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class FinanceiroGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = -3832199597160577504L;
    
    PagamentoDAO PD = new PagamentoDAO();
    MovimentoDAO md = new MovimentoDAO();
    Conexao cone = new Conexao();
    Pagamento P = new Pagamento();
    NumberFormat f = NumberFormat.getCurrencyInstance();
    DateFormat d = DateFormat.getDateInstance();
    BigDecimal valor;
    BigDecimal entrada;
    BigDecimal saldoanterior;
    BigDecimal saida;
    String usuario;
    BigDecimal saldoatual;
    BigDecimal subtracao;
    Connection con = null;
    File pdf;
   
   
    public FinanceiroGUI() {
        initComponents();
        entrada();
        saldoanterior();
        this.getContentPane().setLayout(new FlowLayout());
        setIcon();
        datahora();
        
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonGerarRelatorio = new javax.swing.JButton();
        jDateChooserDataInicial = new com.toedter.calendar.JDateChooser();
        jDateChooserDataFinal = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldSaldoAnterior = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldEntrada = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldSaida = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldSaldoAtual = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFinanceiro = new javax.swing.JTable();
        jButtonMenu = new javax.swing.JButton();
        jLabelDataHora = new javax.swing.JLabel();
        jButtonTabela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom - Tela de Consulta Financeira");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Informe a Data da Pesquisa");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Data Inicial");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Data Final");

        jButtonGerarRelatorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/GerarRelatório.png"))); // NOI18N
        jButtonGerarRelatorio.setText("Gerar Relatório");
        jButtonGerarRelatorio.setToolTipText("Relatório do dia que deseja");
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });

        jDateChooserDataInicial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jDateChooserDataFinal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(61, 61, 61)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(125, 125, 125)))
                .addComponent(jButtonGerarRelatorio)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimentação Caixa"));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Saldo Anterior");

        jTextFieldSaldoAnterior.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Entrada");

        jTextFieldEntrada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEntradaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Saída");

        jTextFieldSaida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Saldo Atual");

        jTextFieldSaldoAtual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSaldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSaldoAtual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldSaldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableFinanceiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableFinanceiro);

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

        jButtonTabela.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/tabela.png"))); // NOI18N
        jButtonTabela.setText("Carregar Tabela");
        jButtonTabela.setToolTipText("Verificar informações da tabela");
        jButtonTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonTabela)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed
       try {
            new Relatorio().Gerar();
        } catch (JRException ex) {
            Logger.getLogger(FinanceiroGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FinanceiroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

    private void jTextFieldEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEntradaActionPerformed

    private void jButtonTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTabelaActionPerformed
      try {        
            preenchertabela("select * from pagamento where Data = curdate()");
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Não existe registro na data de hoje","Consulta de informação",0);	
        } 
    }//GEN-LAST:event_jButtonTabelaActionPerformed

    public void preenchertabela(String sql) throws SQLException{
        ArrayList<Object> dados = new ArrayList<>();
        String [] Colunas = new String[]{"Data","Ordem","TipoOperação","Valor Total","Valor Recebido","Troco","Cliente"};
        
        con = cone.carrega();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        try{
            rs.first();
           
           do{
              dados.add(new Object[]{d.format(rs.getDate("Data")),rs.getInt("OrdemPagamento"),rs.getString("Tipo_Operacao"),f.format(rs.getBigDecimal("Valor_Total")),f.format(rs.getBigDecimal("Valor_Recebido")),f.format(rs.getBigDecimal("Troco")),rs.getString("Cliente_CPF_CNPJ")});
           }while(rs.next());                
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não existe registro na data de hoje","Consulta de informação",0);
        }
        
        con.close();
        st.close();
        rs.close();
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTableFinanceiro.setModel(modelo);
        jTableFinanceiro.getColumnModel().getColumn(0).setResizable(false);
        jTableFinanceiro.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableFinanceiro.getColumnModel().getColumn(1).setResizable(false);
        jTableFinanceiro.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableFinanceiro.getColumnModel().getColumn(2).setResizable(false);
        jTableFinanceiro.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTableFinanceiro.getColumnModel().getColumn(3).setResizable(false);
        jTableFinanceiro.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTableFinanceiro.getColumnModel().getColumn(4).setResizable(false);
        jTableFinanceiro.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTableFinanceiro.getColumnModel().getColumn(5).setResizable(false);
        jTableFinanceiro.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTableFinanceiro.getColumnModel().getColumn(6).setResizable(false);
        jTableFinanceiro.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            java.util.logging.Logger.getLogger(FinanceiroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinanceiroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinanceiroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinanceiroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FinanceiroGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonTabela;
    private com.toedter.calendar.JDateChooser jDateChooserDataFinal;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicial;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFinanceiro;
    private javax.swing.JTextField jTextFieldEntrada;
    private javax.swing.JTextField jTextFieldSaida;
    private javax.swing.JTextField jTextFieldSaldoAnterior;
    private javax.swing.JTextField jTextFieldSaldoAtual;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }
    
      public void entrada(){
        try {
         valor = PD.selectSaldoAtual();
         } catch (SQLException ex) {
            Logger.getLogger(FinanceiroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
           entrada = md.selectSaida();
        } catch (SQLException ex) {
            Logger.getLogger(FinanceiroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(valor == null && entrada == null){
         jTextFieldEntrada.setText("R$ 0,00");
         jTextFieldSaida.setText("R$ 0,00");
         jTextFieldSaldoAtual.setText("R$ 0,00");
           }else if(valor == null){
         saldoatual = entrada;
         valor = BigDecimal.ZERO;
         jTextFieldSaldoAtual.setText(String.valueOf(f.format(saldoatual)));
         jTextFieldEntrada.setText("R$ 0,00");
         jTextFieldSaida.setText(String.valueOf(f.format(entrada)));
             }else if(entrada == null){
            saldoatual = valor;
            entrada = BigDecimal.ZERO;
            jTextFieldSaldoAtual.setText(String.valueOf(f.format(saldoatual)));
            jTextFieldEntrada.setText(String.valueOf(f.format(valor)));
            jTextFieldSaida.setText("R$ 0,00");
            } else{
            saldoatual = valor.subtract(entrada);
            jTextFieldSaldoAtual.setText(String.valueOf(f.format(saldoatual)));
            jTextFieldEntrada.setText(String.valueOf(f.format(valor)));
            jTextFieldSaida.setText(String.valueOf(f.format(entrada)));
            }
    }
   
    
    public void saldoanterior(){
        try {
            saldoanterior = PD.selectSaldoAnterior();
        } catch (SQLException ex) {
            Logger.getLogger(FinanceiroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
             saida = md.selectSaldoAnterior();
        } catch (SQLException ex) {
            Logger.getLogger(FinanceiroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         if(saldoanterior == null && saida == null){
          jTextFieldSaldoAnterior.setText("R$ 0,00");
            }else if(saldoanterior == null){
             subtracao = saida;
             saldoanterior = BigDecimal.ZERO;
             jTextFieldSaldoAnterior.setText(String.valueOf(f.format(subtracao)));
               }else if(saida == null){
               subtracao = saldoanterior;
               saida = BigDecimal.ZERO;
               jTextFieldSaldoAnterior.setText(String.valueOf(f.format(subtracao)));
                  }else{
                   subtracao = saldoanterior.subtract(saida);
                   jTextFieldSaldoAnterior.setText(String.valueOf(f.format(subtracao)));
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
    public void Gerar() throws JRException, SQLException{
         usuario = System.getProperty("user.name");
      
        con = cone.carrega();
         
         Map<String,Object> filtro = new HashMap<>();
         
         filtro.put("datainicial",java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserDataInicial.getDate())));
         filtro.put("datafinal", java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserDataFinal.getDate())));
         
          InputStream inputStream = getClass().getResourceAsStream("/report/RelatorioFinanceiro.jasper");    
           
          JasperPrint print = JasperFillManager.fillReport(inputStream,filtro,con);
          
           try {
             JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\" + usuario + "\\Documents\\Financeiro.pdf");
             }catch(JRException ex) {
              JOptionPane.showMessageDialog(null,"Feche o arquivo que se encontra aberto!","Relatório",0);
             }
          
             pdf = new File("C:\\Users\\" + usuario + "\\Documents\\Financeiro.pdf");
            
             try { 
                Desktop.getDesktop().open(pdf);   
               } catch(Exception ex) {  
                ex.printStackTrace();  
                JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
               }
        
          con.close();
          jDateChooserDataFinal.setDate(null);
          jDateChooserDataInicial.setDate(null);
          pdf.deleteOnExit();
    }
  }
}
