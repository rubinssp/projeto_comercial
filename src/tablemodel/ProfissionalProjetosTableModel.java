/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.ProfissionalParticipacaoProjetos;

/**
 *
 * @author luisf
 */
public class ProfissionalProjetosTableModel extends AbstractTableModel {
    
     private List<ProfissionalParticipacaoProjetos> listaProfissionais;
    private String[] colunas = {"#Id", "Nome", "CPF", "Telefone", "Endereço", "Registro Profissional", "Descriçao", "Projetos"};

    public ProfissionalProjetosTableModel() {

        listaProfissionais = new ArrayList<>();
    }

    public ProfissionalProjetosTableModel(List<ProfissionalParticipacaoProjetos> profissionais) {
        this();
        this.listaProfissionais.addAll(profissionais);
    }

    @Override
    public int getRowCount() {
        return listaProfissionais.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ProfissionalParticipacaoProjetos profissional = listaProfissionais.get(linha);
        switch (coluna) {
            case 0:
                return profissional.getIdProfissional();
            case 1:
                return profissional.getNome();
            case 2:
                return profissional.getCpf();
            case 3:
                return profissional.getTelefone();
            case 4:
                return profissional.getEndereco();
            case 5:
                return profissional.getRegProfissional();
            case 6:
                return profissional.getDescricao();
            case 7: 
                return profissional.getTotalProjetos();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public ProfissionalParticipacaoProjetos getProfissional(int linha) {
        if (linha >= listaProfissionais.size()) {
            return null;
        }
        return listaProfissionais.get(linha);
    }
}
