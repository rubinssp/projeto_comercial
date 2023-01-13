/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Cliente;

/**
 *
 * @author luisf
 */
public class ClienteTableModel extends AbstractTableModel {
    private List<Cliente> listaClientes;
    private String[] colunas = {"Nome", "CPF", "Telefone", "Endereço"};
    

    public ClienteTableModel(){
        
        listaClientes = new ArrayList<>();
    
    }
    
    public ClienteTableModel(List<Cliente> clientes){
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
        Cliente cliente = listaClientes.get(linha);
        switch (coluna) {
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getCpf();
            case 2:
                return cliente.getTelefone();
            case 3:
                return cliente.getEndereco();
            default:
                return "";            
       }
    }

    @Override
    public String getColumnName(int column) {
       return colunas[column];  
    }
    
    public Cliente getCliente(int linha){
        if(linha >= listaClientes.size()){
            return null;
        }
        return listaClientes.get(linha);
    }
}
