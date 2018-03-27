/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.dao.EnderecoDAO;
import model.dao.ClienteDAO;
import model.dao.TelefoneDAO;
import model.*;
import java.awt.FlowLayout;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Giovani dos Santos
 */
public class ClienteGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = -2773222622445767318L;

    Cliente c = new Cliente();
    Endereco e = new Endereco();
    Telefone t = new Telefone();
    ClienteDAO cd = new ClienteDAO();
    EnderecoDAO ed = new EnderecoDAO();
    TelefoneDAO td = new TelefoneDAO();
    Conexao cone = new Conexao();
    String pessoa;
    Connection con = null;

    public ClienteGUI() {
        initComponents();
        preencher();
        this.getContentPane().setLayout(new FlowLayout());
        setIcon();
        datahora();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelCPF = new javax.swing.JLabel();
        jRadioButtonFisica = new javax.swing.JRadioButton();
        jRadioButtonJuridica = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldEstado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxOperadora = new javax.swing.JComboBox<>();
        jFormattedTextFieldResidencial = new javax.swing.JFormattedTextField();
        jFormattedTextFieldComercial = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCelular = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCEP = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonPesquisa = new javax.swing.JButton();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jTextFieldInscricaoMunic = new javax.swing.JTextField();
        jTextFieldInscricaoEstad = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonOrcamento = new javax.swing.JButton();
        jButtonVendas = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonPesquisa1 = new javax.swing.JButton();
        jLabelDataHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persom -  Tela de Cliente");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro do Cliente"));

        jLabelNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelNome.setText("Nome/RazãoSocial");

        jTextFieldNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabelCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelCPF.setText("CPF/CNPJ");

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

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Inscrição Municipal");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Inscrição Estadual");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Endereço");

        jTextFieldEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Bairro");

        jTextFieldBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("CEP");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Cidade");

        jTextFieldCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Estado");

        jTextFieldEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Telefone Residencial");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Telefone Comercial");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Celular");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Email");

        jTextFieldEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Operadora");

        jComboBoxOperadora.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NENHUM", "OI", "CLARO", "VIVO", "TIM", "NEXTEL" }));
        jComboBoxOperadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOperadoraActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldResidencial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldResidencial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            jFormattedTextFieldComercial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldComercial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            jFormattedTextFieldCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            jFormattedTextFieldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Selecione o tipo de Cliente que deseja cadastrar:");

        jButtonPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.setToolTipText("Pesquise o CPF/CNPJ que deseja");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        jFormattedTextFieldCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextFieldInscricaoMunic.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextFieldInscricaoEstad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldInscricaoMunic, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldInscricaoEstad, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel8)
                                .addGap(9, 9, 9)
                                .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jRadioButtonFisica)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabelCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonJuridica)))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButtonFisica)
                    .addComponent(jRadioButtonJuridica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelCPF)
                    .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldInscricaoMunic, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldInscricaoEstad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jFormattedTextFieldResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jFormattedTextFieldComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jComboBoxOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Save.png"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setToolTipText("Salvar informação");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Update.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar informação");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonOrcamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Orçamento.png"))); // NOI18N
        jButtonOrcamento.setText("Orçamento");
        jButtonOrcamento.setToolTipText("Ir para Tela de Orçamento");
        jButtonOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrcamentoActionPerformed(evt);
            }
        });

        jButtonVendas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Vendas.png"))); // NOI18N
        jButtonVendas.setText("Vendas");
        jButtonVendas.setToolTipText("Ir para Tela de Vendas ");
        jButtonVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendasActionPerformed(evt);
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

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableCliente);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Pesquise pelo nome:");

        jTextFieldFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButtonPesquisa1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPesquisa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Pesquisar.png"))); // NOI18N
        jButtonPesquisa1.setText("Pesquisar");
        jButtonPesquisa1.setToolTipText("Pesquise o nome que deseja");
        jButtonPesquisa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisa1ActionPerformed(evt);
            }
        });

        jLabelDataHora.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButtonCadastrar)
                .addGap(81, 81, 81)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOrcamento)
                .addGap(73, 73, 73)
                .addComponent(jButtonVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1021, 766));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed

        c.setNomeRazao(jTextFieldNome.getText().toUpperCase());
        c.setCpfCnpj(jFormattedTextFieldCPF.getText());
        c.setTipoPessoa(pessoa);
        c.setInscricaoMunicipal(jTextFieldInscricaoMunic.getText());
        c.setInscricaoEstadual(jTextFieldInscricaoEstad.getText());
        c.setEmail(jTextFieldEmail.getText().toUpperCase());
        try {
            cd.insert(c);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar informação do cliente! ", "Cadastro de Cliente", 0);
        }

        e.setNomeendereco(jTextFieldEndereco.getText().toUpperCase());
        e.setBairro(jTextFieldBairro.getText().toUpperCase());
        e.setCep(jFormattedTextFieldCEP.getText());
        e.setCidade(jTextFieldCidade.getText().toUpperCase());
        e.setEstado(jTextFieldEstado.getText().toUpperCase());
        e.setCliente(c);
        c.setEnderecoCollection(new ArrayList<Endereco>());
        c.getEnderecoCollection().add(e);

        try {
            ed.insert(e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar endereço do cliente! ", "Cadastro de Endereço", 0);
        }

        t.setTelefoneResidencial(jFormattedTextFieldResidencial.getText());
        t.setTelefoneComercial(jFormattedTextFieldComercial.getText());
        t.setCelular(jFormattedTextFieldCelular.getText());
        t.setOperadora(jComboBoxOperadora.getSelectedItem().toString());
        t.setCliente(c);
        c.setTelefoneCollection(new ArrayList<Telefone>());
        c.getTelefoneCollection().add(t);

        try {
            td.insert(t);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar telefone do cliente! ", "Cadastro de Telefone", 0);
        }

        limpar();
        preencher();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jRadioButtonFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFisicaActionPerformed
        jLabelNome.setText("Nome");
        jLabelCPF.setText("CPF");
        pessoa = "PESSOA FÍSICA";
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Informe o número correto do CPF! ", "CPF", 0);
        }

    }//GEN-LAST:event_jRadioButtonFisicaActionPerformed

    private void jRadioButtonJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonJuridicaActionPerformed
        jLabelNome.setText("Razão Social");
        jLabelCPF.setText("CNPJ");
        pessoa = "PESSOA JURÍDICA";
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###/####-##")));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Informe o número correto do CNPJ! ", "CNPJ", 0);
        }
    }//GEN-LAST:event_jRadioButtonJuridicaActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed

        c.setCpfCnpj(jFormattedTextFieldCPF.getText());

        try {
            cd.select(c);
            jButtonCadastrar.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar CPF/CNPJ! \n Verifique o número do CPF!", "Consulta de Cliente", 0);
        }

        jTextFieldNome.setText(c.getNomeRazao());
        ;
        jTextFieldInscricaoMunic.setText(c.getInscricaoMunicipal());
        jTextFieldInscricaoEstad.setText(c.getInscricaoEstadual());
        jTextFieldEmail.setText(c.getEmail());
        if (c.getTipoPessoa().equals("PESSOA FÍSICA")) {
            jRadioButtonFisica.setSelected(true);
        } else {
            jRadioButtonJuridica.setSelected(true);
        }

        e.setCliente(c);

        try {
            ed.select(e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar endereço do cliente! ", "Consulta de Endereço", 0);
        }

        jTextFieldEndereco.setText(e.getNomeendereco());
        jTextFieldBairro.setText(e.getBairro());
        jFormattedTextFieldCEP.setText(e.getCep());
        jTextFieldCidade.setText(e.getCidade());
        jTextFieldEstado.setText(e.getEstado());

        t.setCliente(c);

        try {
            td.select(t);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar telefone do cliente! ", "Consulta de Telefone", 0);
        }
        jFormattedTextFieldResidencial.setText(t.getTelefoneResidencial());
        jFormattedTextFieldComercial.setText(t.getTelefoneComercial());
        jFormattedTextFieldCelular.setText(t.getCelular());
        jComboBoxOperadora.setSelectedItem(t.getOperadora());


    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jComboBoxOperadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOperadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOperadoraActionPerformed

    private void jButtonOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrcamentoActionPerformed
        c.setCpfCnpj(jFormattedTextFieldCPF.getText());
        new OrcamentoGUI(c).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonOrcamentoActionPerformed

    private void jButtonVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendasActionPerformed
        c.setCpfCnpj(jFormattedTextFieldCPF.getText());
        new VendasGUI(c).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVendasActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        c.setNomeRazao(jTextFieldNome.getText().toUpperCase());
        c.setCpfCnpj(jFormattedTextFieldCPF.getText());
        c.setTipoPessoa(pessoa);
        c.setInscricaoMunicipal(jTextFieldInscricaoMunic.getText());
        c.setInscricaoEstadual(jTextFieldInscricaoEstad.getText());
        c.setEmail(jTextFieldEmail.getText().toUpperCase());
        try {
            cd.update(c);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar informação do cliente! ", "Alteração de dados", 0);
        }
        e.setNomeendereco(jTextFieldEndereco.getText().toUpperCase());
        e.setBairro(jTextFieldBairro.getText().toUpperCase());
        e.setCep(jFormattedTextFieldCEP.getText());
        e.setCidade(jTextFieldCidade.getText().toUpperCase());
        e.setEstado(jTextFieldEstado.getText().toUpperCase());
        e.setCliente(c);
        c.setEnderecoCollection(new ArrayList<Endereco>());
        c.getEnderecoCollection().add(e);
        try {
            ed.update(e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar endereço do cliente! ", "Alteração de dados", 0);
        }
        t.setTelefoneResidencial(jFormattedTextFieldResidencial.getText());
        t.setTelefoneComercial(jFormattedTextFieldComercial.getText());
        t.setCelular(jFormattedTextFieldCelular.getText());
        t.setOperadora(jComboBoxOperadora.getSelectedItem().toString().toUpperCase());
        t.setCliente(c);
        c.setTelefoneCollection(new ArrayList<Telefone>());
        c.getTelefoneCollection().add(t);
        try {
            td.update(t);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar telefone do cliente! ", "Alteração de dados", 0);
        }

        limpar();
        preencher();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisa1ActionPerformed
        try {
            preenchertabela("SELECT * FROM Cliente WHERE Nome_Razao like '%" + jTextFieldFiltro.getText().toUpperCase() + "%'");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar informação do cliente! \n Verifique o nome do cliente! ", "Consulta de Cliente", 0);
        }

    }//GEN-LAST:event_jButtonPesquisa1ActionPerformed

    public void preenchertabela(String sql) throws SQLException {
        ArrayList<Object> dados = new ArrayList<>();
        String[] Colunas = new String[]{"CPF/CNPJ do Cliente", "Nome/Razão Social do Cliente", "Tipo de Pessoa", "Inscrição Municipal", "Inscrição Estadual", "Email"};
        con = cone.carrega();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        try {
            rs.first();

            do {
                dados.add(new Object[]{rs.getString("CPF_CNPJ"), rs.getString("Nome_Razao"), rs.getString("Tipo_Pessoa"), rs.getString("Inscricao_Municipal"), rs.getString("Inscricao_Estadual"), rs.getString("Email")});
            } while (rs.next());

        } catch (SQLException ex) {
        }

        con.close();
        st.close();
        rs.close();

        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTableCliente.setModel(modelo);
        jTableCliente.getColumnModel().getColumn(0).setResizable(false);
        jTableCliente.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableCliente.getColumnModel().getColumn(1).setResizable(false);
        jTableCliente.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTableCliente.getColumnModel().getColumn(2).setResizable(false);
        jTableCliente.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTableCliente.getColumnModel().getColumn(3).setResizable(false);
        jTableCliente.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTableCliente.getColumnModel().getColumn(4).setResizable(false);
        jTableCliente.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTableCliente.getColumnModel().getColumn(5).setResizable(false);
        jTableCliente.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTableCliente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonOrcamento;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonPesquisa1;
    private javax.swing.JButton jButtonVendas;
    private javax.swing.JComboBox<Object> jComboBoxOperadora;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldCelular;
    private javax.swing.JFormattedTextField jFormattedTextFieldComercial;
    private javax.swing.JFormattedTextField jFormattedTextFieldResidencial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonFisica;
    private javax.swing.JRadioButton jRadioButtonJuridica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldFiltro;
    private javax.swing.JTextField jTextFieldInscricaoEstad;
    private javax.swing.JTextField jTextFieldInscricaoMunic;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagem/altofalante.png")).getImage());
    }

    public void limpar() {
        jTextFieldInscricaoMunic.setText("");
        jTextFieldInscricaoEstad.setText("");
        jTextFieldEndereco.setText("");
        jTextFieldBairro.setText("");
        jFormattedTextFieldCEP.setText("");
        jTextFieldCidade.setText("");
        jTextFieldEstado.setText("");
        jTextFieldEmail.setText("");
        jFormattedTextFieldResidencial.setText("");
        jFormattedTextFieldComercial.setText("");
        jFormattedTextFieldCelular.setText("");
        jComboBoxOperadora.setSelectedItem("NENHUM");
        jRadioButtonFisica.setSelected(false);
        jRadioButtonJuridica.setSelected(false);
    }

    public void preencher() {
        try {
            preenchertabela("SELECT * FROM Cliente order by CPF_CNPJ");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void datahora() {
        Thread threadRelogio = new Thread() {
            public void run() {
                rodaRelogio();
            }
        };
        threadRelogio.start();
    }

    public void rodaRelogio() {
        try {
            while (true) {
                Calendar c = Calendar.getInstance();
                java.util.Date date = c.getTime();
                DateFormat d = DateFormat.getDateTimeInstance();
                jLabelDataHora.setText(String.valueOf(d.format(date)));
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
        }
    }
}
