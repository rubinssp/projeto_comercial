/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Projeto;

/**
 *
 * @author luisf
 */
public class ProjetoTableModel extends AbstractTableModel{
    private List<Projeto> listaProjetos;
    private String[] colunas = {"Nome", "Data de Inicio", "Data de Conclusao", "Profissional", "Cliente"};
    

    public ProjetoTableModel(){
        
        listaProjetos = new ArrayList<>();
    
    }
    
    public ProjetoTableModel(List<Projeto> projetos){
        this();
        this.listaProjetos.addAll(projetos);
    }    
    @Override
    public int getRowCount() {
        return listaProjetos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Projeto projeto = listaProjetos.get(linha);
        switch (coluna) {
            case 0:
                return projeto.getNome();
            case 1:
                return projeto.getDatainicio();
            case 2:
                return projeto.getDataconclusao();
            case 3:
                return projeto.getProfissional();
            case 4:
                return projeto.getCliente();
            default:
                return "";            
       }
    }

    @Override
    public String getColumnName(int column) {
       return colunas[column];  
    }
    
    public Projeto getProjeto(int linha){
        if(linha >= listaProjetos.size()){
            return null;
        }
        return listaProjetos.get(linha);
    }
}
