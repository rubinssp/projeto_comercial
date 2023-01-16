/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.bean.Profissional;
import model.bean.ProfissionalProjeto;
import model.bean.Projeto;
import model.dao.ProfissionalProjetoDAO;

/**
 *
 * @author luisf
 */
public class ProfissionalProjetoController {

    public boolean create(double valor, String horastrabalhadas, Profissional profissional, Projeto projeto) {
        ProfissionalProjeto profissionalprojeto = new ProfissionalProjeto();
        profissionalprojeto.setValor(valor);
        profissionalprojeto.setHorastrabalhadas(horastrabalhadas);
        profissionalprojeto.setProfissional(profissional);
        profissionalprojeto.setProjeto(projeto);

        ProfissionalProjetoDAO profissionalprojetoDAO = new ProfissionalProjetoDAO();
        return profissionalprojetoDAO.create(profissionalprojeto);

    }

    public ArrayList<ProfissionalProjeto> getProjetosPorProfissional(int idprofissional) {
        ProfissionalProjetoDAO profissionalprojetoDAO = new ProfissionalProjetoDAO();
        return profissionalprojetoDAO.getProjetoPorProfissional(idprofissional);
    }

    public boolean update(double valor, String horastrabalhadas, Profissional profissional, Projeto projeto) {
        ProfissionalProjeto profissionalprojeto = new ProfissionalProjeto();
        profissionalprojeto.setValor(valor);
        profissionalprojeto.setHorastrabalhadas(horastrabalhadas);
        profissionalprojeto.setProfissional(profissional);
        profissionalprojeto.setProjeto(projeto);

        ProfissionalProjetoDAO profissionalprojetoDAO = new ProfissionalProjetoDAO();
        return profissionalprojetoDAO.update(profissionalprojeto);
    }

    public boolean delete(int idProfissional, int idProjeto) {
        ProfissionalProjeto profissionalprojeto = new ProfissionalProjeto();
        Profissional profissional = new Profissional();
        profissional.setIdprofissional(idProfissional);

        Projeto projeto = new Projeto();
        projeto.setIdprojeto(idProjeto);

        profissionalprojeto.setProfissional(profissional);
        profissionalprojeto.setProjeto(projeto);

        ProfissionalProjetoDAO profissionalprojetoDAO = new ProfissionalProjetoDAO();
        return profissionalprojetoDAO.delete(profissionalprojeto);

    }
}
