/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.dao.OrcamentoDAO;
import model.Cliente;
import model.Conexao;
import model.Orcamento;
import model.OrcamentoPK;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;




/**
 *
 * @author Giovani dos Santos
 */
public class OrcamentoGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = -4625709932537296370L;
    
    Orcamento o = new Orcamento();
    OrcamentoDAO od = new OrcamentoDAO();
    Conexao cone = new Conexao();
    Connection con = null;
    DateFormat f = DateFormat.getDateInstance();
    BigDecimal valor = null; 
    BigDecimal valor1 = null;
    String usuario;
     
    
    private OrcamentoGUI() {
        initComponents();
        ordem();
        this.getContentPane().setLayout(new FlowLayout());
        setIcon();
        jTextFieldSerie.grabFocus();
        datahora();
    }
    
     public OrcamentoGUI(Cliente c) {
        this();
        jFormattedTextFieldCPF.setText(c.getCpfCnpj()); 
    }
     
    public OrcamentoGUI(TelaPrincipal t) {
        this();
    }
    
    public OrcamentoGUI(Orcamento o){
        this();
         preencheDados(o);
         jButtonCadastrar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOrdemPrestacao = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonPagamento = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldSerie = new javax.swing.JTextField();
        jTextFieldTipo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaDefeReclamado = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaCausaProvavel = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaDefeEncontrado = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        jButtonImprimir = new javax.swing.JButton();
        jDateChooserOrcamentoPrevis = new com.toedter.calendar.JDateChooser();
        jDateChooserEntregaProd = new com.toedter.calendar.JDateChooser();
        jTextFieldValorReparo = new javax.swing.JTextField();
        jTextFieldSinal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonFisica = new javax.swing.JRadioButton();
        jRadioButtonJuridica = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jLabelDataHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Persom - Tela de Orçamento                                        ");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Ordem de Prestação de Serviço");

        jTextFieldOrdemPrestacao.setEditable(false);
        jTextFieldOrdemPrestacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldOrdemPrestacao.setFocusable(false);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Orçamento previsto para");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Valor do Reparo");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Sinal");

        jButtonCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Save.png"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setToolTipText("Cadastrar um Orçamento");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Update.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar informações do Orçamento");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
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

        jButtonMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Menu.png"))); // NOI18N
        jButtonMenu.setText("Menu");
        jButtonMenu.setToolTipText("Ir para Tela Principal");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButtonConsultar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonConsultar.setText("Consultar");
        jButtonConsultar.setToolTipText("Consultar Orçamento ");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Entrega do Produto para");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico do Produto"));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Nº de Série");

        jTextFieldSerie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextFieldTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("Tipo");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Modelo");

        jTextFieldModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setText("Marca");

        jTextFieldMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setText("Defeito Reclamado");

        jTextAreaDefeReclamado.setColumns(20);
        jTextAreaDefeReclamado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaDefeReclamado.setRows(5);
        jScrollPane5.setViewportView(jTextAreaDefeReclamado);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setText("Causa Provável");

        jTextAreaCausaProvavel.setColumns(20);
        jTextAreaCausaProvavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaCausaProvavel.setRows(5);
        jScrollPane6.setViewportView(jTextAreaCausaProvavel);

        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setText("Defeito Encontrado");

        jTextAreaDefeEncontrado.setColumns(20);
        jTextAreaDefeEncontrado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaDefeEncontrado.setRows(5);
        jScrollPane7.setViewportView(jTextAreaDefeEncontrado);

        jLabel34.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel34.setText("Observações Técnicas");

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaObservacoes.setRows(5);
        jScrollPane8.setViewportView(jTextAreaObservacoes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34)
                        .addGap(128, 128, 128))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32)
                        .addGap(152, 152, 152))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(151, 151, 151)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jScrollPane8)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButtonImprimir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Imprimir.png"))); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.setToolTipText("Imprimir comprovante de Orçamento");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jDateChooserOrcamentoPrevis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jDateChooserEntregaProd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextFieldValorReparo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextFieldSinal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldSinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSinalActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("CPF/CNPJ do Cliente");

        jFormattedTextFieldCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabelDataHora.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserOrcamentoPrevis, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserEntregaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButtonConsultar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldValorReparo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPagamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSinal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonFisica)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonJuridica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldOrdemPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldOrdemPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jRadioButtonFisica)
                    .addComponent(jRadioButtonJuridica)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel27))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldValorReparo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)
                        .addComponent(jTextFieldSinal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooserOrcamentoPrevis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserEntregaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1000, 742));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonJuridicaActionPerformed
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###/####-##")));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null,"Informe o número correto do CNPJ! ","CNPJ",0);
        }
    }//GEN-LAST:event_jRadioButtonJuridicaActionPerformed

    private void jRadioButtonFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFisicaActionPerformed
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null,"Informe o número correto do CPF! ","CPF",0);
        }
    }//GEN-LAST:event_jRadioButtonFisicaActionPerformed

    private void jTextFieldSinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSinalActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
       Relatorio r = new Relatorio();
        try {           
            r.Gerar();
        } catch (JRException ex) {
            Logger.getLogger(OrcamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrcamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        new ConsultaOrcamentoGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagamentoActionPerformed
        o.setOrcamentoPK(new OrcamentoPK());
        o.getOrcamentoPK().setClienteCPFCNPJ(jFormattedTextFieldCPF.getText());
        o.setOrdemPrestacao(Integer.parseInt(jTextFieldOrdemPrestacao.getText()));
        try {
            o.setOrdemPrestacao(Integer.parseInt(jTextFieldOrdemPrestacao.getText()));
            valor = od.selectValor(o);
        } catch (SQLException ex) {
            Logger.getLogger(OrcamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            o.setOrdemPrestacao(Integer.parseInt(jTextFieldOrdemPrestacao.getText()));
            valor1 = od.selectSinal(o);
        } catch (SQLException ex) {
            Logger.getLogger(OrcamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        new PagamentoGUI(o,valor,valor1).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPagamentoActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {
            o.setDataPrevistaOrca(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserOrcamentoPrevis.getDate())));
            o.setDataEntregaProd(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserEntregaProd.getDate())));
            if(jTextFieldValorReparo.getText() != null && !jTextFieldValorReparo.getText().equals("")){
                o.setValorReparo(new BigDecimal(jTextFieldValorReparo.getText()));
            }else
            o.setValorReparo(BigDecimal.ZERO);
            if(jTextFieldSinal.getText() != null && !jTextFieldSinal.getText().equals("")){
                o.setSinal(new BigDecimal(jTextFieldSinal.getText()));
            }else
            o.setSinal(BigDecimal.ZERO);
            o.setIdSerie(Integer.parseInt(jTextFieldSerie.getText().toUpperCase()));
            o.setTipoProduto(jTextFieldTipo.getText().toUpperCase());
            o.setModelo(jTextFieldModelo.getText().toUpperCase());
            o.setMarca(jTextFieldMarca.getText().toUpperCase());
            o.setDefeitoReclamado(jTextAreaDefeReclamado.getText().toUpperCase());
            o.setCausaProvavel(jTextAreaCausaProvavel.getText().toUpperCase());
            o.setDefeitoEncontrado(jTextAreaDefeEncontrado.getText().toUpperCase());
            o.setObservacoesTecnicas(jTextAreaObservacoes.getText().toUpperCase());
            o.setOrcamentoPK(new OrcamentoPK());
            o.getOrcamentoPK().setClienteCPFCNPJ(jFormattedTextFieldCPF.getText());

            od.update(o);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar informação!","Alteração de dados",0);
        } catch (NumberFormatException p){
            JOptionPane.showMessageDialog(null,"Informe apenas ponto e número nos campos Valor do Reparo e Sinal! ","Alteração de dados",0);
        }
        limpar();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        try {
        o.setOrdemPrestacao(Integer.parseInt(jTextFieldOrdemPrestacao.getText()));
        o.setDataOrcamento(new Date(Calendar.getInstance().getTimeInMillis()));
        o.setDataPrevistaOrca(jDateChooserOrcamentoPrevis.getDate());
        if (jDateChooserEntregaProd.getDate() !=null){
            o.setDataEntregaProd(jDateChooserEntregaProd.getDate());
        }else{
            o.setDataEntregaProd(new Date(Calendar.getInstance().getTimeInMillis()));
        }

        if(jTextFieldValorReparo.getText() != null && !jTextFieldValorReparo.getText().equals("")){
            o.setValorReparo(new BigDecimal(jTextFieldValorReparo.getText()));
        }else
        o.setValorReparo(BigDecimal.ZERO);
        if(jTextFieldSinal.getText() != null && !jTextFieldSinal.getText().equals("")){
            o.setSinal(new BigDecimal(jTextFieldSinal.getText()));
        }else
        o.setSinal(BigDecimal.ZERO);
        o.setIdSerie(Integer.parseInt(jTextFieldSerie.getText()));
        o.setTipoProduto(jTextFieldTipo.getText().toUpperCase());
        o.setModelo(jTextFieldModelo.getText().toUpperCase());
        o.setMarca(jTextFieldMarca.getText().toUpperCase());
        o.setDefeitoReclamado(jTextAreaDefeReclamado.getText().toUpperCase());
        o.setCausaProvavel(jTextAreaCausaProvavel.getText().toUpperCase());
        o.setDefeitoEncontrado(jTextAreaDefeEncontrado.getText().toUpperCase());
        o.setObservacoesTecnicas(jTextAreaObservacoes.getText().toUpperCase());
        o.setOrcamentoPK(new OrcamentoPK());
        o.getOrcamentoPK().setClienteCPFCNPJ(jFormattedTextFieldCPF.getText());

        
            od.insert(o);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar informação!","Cadastro Orçamento",0);
        } catch (NumberFormatException p){
            JOptionPane.showMessageDialog(null,"Informe apenas ponto e número nos campos Valor do Reparo e Sinal! ","Cadastro Orçamento",0);
        }
        limpar();
        jTextFieldSerie.grabFocus();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed
      
  
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
            java.util.logging.Logger.getLogger(OrcamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrcamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrcamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrcamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OrcamentoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonPagamento;
    private com.toedter.calendar.JDateChooser jDateChooserEntregaProd;
    private com.toedter.calendar.JDateChooser jDateChooserOrcamentoPrevis;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonFisica;
    private javax.swing.JRadioButton jRadioButtonJuridica;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jTextAreaCausaProvavel;
    private javax.swing.JTextArea jTextAreaDefeEncontrado;
    private javax.swing.JTextArea jTextAreaDefeReclamado;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldOrdemPrestacao;
    private javax.swing.JTextField jTextFieldSerie;
    private javax.swing.JTextField jTextFieldSinal;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldValorReparo;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
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

public void preencheDados(Orcamento o){
         jTextFieldOrdemPrestacao.setText(String.valueOf(o.getOrdemPrestacao()));
         jFormattedTextFieldCPF.setText(o.getOrcamentoPK().getClienteCPFCNPJ());
         jTextFieldSerie.setText(String.valueOf(o.getIdSerie()));
         jTextFieldTipo.setText(o.getTipoProduto().toString());
         jTextFieldModelo.setText(o.getModelo());
         jTextFieldMarca.setText(o.getMarca());
         jTextAreaDefeReclamado.setText(o.getDefeitoReclamado());
         jTextAreaCausaProvavel.setText(o.getCausaProvavel());
         jTextAreaDefeEncontrado.setText(o.getDefeitoEncontrado());
         jTextAreaObservacoes.setText(o.getObservacoesTecnicas());
         jDateChooserOrcamentoPrevis.setDate(o.getDataPrevistaOrca());
         jDateChooserEntregaProd.setDate(o.getDataEntregaProd());
         if(o.getValorReparo().compareTo(BigDecimal.ZERO) == 0){
             jTextFieldValorReparo.setText("");
            }else
                jTextFieldValorReparo.setText(String.valueOf(o.getValorReparo()));
         if(o.getSinal().compareTo(BigDecimal.ZERO) == 0){
            jTextFieldSinal.setText(""); 
            }else
                jTextFieldSinal.setText(String.valueOf(o.getSinal()));

     }
     
     public void ordem(){
        try {
            jTextFieldOrdemPrestacao.setText(od.selectOrdemPrestacao());
        } catch (SQLException ex) {
            Logger.getLogger(OrcamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
     
     public void limpar(){
        jDateChooserOrcamentoPrevis.setDate(null);
        jDateChooserEntregaProd.setDate(null);
        jTextFieldValorReparo.setText("");
        jTextFieldSinal.setText("");
        jTextFieldSerie.setText("");
        jTextFieldTipo.setText("");
        jTextFieldModelo.setText("");
        jTextFieldMarca.setText("");
        jTextAreaDefeReclamado.setText("");
        jTextAreaCausaProvavel.setText("");
        jTextAreaDefeEncontrado.setText("");
        jTextAreaObservacoes.setText("");
        jTextFieldSerie.grabFocus(); 
     }
     
     public class Relatorio{
    public void Gerar() throws JRException, SQLException{
       usuario = System.getProperty("user.name");

        con = cone.carrega();
          
         Map<String,Object> filtro = new HashMap<>();
         
         filtro.put("orcamento",Integer.parseInt(jTextFieldOrdemPrestacao.getText()));
         
         InputStream inputStream = getClass().getResourceAsStream("/report/RelatorioOrcamento.jasper");
         
             JasperPrint print = JasperFillManager.fillReport(inputStream,filtro,con);
         
            try {
             JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\" + usuario + "\\Documents\\RelatórioOrçamento.pdf");
             }catch(JRException ex) {
              JOptionPane.showMessageDialog(null,"Feche o arquivo que se encontra aberto!","Relatório",0);
             }
          
        File  pdf = new File("C:\\Users\\" + usuario + "\\Documents\\RelatórioOrçamento.pdf");
            
             try { 
                Desktop.getDesktop().open(pdf);   
               } catch(Exception ex) {  
                ex.printStackTrace();  
                JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
               }
        
             con.close();
             limpar();
             pdf.deleteOnExit();
       
    }
  }
   
}
