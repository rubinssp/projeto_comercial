/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Profissional;

/**
 *
 * @author luisf
 */
public class ProfissionalTableModel extends AbstractTableModel {
    
    private List<Profissional> listaProfissionais;
    private String[] colunas = {"Nome", "CPF", "Telefone", "Endereço", "Registro Profissional", "Descriçao"};
    

    public ProfissionalTableModel(){
        
        listaProfissionais = new ArrayList<>();
    
    }
    
    public ProfissionalTableModel(List<Profissional> profissionais){
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
        Profissional profissional = listaProfissionais.get(linha);
        switch (coluna) {
            case 0:
                return profissional.getNome();
            case 1:
                return  profissional.getCpf();
            case 2:
                return profissional.getTelefone();
            case 3:
                return profissional.getEndereco();
            case 4:
                return profissional.getRegprofissional();
            case 5:
                return profissional.getDescricao();
            default:
                return "";            
       }
    }

    @Override
    public String getColumnName(int column) {
       return colunas[column];  
    }
    
    public Profissional getProfissional(int linha){
        if(linha >= listaProfissionais.size()){
            return null;
        }
        return listaProfissionais.get(linha);
    }
    
}
