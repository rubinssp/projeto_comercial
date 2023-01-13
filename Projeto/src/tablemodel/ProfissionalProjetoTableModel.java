package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Profissional;
import model.bean.ProfissionalProjeto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luisf
 */
public class ProfissionalProjetoTableModel extends AbstractTableModel{
    private List<ProfissionalProjeto> listaProfissionalProjetos;
    private String[] colunas = {"Valor", "Horas Trabalhadas", "Profissional", "Projeto"};
    

    public ProfissionalProjetoTableModel(){
        
        listaProfissionalProjetos = new ArrayList<>();
    
    }
    
    public ProfissionalProjetoTableModel(List<ProfissionalProjeto> profissionalprojetos){
        this();
        this.listaProfissionalProjetos.addAll(profissionalprojetos);
    }    
    @Override
    public int getRowCount() {
        return listaProfissionalProjetos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ProfissionalProjeto profissionalprojeto = listaProfissionalProjetos.get(linha);
        switch (coluna) {
            case 0:
                return profissionalprojeto.getValor();
            case 1:
                return  profissionalprojeto.getHorastrabalhadas();
            case 2:
                return profissionalprojeto.getProfissional();
            case 3:
                return profissionalprojeto.getProjeto();
            default:
                return "";            
       }
    }

    @Override
    public String getColumnName(int column) {
       return colunas[column];  
    }
    
    public ProfissionalProjeto getProfissionalProjeto(int linha){
        if(linha >= listaProfissionalProjetos.size()){
            return null;
        }
        return listaProfissionalProjetos.get(linha);
    }
    
}
