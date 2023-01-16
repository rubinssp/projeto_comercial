/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author luisf
 */
public class ProfissionalProjeto {
    private double valor;
    private String horastrabalhadas;
    private Profissional profissional;
    private Projeto projeto;

    public ProfissionalProjeto() {
    }
   

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHorastrabalhadas() {
        return horastrabalhadas;
    }

    public void setHorastrabalhadas(String horastrabalhadas) {
        this.horastrabalhadas = horastrabalhadas;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }


    
}
