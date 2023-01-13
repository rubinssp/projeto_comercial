/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.bean.Profissional;
import model.dao.ProfissionalDAO;

/**
 *
 * @author USER
 */
public class ProfissionalController {
      public boolean create(String nome, String cpf, String telefone, String endereco, String regprofissional, String descricao){
        Profissional profissional = new Profissional() {};
        profissional.setNome(nome);
        profissional.setCpf(cpf);
        profissional.setTelefone(telefone);
        profissional.setEndereco(endereco);
        profissional.setRegprofissional(regprofissional);
        profissional.setDescricao(descricao);
       
        
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        return profissionalDAO.create(profissional);
        
    } 
    public ArrayList<Profissional> read() {
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        return profissionalDAO.read();
    }
    public boolean update(int idprofissional,String nome, String cpf, String telefone, String endereco, String regprofissional, String descricao){
        Profissional profissional = new Profissional();
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        
        profissional.setIdprofissional(idprofissional);
        profissional.setNome(nome);
        profissional.setCpf(cpf);
        profissional.setTelefone(telefone);
        profissional.setEndereco(endereco);
        profissional.setRegprofissional(regprofissional);
        profissional.setDescricao(descricao);
        
        
        return profissionalDAO.update(profissional);
    }
    public boolean delete (int idprofissional) {
        Profissional profissional = new Profissional();
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        
        profissional.setIdprofissional(idprofissional);
        
        return profissionalDAO.delete(profissional);   
    }
    public ArrayList<Profissional> getListaProfissionaisporNome(String nome) {
    ProfissionalDAO profissionalDAO = new ProfissionalDAO();
    return profissionalDAO.getListaProfissionaisporNome(nome);
    }
    public ArrayList<Profissional> getListaProfissionaisporCpf(String cpf) {
    ProfissionalDAO profissionalDAO = new ProfissionalDAO();
    return profissionalDAO.getListaProfissionaisporCpf(cpf);
    }
    public ArrayList<Profissional> getListaProfissionaisporRegistroProfissional(String regprofissional) {
    ProfissionalDAO profissionalDAO = new ProfissionalDAO();
    return profissionalDAO.getListaProfissionaisporRegistroProfissional(regprofissional);
    }
}
