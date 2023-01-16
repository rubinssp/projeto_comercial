/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.bean.Cliente;
import model.bean.ClienteParticipacaoProjetos;
import model.bean.Pessoa;
import model.dao.ClienteDAO;
import model.dao.ClienteParticipacaoProjetosDAO;


/**
 *
 * @author USER
 */
public class ClienteController {
    public boolean create(String nome, String cpf, String telefone, String endereco){
        Cliente cliente = new Cliente() {};
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.create(cliente);
        
        
    } 
    public ArrayList<Cliente> read() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.read();
    }
    
    public List<ClienteParticipacaoProjetos> recuperarClientes(){
        ClienteParticipacaoProjetosDAO cppDAO = new ClienteParticipacaoProjetosDAO();
        return cppDAO.carregarClientes();
    }
            
    public boolean update(int idcliente, String nome, String cpf, String telefone, String endereco){
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        cliente.setIdcliente(idcliente);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        
        
        
        return clienteDAO.update(cliente);
    }
    public boolean delete (int idcliente) {
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        cliente.setIdcliente(idcliente);
        
        return clienteDAO.delete(cliente);   
    }
    
}
