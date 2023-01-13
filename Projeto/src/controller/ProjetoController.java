/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.bean.Profissional;
import model.bean.Projeto;
import model.dao.ProjetoDAO;

/**
 *
 * @author luisf
 */
public class ProjetoController {
     public boolean create(String nome, String datainicio, String dataconclusao, Profissional profissional, Cliente cliente){
        Projeto projeto = new Projeto() {};
        projeto.setNome(nome);
        projeto.setDatainicio(datainicio);
        projeto.setDataconclusao(dataconclusao);
        projeto.setProfissional(profissional);
        projeto.setCliente(cliente);
        
        ProjetoDAO projetoDAO = new ProjetoDAO();
        return projetoDAO.create(projeto);
                
     }
  public ArrayList<Projeto> read() {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        return projetoDAO.read();
     
}
  public boolean update(int idprojeto, String nome, String datainicio, String dataconclusao, Profissional profissional, Cliente cliente){
        Projeto projeto = new Projeto();
        ProjetoDAO projetoDAO = new ProjetoDAO();
        
        projeto.setIdprojeto(idprojeto);
        projeto.setNome(nome);
        projeto.setDatainicio(datainicio);
        projeto.setDataconclusao(dataconclusao);
        projeto.setProfissional(profissional);
        projeto.setCliente(cliente);
        
        
        
        return projetoDAO.update(projeto);
    }
    public boolean delete (int idprojeto) {
        Projeto projeto = new Projeto();
        ProjetoDAO projetoDAO = new ProjetoDAO();
        
        projeto.setIdprojeto(idprojeto);
        
        return projetoDAO.delete(projeto);   
    }
    
}
