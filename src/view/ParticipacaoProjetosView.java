/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import filtros.FiltroParticipacao;
import controller.ClienteController;
import controller.ProfissionalController;
import controller.ProjetoController;
import java.util.Objects;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Profissional;
import regex.ValidaCampos;
import tablemodel.ProjetoTableModel;
import util.StringUtil;

/**
 *
 * @author aluno
 */
public class ParticipacaoProjetosView extends javax.swing.JFrame {

    ProjetoController projetoController = new ProjetoController();
    ProjetoTableModel modeloTableProjetos;
    FiltroParticipacao filtro;

    public ParticipacaoProjetosView() {

        initComponents();

    }

    public void getListaProfissionais() {
        ProfissionalController profissionalController = new ProfissionalController();

        for (Profissional p : profissionalController.read()) {

            jComboBoxProfissionais.addItem(p);
        }
    }

    public void getListaProjetos() {
        this.modeloTableProjetos = new ProjetoTableModel(projetoController.read());

        jTableProjetos.setModel(modeloTableProjetos);
    }

    public void getListaClientes() {
        ClienteController clienteController = new ClienteController();

        for (Cliente p : clienteController.read()) {

            jComboBoxClientes.addItem(p);
        }
    }

    private boolean validaCamposClientes() {
        if (!ValidaCampos.validaNome(jTextFieldNome.getText())) {
            JOptionPane.showMessageDialog(this, "Nome Inválido!");
            return false;
        }
        if (!ValidaCampos.validaDataInicio(jTextFieldDataInicio.getText())) {
            JOptionPane.showMessageDialog(this, "Endereço Inválido!");
            return false;
        }
        if (!ValidaCampos.validaDataConclusao(jTextFieldDataConclusao.getText())) {
            JOptionPane.showMessageDialog(this, "Telefone Inválido!");
            return false;
        }

        return true;
    }

    public void setFiltro(FiltroParticipacao filtro) {
        this.filtro = filtro;
        modeloTableProjetos = new ProjetoTableModel(projetoController.filtro(this.filtro));

        jTableProjetos.setModel(modeloTableProjetos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProjetos = new javax.swing.JTable();
        jComboBoxProfissionais = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jTextFieldDataInicio = new javax.swing.JFormattedTextField();
        jTextFieldDataConclusao = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Projetos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Projetos");

        jLabel2.setText("Nome:");

        jLabel3.setText("Data de Início:");

        jLabel4.setText("Data de Conclusão:");

        jTextFieldNome.setText(" ");
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jButtonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9027543_rotate_refresh_icon.png"))); // NOI18N
        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9004715_cross_delete_remove_cancel_icon.png"))); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jTableProjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableProjetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProjetosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProjetos);

        jLabel5.setText("Profissional Responsável:");

        jLabel6.setText("Cliente:");

        jComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientesActionPerformed(evt);
            }
        });

        try {
            jTextFieldDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldDataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldDataConclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataConclusaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxProfissionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButtonAtualizar)
                                        .addGap(89, 89, 89)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonRemover, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxProfissionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtualizar)
                    .addComponent(jButtonRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.getListaProfissionais();
        this.getListaClientes();

    }//GEN-LAST:event_formWindowOpened

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        if (jTableProjetos.getSelectedRow() != -1 && Objects.nonNull(jComboBoxProfissionais.getSelectedItem())
                && Objects.nonNull(jComboBoxClientes.getSelectedItem())) {
            Profissional profissional = (Profissional) jComboBoxProfissionais.getSelectedItem();
            Cliente cliente = (Cliente) jComboBoxClientes.getSelectedItem();
            projetoController.update((int) jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(), 0), jTextFieldNome.getText(),
                    jTextFieldDataInicio.getText(), jTextFieldDataConclusao.getText(), profissional, cliente);

            this.getListaProjetos();

            jTextFieldNome.setText(StringUtil.EMPTY_FIELD);
            jTextFieldDataInicio.setText(StringUtil.EMPTY_FIELD);
            jTextFieldDataConclusao.setText(StringUtil.EMPTY_FIELD);
            jComboBoxProfissionais.setSelectedIndex(0);
            jComboBoxClientes.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jTableProjetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProjetosMouseClicked
        if (jTableProjetos.getSelectedRow() != -1) {
            jTextFieldNome.setText((String) jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(), 1));
            jTextFieldDataInicio.setText((String) jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(), 2));
            jTextFieldDataConclusao.setText((String) jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(), 3));
            String profissional = (String) jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(), 4);
            String cliente = (String) jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(), 5);

            for (int i = 0; i < jComboBoxProfissionais.getItemCount(); i++) {
                Profissional p = (Profissional) jComboBoxProfissionais.getItemAt(i);
                if (p.getNome().equals(profissional)) {

                    jComboBoxProfissionais.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < jComboBoxClientes.getItemCount(); i++) {
                Cliente c = (Cliente) jComboBoxClientes.getItemAt(i);
                if (c.getNome().equals(cliente)) {

                    jComboBoxClientes.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_jTableProjetosMouseClicked

    private void jTextFieldDataConclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataConclusaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataConclusaoActionPerformed

    private void jComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClientesActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        if (jTableProjetos.getSelectedRow() != -1) {
            projetoController.delete((int) jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(), 0));

            this.getListaProfissionais();
            this.getListaClientes();
            this.getListaProjetos();

            jTextFieldNome.setText(StringUtil.EMPTY_FIELD);
            jTextFieldDataInicio.setText(StringUtil.EMPTY_FIELD);
            jTextFieldDataConclusao.setText(StringUtil.EMPTY_FIELD);
            jComboBoxProfissionais.setSelectedIndex(0);
            jComboBoxClientes.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um projeto para excluir!");
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(ParticipacaoProjetosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParticipacaoProjetosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParticipacaoProjetosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParticipacaoProjetosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParticipacaoProjetosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JComboBox<Object> jComboBoxClientes;
    private javax.swing.JComboBox<Object> jComboBoxProfissionais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProjetos;
    private javax.swing.JFormattedTextField jTextFieldDataConclusao;
    private javax.swing.JFormattedTextField jTextFieldDataInicio;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
