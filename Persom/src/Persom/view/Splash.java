/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giovani dos Santos
 */
public class Splash extends javax.swing.JFrame {

    private static final long serialVersionUID = 1150967779157360686L;
    
    /**
     * Creates new form Splash
     */
    public Splash() {
        initComponents();
        start();
       
    }
     
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelMensagem = new javax.swing.JLabel();
        jProgressBarCarregar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logoatu.png"))); // NOI18N

        jProgressBarCarregar.setBackground(new java.awt.Color(51, 51, 255));
        jProgressBarCarregar.setForeground(new java.awt.Color(0, 51, 255));
        jProgressBarCarregar.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jProgressBarCarregar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jProgressBarCarregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBarCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        setSize(new java.awt.Dimension(369, 225));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMensagem;
    private javax.swing.JProgressBar jProgressBarCarregar;
    // End of variables declaration//GEN-END:variables

  public void start(){
        new Thread(){
            
         public void run(){
            for(int i = 0; i < 101;i++){
                try {
                    sleep(60);
                    
                    
                    jProgressBarCarregar.setValue(i);
                    
                    if(jProgressBarCarregar.getValue() == 10){
                        jLabelMensagem.setText("Carregando o Banco de Dados....");
                        sleep(1000);
                     }else if(jProgressBarCarregar.getValue() < 60){
                        jLabelMensagem.setText("Carregando o Sistema...");
                      }else if(jProgressBarCarregar.getValue() < 100){
                         jLabelMensagem.setText("Carregamento quase completo...");
                      }else{
                          jLabelMensagem.setText("Carregamento completo!!! O programa será iniciado...");
                         
                          sleep(3000);
                          
                          new TelaPrincipal().setVisible(true);
                          dispose();
                      }
                          
                } catch (InterruptedException ex) {
                    Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         }
       }.start();
      
    } 

    
   
}


    
 
