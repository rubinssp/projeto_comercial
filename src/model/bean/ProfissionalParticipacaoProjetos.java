/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luisf
 */
public class ProfissionalParticipacaoProjetos {
    
    private int idProfissional;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String regProfissional;
    private String descricao;
    private int totalProjetos;

    public ProfissionalParticipacaoProjetos(ResultSet rs) throws SQLException {
        
        this.idProfissional = rs.getInt("idprofissional");
        this.nome = rs.getString("nome");
        this.cpf = rs.getString("cpf");
        this.telefone = rs.getString("telefone");
        this.endereco = rs.getString("endereco");
        this.regProfissional = rs.getString("regprofissional");
        this.descricao = rs.getString("descricao");
        this.totalProjetos = rs.getInt("count_projetos");
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRegProfissional() {
        return regProfissional;
    }

    public void setRegProfissional(String regProfissional) {
        this.regProfissional = regProfissional;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTotalProjetos() {
        return totalProjetos;
    }

    public void setTotalProjetos(int totalProjetos) {
        this.totalProjetos = totalProjetos;
    }
}
