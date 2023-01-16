/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import bo.FiltroBO;
import controller.ClienteController;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import regex.ValidaCampos;
import tablemodel.ClienteProjetosTableModel;
import tablemodel.ClienteTableModel;
import util.StringUtil;

/**
 *
 * @author aluno
 */
public class ClienteView extends javax.swing.JFrame {
    
    public Cliente cliente;
    private int idCliente = 0;
    private boolean alterar =false;
    ClienteController clienteController = new ClienteController();
    ClienteTableModel modeloTableClientes;
    ClienteProjetosTableModel modeloTableClientesProjeto;
    
    public ClienteView() {
        initComponents(); 
        clienteController = new ClienteController();
        if (cliente != null){
        preencheCampos(cliente);
        this.cliente = cliente;
        }else {
            jTextFieldNome.requestFocus();
        }
        this.getListaClientes();
        
    }
    public void limpaCampos(){
        jTextFieldNome.setText(StringUtil.EMPTY_FIELD);
        jFormattedTextFieldCPF.setText(StringUtil.EMPTY_FIELD);
        jFormattedTextFieldTelefone.setText(StringUtil.EMPTY_FIELD);
        jTextFieldEndereco.setText(StringUtil.EMPTY_FIELD);
        jTextFieldNome.requestFocus();
    }
    public void getListaClientes(){
        modeloTableClientes = new ClienteTableModel(clienteController.read());
        modeloTableClientesProjeto = new ClienteProjetosTableModel(clienteController.recuperarClientes());
        jTableClientes.setModel(modeloTableClientesProjeto);
    
    }
    private boolean validaCamposClientes() {
        if(!ValidaCampos.validaNome(jTextFieldNome.getText())){
            JOptionPane.showMessageDialog(this, "Nome Inválido!");
            return false;
        }
        if(!ValidaCampos.validaEndereco(jTextFieldEndereco.getText())){
            JOptionPane.showMessageDialog(this, "Endereço Inválido!");
            return false;
        }
        if(!ValidaCampos.validaFone(jFormattedTextFieldTelefone.getText())){
            JOptionPane.showMessageDialog(this, "Telefone Inválido!");
            return false;
        }
        if(!ValidaCampos.validaCpf(jFormattedTextFieldCPF.getText())){
            JOptionPane.showMessageDialog(this, "CPF Inválido!");
            return false;
        }
        return true;
    }
    private void preencheCampos(Cliente cliente){
       this.idCliente = cliente.getIdcliente();
       jTextFieldNome.setText(cliente.getNome());
       jFormattedTextFieldCPF.setText(cliente.getCpf());
       jFormattedTextFieldTelefone.setText(cliente.getTelefone());
       jTextFieldEndereco.setText(cliente.getEndereco());
       
       this.alterar = true;
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
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButtonParticipacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Clientes");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Endereço:");

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCPFActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldTelefoneActionPerformed(evt);
            }
        });

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jButtonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/299068_add_sign_icon.png"))); // NOI18N
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9004715_cross_delete_remove_cancel_icon.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9027543_rotate_refresh_icon.png"))); // NOI18N
        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jButtonParticipacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/6843091_businessman_effective_effective employees_employee_professional_icon (1).png"))); // NOI18N
        jButtonParticipacao.setText("Participaçao");
        jButtonParticipacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParticipacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonParticipacao)
                                .addGap(16, 16, 16))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldTelefone))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel1)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonAtualizar)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonParticipacao))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCPFActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
     if(validaCamposClientes()){
               clienteController.create(jTextFieldNome.getText(),
               jFormattedTextFieldCPF.getText(),
               jFormattedTextFieldTelefone.getText(),
               jTextFieldEndereco.getText());
        
                
                jTextFieldNome.setText(StringUtil.EMPTY_FIELD);
                jFormattedTextFieldCPF.setText(StringUtil.EMPTY_FIELD);
                jFormattedTextFieldTelefone.setText(StringUtil.EMPTY_FIELD);
                jTextFieldEndereco.setText(StringUtil.EMPTY_FIELD);
                this.getListaClientes();
     } 
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.getListaClientes();
    }//GEN-LAST:event_formWindowOpened

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
       if(jTableClientes.getSelectedRow() != -1){
           Cliente cliente = modeloTableClientes.getCliente(jTableClientes.getSelectedRow());
       clienteController.delete(cliente.getIdcliente());
       
       this.getListaClientes();
       
       limpaCampos();
       }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        if(validaCamposClientes()){
        if(jTableClientes.getSelectedRow() != -1){
            Cliente cliente = modeloTableClientes.getCliente(jTableClientes.getSelectedRow());
            clienteController.update(cliente.getIdcliente(),
                    jTextFieldNome.getText(),
                    jFormattedTextFieldCPF.getText(),
                    jFormattedTextFieldTelefone.getText(),
                    jTextFieldEndereco.getText());
            
            this.getListaClientes();
            
            limpaCampos();
        }}
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        if(jTableClientes.getSelectedRow() != -1){
            jTextFieldNome.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 1).toString());
            jFormattedTextFieldCPF.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 2).toString());
            jFormattedTextFieldTelefone.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 3).toString());
            jTextFieldEndereco.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 4).toString());
            
            jButtonExcluir.setEnabled((int)jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 5)== 0);
            jButtonParticipacao.setEnabled((int)jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 5)== 1);
        }
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jFormattedTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldTelefoneActionPerformed

    private void jButtonParticipacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParticipacaoActionPerformed
        ParticipacaoProjetosView frmProjeto = new ParticipacaoProjetosView();
        frmProjeto.setFiltro(new FiltroBO((int)jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0),"cliente"));
        frmProjeto.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButtonParticipacaoActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonParticipacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

   
}
