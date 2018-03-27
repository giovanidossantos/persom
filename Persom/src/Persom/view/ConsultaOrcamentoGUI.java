/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Conexao;
import model.ModeloTabela;
import model.Orcamento;
import model.OrcamentoPK;
import model.dao.OrcamentoDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Giovani dos Santos
 */
public class ConsultaOrcamentoGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = -3913931529706051951L;
    
    Orcamento o = new Orcamento();
    OrcamentoDAO od = new OrcamentoDAO();
    Conexao cone = new Conexao();
    Connection con = null;
    String pesquisa;
    String dataprevista;
    String dataentrega;
    Calendar c = Calendar.getInstance();
    java.util.Date date = c.getTime();
    DateFormat  d = DateFormat.getDateInstance();
    
    public ConsultaOrcamentoGUI() {
        initComponents();
        preencher();
        this.getContentPane().setLayout(new FlowLayout());
        colorir();
        setIcon();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxPesquisa = new javax.swing.JComboBox<>();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonVerificarDetalhes = new javax.swing.JButton();
        jButtonPesquisa = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOrcamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom -  Tela de Consulta de Orçamento");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Opções de pesquisa");

        jComboBoxPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a opção", "Ordem de Prestação", "Nº de Série", "Tipo de Produto", "Marca do Produto", "CPF/CNPJ do Cliente" }));
        jComboBoxPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPesquisaActionPerformed(evt);
            }
        });

        jTextFieldFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButtonVerificarDetalhes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonVerificarDetalhes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Verificar.png"))); // NOI18N
        jButtonVerificarDetalhes.setText("Verificar Detalhes");
        jButtonVerificarDetalhes.setToolTipText("Verificar Detalhes da Informação");
        jButtonVerificarDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerificarDetalhesActionPerformed(evt);
            }
        });

        jButtonPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.setToolTipText("Pesquise  o que deseja consultar");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Excluir.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setToolTipText("Excluir um cadastro do Orçamento");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
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

        jTableOrcamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableOrcamento);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248)
                .addComponent(jButtonVerificarDetalhes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerificarDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

        if (jComboBoxPesquisa.getSelectedItem().toString().equals("Nº de Série")) {
            pesquisa = "idSerie";
        } else if (jComboBoxPesquisa.getSelectedItem().toString().equals("Tipo de Produto")) {
            pesquisa = "Tipo_Produto";
        } else if (jComboBoxPesquisa.getSelectedItem().toString().equals("Marca do Produto")) {
            pesquisa = "Marca";
        } else if (jComboBoxPesquisa.getSelectedItem().toString().equals("CPF/CNPJ do Cliente")) {
            pesquisa = "Cliente_CPF_CNPJ";
        }else if (jComboBoxPesquisa.getSelectedItem().toString().equals("Ordem de Prestação")) {
            pesquisa = "Ordem_Prestacao";
        }
    }//GEN-LAST:event_jComboBoxPesquisaActionPerformed

    private void jButtonVerificarDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerificarDetalhesActionPerformed

        int row = jTableOrcamento.getSelectedRow();

        o.setOrcamentoPK(new OrcamentoPK());
        o.getOrcamentoPK().setIdOrcamento(Integer.parseInt(jTableOrcamento.getValueAt(row,0).toString()));
        try {
            od.select(o);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao verificar detalhes da informação! \n Selecione a linha que deseja pesquisar!","Detalhes do Orçamento",0);
        }

        new OrcamentoGUI(o).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVerificarDetalhesActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        try {
            preenchertabela("SELECT * FROM Orcamento WHERE " + pesquisa + " like '%" + jTextFieldFiltro.getText().toUpperCase() + "%'");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cosultar informação! \n Verifique o que deseja pesquisar!","Consulta de Orçamento",0);
        }
        jComboBoxPesquisa.setSelectedItem("Selecione a opção");
        jTextFieldFiltro.setText("");
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int x = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir esta informação ?","Exclusão de Orçamento",JOptionPane.YES_NO_OPTION,2);

        if(x == 0){
            int row = jTableOrcamento.getSelectedRow();

            o.setOrcamentoPK(new OrcamentoPK());
            o.getOrcamentoPK().setIdOrcamento(Integer.parseInt(jTableOrcamento.getValueAt(row,0).toString()));
            try {
                od.delete(o);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaOrcamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            preencher();
        }else{
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

     public void preenchertabela(String sql) throws SQLException{
        DateFormat f = DateFormat.getDateInstance();
        ArrayList<Object> dados = new ArrayList<>();
        
        String [] Colunas = new String[]{"id","Ordem","Cliente","DataOrcamento","DataPrevista","DataEntrega",
   "Série","Tipo de Produto","Modelo","Marca","DefeitoReclamado","CausaProvável","DefeitoEncontrado","Observações","ValorReparo","Sinal"};
          
       con = cone.carrega();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
         try{
            rs.first();
         do{
            dados.add(new Object[]{rs.getInt("idOrcamento"),rs.getInt("Ordem_Prestacao"),rs.getString("Cliente_CPF_CNPJ"),f.format(rs.getDate("Data_Orcamento")),f.format(rs.getDate("Data_Prevista_Orca")),f.format(rs.getDate("Data_Entrega_Prod")),
           rs.getInt("idSerie"),rs.getString("Tipo_Produto"),rs.getString("Modelo"),rs.getString("Marca"),rs.getString("Defeito_Reclamado"),rs.getString("Causa_Provavel"),rs.getString("Defeito_Encontrado"),
           rs.getString("Observacoes_Tecnicas"),rs.getBigDecimal("Valor_Reparo"),rs.getBigDecimal("Sinal")});
         }while(rs.next());
          } catch (SQLException ex) {
        } 
                
       con.close();
       st.close();
       rs.close();
     
        
        
            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            jTableOrcamento.setModel(modelo);
            jTableOrcamento.getColumnModel().getColumn(0).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTableOrcamento.getColumnModel().getColumn(1).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableOrcamento.getColumnModel().getColumn(2).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTableOrcamento.getColumnModel().getColumn(3).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(4).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTableOrcamento.getColumnModel().getColumn(5).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTableOrcamento.getColumnModel().getColumn(6).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(7).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(8).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(9).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(9).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(10).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(10).setPreferredWidth(120);
            jTableOrcamento.getColumnModel().getColumn(11).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(11).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(12).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(12).setPreferredWidth(120);
            jTableOrcamento.getColumnModel().getColumn(13).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(13).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(14).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(14).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(15).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(15).setPreferredWidth(100);
            jTableOrcamento.getTableHeader().setReorderingAllowed(false);
            jTableOrcamento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jTableOrcamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(ConsultaOrcamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrcamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrcamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrcamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaOrcamentoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonVerificarDetalhes;
    private javax.swing.JComboBox<Object> jComboBoxPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableOrcamento;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration//GEN-END:variables

    private void preencher() {
        try {        
            preenchertabela("select * from Orcamento");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOrcamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }
     
  public class MeuRenderer implements TableCellRenderer{
    
    DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();  
  
  public Component getTableCellRendererComponent(JTable table, Object value,  
      boolean isSelected, boolean hasFocus, int row, int column) {  
  
    Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(  
        table, value, isSelected, hasFocus, row, column);  
  
    ((JLabel) renderer).setOpaque(true);  
  
    Color foreground, background;  
    
        dataprevista =  table.getValueAt(row,4).toString().toLowerCase();
        dataentrega =  table.getValueAt(row,5).toString().toLowerCase();
        
      if (dataprevista.equals(d.format(date))) {
        foreground = Color.WHITE;  
        background = Color.RED;  
  
      }else if (dataentrega.equals(d.format(date))) {
        foreground = Color.BLUE;  
        background = Color.YELLOW;  
  
      } else {  
        foreground = Color.BLACK;  
        background = Color.WHITE;  
  
      }  
  
    renderer.setForeground(foreground);  
    renderer.setBackground(background);  
    return renderer;  
  
  }  
    
}
  
  
  public void colorir(){
       
                MeuRenderer renderer = new MeuRenderer();  
                jTableOrcamento.setDefaultRenderer(Object.class, (TableCellRenderer) renderer);
                
  }
}
   

   
