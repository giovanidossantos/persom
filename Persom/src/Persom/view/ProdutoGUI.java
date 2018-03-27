/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


import model.Conexao;
import model.ModeloTabela;
import model.Movimento;
import model.dao.ProdutoDAO;
import model.Produto;
import model.dao.MovimentoDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author Giovani dos Santos
 */
public class ProdutoGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = 7904393042470960147L;
     
     Produto p = new Produto();
     ProdutoDAO pd = new ProdutoDAO();
     Movimento m = new Movimento();
     MovimentoDAO md = new MovimentoDAO();
     Conexao cone = new Conexao();
     Connection con = null;
     NumberFormat nf = NumberFormat.getCurrencyInstance();
     DecimalFormat df = new DecimalFormat();
     String pesquisa;
     int valor;
     int estoque;
     int quantidade;
    
    public ProdutoGUI() {
        initComponents();
        preencher();
        this.getContentPane().setLayout(new FlowLayout());
        setIcon();
        datahora();
        colorir();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jButtonVerificar = new javax.swing.JButton();
        jButtonMovimento = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxPesquisa = new javax.swing.JComboBox<>();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonPesquisa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFornecedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldEstoqueMini = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPrecounid = new javax.swing.JTextField();
        jComboBoxmedida = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jLabelDataHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom - Tela de Produto                                        ");

        jButtonAlterar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Update.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar informação do produto");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Save.png"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setToolTipText("Salvar cadastro do produto");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
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

        jButtonVerificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Verificar.png"))); // NOI18N
        jButtonVerificar.setText("Verificar");
        jButtonVerificar.setToolTipText("Verificar detalhes do produto");
        jButtonVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerificarActionPerformed(evt);
            }
        });

        jButtonMovimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonMovimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/movi.png"))); // NOI18N
        jButtonMovimento.setText("Movimento");
        jButtonMovimento.setToolTipText("Ir para Tela de Movimento");
        jButtonMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMovimentoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione o que Deseja Pesquisar"));
        jPanel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jComboBoxPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a opção", "Código", "Nome", "Fornecedor", "Modelo" }));
        jComboBoxPesquisa.setFocusable(false);
        jComboBoxPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPesquisaActionPerformed(evt);
            }
        });

        jTextFieldFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButtonPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.setToolTipText("Pesquise o que deseja consultar");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Produto"));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Código");

        jTextFieldCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nome");

        jTextFieldNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Modelo");

        jTextFieldModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Fornecedor");

        jTextFieldFornecedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Estoque Mínimo");

        jTextFieldEstoqueMini.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Preço venda");

        jTextFieldPrecounid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jComboBoxmedida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxmedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "UNID", "M" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEstoqueMini, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPrecounid, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldEstoqueMini, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxmedida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldPrecounid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableProduto);

        jLabelDataHora.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButtonCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButtonVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButtonMovimento)
                .addGap(43, 43, 43)
                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(917, 742));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        try {
        p.setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        p.setDataProduto(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        p.setNome(jTextFieldNome.getText().toUpperCase());
        p.setModelo(jTextFieldModelo.getText().toUpperCase());
        p.setFornecedor(jTextFieldFornecedor.getText().toUpperCase());
        p.setEstoqueMinimo(Integer.parseInt(jTextFieldEstoqueMini.getText()));
        p.setUnidMedida(jComboBoxmedida.getSelectedItem().toString());
        p.setPrecovenda(new BigDecimal(jTextFieldPrecounid.getText()));
 
            
            pd.insert(p);   
        } catch (SQLException p) {
           JOptionPane.showMessageDialog(null,"Erro ao cadastrar informação do produto! ","Cadastro Produto",0);
        } catch (NumberFormatException p){
           JOptionPane.showMessageDialog(null,"Informe apenas pontos e números no campo Preço venda! ","Cadastro Produto",0);
        } 
        limpar();
        preencher();
        
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerificarActionPerformed
            
        int row = jTableProduto.getSelectedRow();

        jTextFieldCodigo.setText(jTableProduto.getValueAt(row,0).toString());
        jTextFieldNome.setText(jTableProduto.getValueAt(row,2).toString());
        jTextFieldModelo.setText(jTableProduto.getValueAt(row,4).toString());
        jTextFieldFornecedor.setText(jTableProduto.getValueAt(row,3).toString());
        jTextFieldEstoqueMini.setText(String.valueOf(jTableProduto.getValueAt(row,5).toString()));
        jComboBoxmedida.setSelectedItem(jTableProduto.getValueAt(row,6));
        jTextFieldPrecounid.setText(jTableProduto.getValueAt(row,7).toString());
    }//GEN-LAST:event_jButtonVerificarActionPerformed

    private void jComboBoxPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPesquisaActionPerformed
         if (jComboBoxPesquisa.getSelectedItem().toString().equals("Código")) {
              pesquisa = "idProduto";
        } else if (jComboBoxPesquisa.getSelectedItem().toString().equals("Nome")) {
              pesquisa = "Nome";
        } else if (jComboBoxPesquisa.getSelectedItem().toString().equals("Fornecedor")) {
              pesquisa = "Fornecedor";
        } else if (jComboBoxPesquisa.getSelectedItem().toString().equals("Modelo")) {
              pesquisa = "Modelo";
        }
    }//GEN-LAST:event_jComboBoxPesquisaActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {
        p.setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        p.setNome(jTextFieldNome.getText().toUpperCase());
        p.setModelo(jTextFieldModelo.getText().toUpperCase());
        p.setFornecedor(jTextFieldFornecedor.getText().toUpperCase());
        p.setEstoqueMinimo(Integer.parseInt(jTextFieldEstoqueMini.getText()));
        p.setUnidMedida(jComboBoxmedida.getSelectedItem().toString().toUpperCase());        
        p.setPrecovenda(new BigDecimal(jTextFieldPrecounid.getText()));
            
         
             pd.update(p);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar informação do produto! ","Alteração de dados",0);
         } catch (NumberFormatException p){
           JOptionPane.showMessageDialog(null,"Informe apenas pontos e números no campo Preço venda! ","Alteração de dados",0);
         } 
         limpar();
         preencher();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMovimentoActionPerformed
        new MovimentoGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMovimentoActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
         try {
             preenchertabela("select * from produto inner join movimento on (produto.idProduto = movimento.idProduto) where tipo_movimento = 'CADASTRO' and produto." + pesquisa + " like '%" + jTextFieldFiltro.getText().toUpperCase() + "%'");
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Erro ao consultar informação! \n Verifique o que deseja consultar! ","Consulta Produto",0);
         }
         jTextFieldFiltro.setText("");
         jComboBoxPesquisa.setSelectedItem("Selecione a opção");
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

  
  
  public void preenchertabela(String sql) throws SQLException{
        
        ArrayList<Object> dados = new ArrayList<>();
        String [] Colunas = new String[]{"Código","Data","Nome","Fornecedor","Modelo","Estoque Mínimo","Unidade de Medida","Preço de venda","Quantidade"};
        DateFormat  d = DateFormat.getDateInstance();
        con = cone.carrega();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
         try{
            rs.first();
         
         do{
         dados.add(new Object[]{rs.getInt("idProduto"),d.format(rs.getDate("Data_Produto")),rs.getString("Nome"),rs.getString("Fornecedor"),rs.getString("Modelo"),
         rs.getInt("Estoque_Minimo"),rs.getString("Unid_Medida"),rs.getBigDecimal("Preco_venda"),rs.getInt("Quantidade")});
         }while(rs.next());
          
         }catch(SQLException ex) {
           }
          con.close();
          st.close();
          rs.close();
             
       
             ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            
             
            jTableProduto.setModel(modelo);
            jTableProduto.getColumnModel().getColumn(0).setResizable(false);
            jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableProduto.getColumnModel().getColumn(1).setResizable(false);
            jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableProduto.getColumnModel().getColumn(2).setResizable(false);
            jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableProduto.getColumnModel().getColumn(3).setResizable(false);
            jTableProduto.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableProduto.getColumnModel().getColumn(4).setResizable(false);
            jTableProduto.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTableProduto.getColumnModel().getColumn(5).setResizable(false);
            jTableProduto.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTableProduto.getColumnModel().getColumn(6).setResizable(false);
            jTableProduto.getColumnModel().getColumn(6).setPreferredWidth(90);
            jTableProduto.getColumnModel().getColumn(7).setResizable(false);
            jTableProduto.getColumnModel().getColumn(7).setPreferredWidth(70);
            jTableProduto.getColumnModel().getColumn(8).setResizable(false);
            jTableProduto.getColumnModel().getColumn(8).setPreferredWidth(70);
             
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
            java.util.logging.Logger.getLogger(ProdutoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProdutoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonMovimento;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonVerificar;
    private javax.swing.JComboBox<Object> jComboBoxPesquisa;
    private javax.swing.JComboBox<Object> jComboBoxmedida;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldEstoqueMini;
    private javax.swing.JTextField jTextFieldFiltro;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPrecounid;
    // End of variables declaration//GEN-END:variables

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
    
        estoque =  Integer.parseInt(table.getValueAt(row,5).toString().toLowerCase());
        quantidade =  Integer.parseInt(table.getValueAt(row,8).toString().toLowerCase());
        
      if (quantidade <= estoque) {
        foreground = Color.WHITE;  
        background = Color.RED;
        
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
       
               TableCellRenderer renderer = new MeuRenderer();  
               jTableProduto.setDefaultRenderer(Object.class, renderer);
                
  }
  
    public void preencher(){
       try {
             preenchertabela("select produto.idProduto,produto.Data_Produto,produto.Nome,produto.Fornecedor,\n" +
                     "produto.Modelo,produto.Estoque_Minimo,produto.Unid_Medida,produto.Preco_venda,movimento.Quantidade\n" +
                     "from produto inner join movimento on (produto.idProduto = movimento.idProduto) where tipo_movimento = \"CADASTRO\";");
         } catch (SQLException ex) {
             Logger.getLogger(ProdutoGUI.class.getName()).log(Level.SEVERE, null, ex);
         } 
    }
    
   public void limpar(){
        jTextFieldCodigo.setText("");
        jTextFieldNome.setText("");
        jTextFieldModelo.setText("");
        jTextFieldFornecedor.setText("");
        jTextFieldEstoqueMini.setText("");
        jTextFieldPrecounid.setText("");
        jComboBoxmedida.setSelectedItem("SELECIONE");
        jTextFieldCodigo.grabFocus();
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
