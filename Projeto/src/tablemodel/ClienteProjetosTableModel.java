/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.ClienteParticipacaoProjetos;

/**
 *
 * @author luisf
 */
public class ClienteProjetosTableModel extends AbstractTableModel {
    private List<ClienteParticipacaoProjetos> listaClientes;
    private String[] colunas = {"#Id", "Nome", "CPF", "Telefone", "Endereço", "Projetos"};
    

    public ClienteProjetosTableModel(){
        
        listaClientes = new ArrayList<>();
    
    }
    
    public ClienteProjetosTableModel(List<ClienteParticipacaoProjetos> clientes){
        this();
        this.listaClientes.addAll(clientes);
    }    
    @Override
    public int getRowCount() {
        return listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ClienteParticipacaoProjetos cliente = listaClientes.get(linha);
        switch (coluna) {
            case 0:
                return cliente.getIdcliente();
            case 1:
                return cliente.getNome();
            case 2:
                return cliente.getCpf();
            case 3:
                return cliente.getTelefone();
            case 4:
                return cliente.getEndereco();
            case 5:
                return cliente.getTotalProjetos();
            case 6:
                return cliente;
            default:
                return "";            
       }
    }

    @Override
    public String getColumnName(int column) {
       return colunas[column];  
    }
    
    public ClienteParticipacaoProjetos getCliente(int linha){
        if(linha >= listaClientes.size()){
            return null;
        }
        return listaClientes.get(linha);
    }
}
