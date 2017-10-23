/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import controle.Dao;
import controle.MovimentacaoDaoBinario;
import controle.UsuarioDaoBinario;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author HP
 */
public class GerenciarPerfil extends javax.swing.JFrame {
    private Usuario usu;
    private MovimentacaoDaoBinario movimentacaodao;
    private Dao usuariodao;
    /**
     * Creates new form GerenciarPerfil
     */
    public GerenciarPerfil(Usuario teste) {
        usu = teste;
        initComponents();
        
        Email.setText(usu.getEmail());
        Email.setEditable(false);
        usuariodao = new UsuarioDaoBinario();
        
        
        movimentacaodao = new MovimentacaoDaoBinario();
        
    }
    
    public GerenciarPerfil() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Nome = new javax.swing.JTextField();
        Sexo = new javax.swing.JComboBox<>();
        Salvar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Limpar = new javax.swing.JButton();
        Data = new com.toedter.calendar.JDateChooser();
        Senha1 = new javax.swing.JPasswordField();
        Senha2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("E-mail");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Nascimento");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Sexo");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Senha");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Confirma Senha");

        Email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Nome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        Sexo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        Salvar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        Excluir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        Limpar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Limpar.setText("Limpar formulario");
        Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparActionPerformed(evt);
            }
        });

        Data.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        Senha1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        Senha2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Salvar)
                        .addGap(18, 18, 18)
                        .addComponent(Excluir)
                        .addGap(18, 18, 18)
                        .addComponent(Limpar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(Senha2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Email)
                                        .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Senha1)
                                        .addComponent(Sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGap(18, 18, 18)
                            .addComponent(jButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Senha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Senha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salvar)
                    .addComponent(Excluir)
                    .addComponent(Limpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            
            Usuario usuario = (Usuario) usuariodao.buscar(Email.getText());
            if(usuario == null){
                
            }else{
                Email.setText(usuario.getEmail());
                Nome.setText(usuario.getNome());
                LocalDate ld = usuario.getNascimento();
                Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
                Date date = Date.from(instant);
                Data.setDate(date);
                if(usuario.getSexo().equals("Masculino")){
                    Sexo.setSelectedIndex(0);
                }else{
                    Sexo.setSelectedIndex(1);
                }
                Senha1.setText("");
                Senha2.setText("");
            }
        } catch (IOException ex) {
            Logger.getLogger(GerenciarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        // TODO add your handling code here:
        String senha1 = new String(Senha1.getPassword());
        String senha2 = new String(Senha2.getPassword());
        Date d = Data.getDate();
        Instant instant = Instant.ofEpochMilli(d.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        
        if(senha1.equals(senha2)){
            if(Sexo.getSelectedIndex() == 0){
                Usuario u = new Usuario(Email.getText(), Nome.getText(), localDate , "Masculino" , senha1);
            try {
                usuariodao.atualizar(u);
                TelaDeLogin login = new TelaDeLogin();
                login.setVisible(true);
                dispose();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }catch (SQLException ex) {
                Logger.getLogger(GerenciarPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                Usuario u = new Usuario(Email.getText(), Nome.getText(), localDate ,"Feminino" , senha1);
                try {
                    usuariodao.atualizar(u);
                    TelaDeLogin login = new TelaDeLogin();
                    login.setVisible(true);
                    dispose();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }catch (SQLException ex) {
                    Logger.getLogger(GerenciarPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else{
            
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private void LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparActionPerformed
        // TODO add your handling code here:
        
        Nome.setText("");
        Data.setDate(null);
        Sexo.setSelectedIndex(0);
        Senha1.setText("");
        Senha2.setText("");
    }//GEN-LAST:event_LimparActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        // TODO add your handling code here:
        
        String senha1 = new String(Senha1.getPassword());
        String senha2 = new String(Senha2.getPassword());
        Date d = Data.getDate();
        Instant instant = Instant.ofEpochMilli(d.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        
        if(senha1.equals(senha2)){
            if(Sexo.getSelectedIndex() == 0){
                Usuario u = new Usuario(Email.getText(), Nome.getText(), localDate , "Masculino" , senha1);
                try {
                    movimentacaodao.deletar(usu.getEmail());
                    usuariodao.deletar(u);
                    TelaDeLogin login = new TelaDeLogin();
                    login.setVisible(true);
                    dispose();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }catch (SQLException ex) {
                    Logger.getLogger(GerenciarPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                Usuario u = new Usuario(Email.getText(), Nome.getText(), localDate ,"Feminino" , senha1);
                try {
                    movimentacaodao.deletar(Email.getText());
                    usuariodao.deletar(u);
                    TelaDeLogin login = new TelaDeLogin();
                    login.setVisible(true);
                    dispose();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }catch (SQLException ex) {
                    Logger.getLogger(GerenciarPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else{
            
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(GerenciarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Data;
    private javax.swing.JTextField Email;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Limpar;
    private javax.swing.JTextField Nome;
    private javax.swing.JButton Salvar;
    private javax.swing.JPasswordField Senha1;
    private javax.swing.JPasswordField Senha2;
    private javax.swing.JComboBox<String> Sexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
