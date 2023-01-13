/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.bean.Pessoa;
import model.dao.PessoaDAO;

/**
 *
 * @author aluno
 */
public class PessoaController {
     public boolean create(String nome, String cpf, String telefone, String endereco){
        Pessoa pessoa = new Pessoa() {};
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setTelefone(telefone);
        pessoa.setEndereco(endereco);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        return pessoaDAO.create(pessoa);
        
    }
      public ArrayList<Pessoa> read() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        return pessoaDAO.read();
    }
    public void update(int idpessoa, String nome, String cpf, String telefone, String endereco){
        Pessoa pessoa = new Pessoa() {};
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        pessoa.setIdpessoa(idpessoa);
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setTelefone(telefone);
        pessoa.setEndereco(endereco);
        
        pessoaDAO.update(pessoa);
    }
    public void delete (int idpessoa) {
        Pessoa pessoa = new Pessoa(){};
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        pessoa.setIdpessoa(idpessoa);
        
        pessoaDAO.delete(pessoa);   
    }
}
