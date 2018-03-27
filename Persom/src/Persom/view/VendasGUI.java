/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.dao.ProdutoDAO;
import model.dao.VendasDAO;
import model.Cliente;
import model.Conexao;
import model.ModeloTabela;
import model.Movimento;
import model.MovimentoPK;
import model.Produto;
import model.Vendas;
import model.VendasPK;
import model.dao.MovimentoDAO;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Giovani dos Santos
 */
public class VendasGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = 2824533492050441984L;
    
    Vendas v = new Vendas();
    VendasDAO vd = new VendasDAO();
    Produto p = new Produto();
    ProdutoDAO pd = new ProdutoDAO();
    Movimento m = new Movimento();
    MovimentoDAO md = new MovimentoDAO();
    Conexao cone = new Conexao();
    Connection con = null;
    String movimento = "VENDAS";
    NumberFormat f = NumberFormat.getCurrencyInstance();
    int valor;
    int valor2;
    int estoque;
    int valor1;
   
    
    private VendasGUI() {
        initComponents();
        ordem();
        this.getContentPane().setLayout(new FlowLayout());
        setIcon();
        datahora();
    }

     public VendasGUI(Cliente c) {
      this();
      
      jFormattedTextFieldCPF.setText(c.getCpfCnpj());
    }
     
    public VendasGUI(TelaPrincipal t){
     this();
    } 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldNomeProd = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldFornecedor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldPrecounid = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldGarantia = new javax.swing.JTextField();
        jButtonPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonPagamento = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jTextFieldOrdemServico = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonFisica = new javax.swing.JRadioButton();
        jRadioButtonJuridica = new javax.swing.JRadioButton();
        jLabelDataHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom - Tela de Vendas                                       ");
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Ordem de Serviço");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Código");

        jTextFieldCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Nome");

        jTextFieldNomeProd.setEditable(false);
        jTextFieldNomeProd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Modelo");

        jTextFieldModelo.setEditable(false);
        jTextFieldModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Fornecedor");

        jTextFieldFornecedor.setEditable(false);
        jTextFieldFornecedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Quantidade");

        jTextFieldQuantidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Preço_unid");

        jTextFieldPrecounid.setEditable(false);
        jTextFieldPrecounid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldPrecounid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecounidActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Garantia");

        jTextFieldGarantia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonPesquisa.setToolTipText("Pesquise o Código do Produto desejado");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPrecounid, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFieldGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jTextFieldNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(jButtonPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldPrecounid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
        );

        jButtonCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Save.png"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setToolTipText("Cadastrar Venda");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonPagamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pagamento.png"))); // NOI18N
        jButtonPagamento.setText("Pagamento");
        jButtonPagamento.setToolTipText("Ir para Tela de Pagamento");
        jButtonPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagamentoActionPerformed(evt);
            }
        });

        jButtonConsultar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonConsultar.setText("Consultar");
        jButtonConsultar.setToolTipText("Consultar Vendas");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
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

        jTextFieldOrdemServico.setEditable(false);
        jTextFieldOrdemServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButtonExcluir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Excluir.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setToolTipText("Excluir um produto da Venda");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("CPF/CNPJ do Cliente");

        jFormattedTextFieldCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Selecione o tipo de Cliente que deseja cadastrar:");

        buttonGroup1.add(jRadioButtonFisica);
        jRadioButtonFisica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRadioButtonFisica.setText("Pessoa Física");
        jRadioButtonFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFisicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonJuridica);
        jRadioButtonJuridica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRadioButtonJuridica.setText("Pessoa Jurídica");
        jRadioButtonJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonJuridicaActionPerformed(evt);
            }
        });

        jLabelDataHora.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonFisica)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonJuridica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButtonCadastrar)
                .addGap(84, 84, 84)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPagamento)
                .addGap(66, 66, 66)
                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jRadioButtonFisica)
                    .addComponent(jRadioButtonJuridica)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
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

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
       
        BigDecimal total = new BigDecimal(jTextFieldPrecounid.getText()).multiply(new BigDecimal(jTextFieldQuantidade.getText()));
        v.setOrdemServico(Integer.parseInt(jTextFieldOrdemServico.getText()));
        v.setDataVenda(new Date(Calendar.getInstance().getTimeInMillis()));
        v.setNomeProduto(jTextFieldNomeProd.getText());
        v.setModeloProduto(jTextFieldModelo.getText());
        v.setMarcaProduto(jTextFieldFornecedor.getText());
        v.setPrecoUnit(new BigDecimal(jTextFieldPrecounid.getText()));
        v.setQuantidadeProduto(Integer.parseInt(jTextFieldQuantidade.getText()));
        v.setValorTotal(total);
        v.setGarantia(jTextFieldGarantia.getText());
        v.setVendasPK(new VendasPK());
        v.getVendasPK().setClienteCPFCNPJ(jFormattedTextFieldCPF.getText());
        v.getVendasPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        try {
            vd.insert(v);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao cadastrar venda! ","Cadastro Venda",0);
        }
       
        m.setMovimentoPK(new MovimentoPK());
        m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        m.setDataMovimento(new Date(Calendar.getInstance().getTimeInMillis()));
        m.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
        m.setTipoMovimento(movimento); 
        m.setPrecocompra(0.00);
        try {
            md.insert(m);
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            m.getMovimentoPK().setIdMovimento(Integer.parseInt(jTextFieldCodigo.getText()));
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
         preencher();
       
        
          try {
            m.getMovimentoPK().setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
            valor2 =  md.selectEstoque(m);
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                      
        try {
            p.setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
            estoque = pd.selectEstoque(p);
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        jTextFieldCodigo.setText("");
        jTextFieldNomeProd.setText("");
        jTextFieldModelo.setText("");
        jTextFieldFornecedor.setText("");
        jTextFieldPrecounid.setText("");
        jTextFieldQuantidade.setText("");
        jTextFieldGarantia.setText("");
        jTextFieldCodigo.grabFocus();
            
            if(valor2 <= estoque){
                JOptionPane.showMessageDialog(null,"Quantidade do Produto " + v.getVendasPK().getIdProduto() + " no estoque chegou a " + valor2 + ".\n Sendo que o Estoque Mínimo deste Produto é " + estoque + ".","Controle Estoque",2);
            }
        
       
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        p.setIdProduto(Integer.parseInt(jTextFieldCodigo.getText()));
        try {
            pd.selectProduto(p);
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar produto! \n Verifique o código do produto!","Consulta Produto",0);
        }
        jTextFieldNomeProd.setText(p.getNome());
        jTextFieldModelo.setText(p.getModelo());
        jTextFieldFornecedor.setText(p.getFornecedor());
        jTextFieldPrecounid.setText(String.valueOf(p.getPrecovenda()));
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButtonPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagamentoActionPerformed
         BigDecimal soma = null;
        try {
           soma =  vd.select(v);
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        v.getVendasPK().setClienteCPFCNPJ(jFormattedTextFieldCPF.getText());
        v.setOrdemServico(Integer.parseInt(jTextFieldOrdemServico.getText()));
        new PagamentoGUI(soma,v).setVisible(true);
        this.dispose();
         
    }//GEN-LAST:event_jButtonPagamentoActionPerformed

    private void jRadioButtonFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFisicaActionPerformed
       
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null,"Informe o número correto do CPF! ","CPF",0);
        }

    }//GEN-LAST:event_jRadioButtonFisicaActionPerformed

    private void jRadioButtonJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonJuridicaActionPerformed
        
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###/####-##")));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null,"Informe o número correto do CNPJ! ","CNPJ",0);
        }
    }//GEN-LAST:event_jRadioButtonJuridicaActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        new ConsultaVendasGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
         int x = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir este produto da venda ?","Exclusão Produto",JOptionPane.YES_NO_OPTION,2);
         
      if(x == 0){
          
        m.setMovimentoPK(new MovimentoPK());
        m.getMovimentoPK().setIdProduto(Integer.parseInt(jTableVendas.getValueAt(jTableVendas.getSelectedRow(),1).toString()));  
        v.setOrdemServico(Integer.parseInt(jTextFieldOrdemServico.getText()));
        
             try {
                 md.delete(m,v);
             } catch (SQLException ex) {
                 Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
           
         v.setOrdemServico(Integer.parseInt(jTableVendas.getValueAt(jTableVendas.getSelectedRow(),0).toString()));
         v.setVendasPK(new VendasPK());
         v.getVendasPK().setIdProduto(Integer.parseInt(jTableVendas.getValueAt(jTableVendas.getSelectedRow(),1).toString()));
        try {
            vd.delete(v);
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            m.getMovimentoPK().setIdProduto(Integer.parseInt(jTableVendas.getValueAt(jTableVendas.getSelectedRow(),1).toString()));
            valor1 = md.selectCompra(m);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        m.setMovimentoPK(new MovimentoPK());
        m.getMovimentoPK().setIdProduto(Integer.parseInt(jTableVendas.getValueAt(jTableVendas.getSelectedRow(),1).toString()));  
            try {
                md.updateCompra(m);  
            } catch (SQLException ex1) {
                Logger.getLogger(MovimentoGUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
        
      
        preencher();
        
        
      }else{
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldPrecounidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecounidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecounidActionPerformed

     public void preenchertabela(String sql) throws SQLException{
        
        ArrayList<Object> dados = new ArrayList<>();
        String [] Colunas = new String[]{"Ordem","Código","Nome do Produto","Modelo","Marca","Valor Unitário","Qtd","UnidMedida","Valor Total",};
        con = cone.carrega();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
         try{
            rs.first();
         
         do{
            dados.add(new Object[]{rs.getInt("Ordem_Servico"),rs.getInt("idProduto"),rs.getString("Nome"),rs.getString("Modelo"),rs.getString("Fornecedor"),f.format(rs.getBigDecimal("Preco_venda")),rs.getInt("Quantidade_Produto"),rs.getString("Unid_Medida"),f.format(rs.getBigDecimal("Valor_Total"))});
         }while(rs.next());
         
        }catch(SQLException ex) {
       }
       
       con.close();
       st.close();
       rs.close();
       
       ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            jTableVendas.setModel(modelo);
            jTableVendas.getColumnModel().getColumn(0).setResizable(false);
            jTableVendas.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableVendas.getColumnModel().getColumn(1).setResizable(false);
            jTableVendas.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTableVendas.getColumnModel().getColumn(2).setResizable(false);
            jTableVendas.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableVendas.getColumnModel().getColumn(3).setResizable(false);
            jTableVendas.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTableVendas.getColumnModel().getColumn(4).setResizable(false);
            jTableVendas.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTableVendas.getColumnModel().getColumn(5).setResizable(false);
            jTableVendas.getColumnModel().getColumn(5).setPreferredWidth(30);
            jTableVendas.getColumnModel().getColumn(6).setResizable(false);
            jTableVendas.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTableVendas.getColumnModel().getColumn(7).setResizable(false);
            jTableVendas.getColumnModel().getColumn(7).setPreferredWidth(10);
            jTableVendas.getColumnModel().getColumn(8).setResizable(false);
            jTableVendas.getColumnModel().getColumn(8).setPreferredWidth(50);
            
       
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
            java.util.logging.Logger.getLogger(VendasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonPagamento;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonFisica;
    private javax.swing.JRadioButton jRadioButtonJuridica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldGarantia;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldNomeProd;
    private javax.swing.JTextField jTextFieldOrdemServico;
    private javax.swing.JTextField jTextFieldPrecounid;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }
    
    public void ordem(){
       try {
            jTextFieldOrdemServico.setText(vd.selectOrdemServico());
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
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

public void preencher(){
        try {
            preenchertabela("select vendas.Ordem_Servico,vendas.idProduto,produto.Nome,produto.Modelo,produto.Fornecedor,produto.Preco_venda,vendas.Quantidade_Produto,produto.Unid_Medida,vendas.Valor_Total\n" +
                    "from vendas inner join produto on(vendas.idProduto = produto.idProduto)where Ordem_Servico =" + Integer.parseInt(jTextFieldOrdemServico.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(VendasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
}

  
    }

   

