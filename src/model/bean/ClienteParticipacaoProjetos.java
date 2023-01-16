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
public class ClienteParticipacaoProjetos {

    private int idcliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private boolean existeProjetos;
    private int totalProjetos;

    public ClienteParticipacaoProjetos(ResultSet rs) throws SQLException {
        this.setIdcliente(rs.getInt("idcliente"));
        this.setNome(rs.getString("nome"));
        this.setCpf(rs.getString("cpf"));
        this.setTelefone(rs.getString("telefone"));
        this.setEndereco(rs.getString("endereco"));
        this.setExisteProjetos(rs.getBoolean("existe_projeto"));
        this.setTotalProjetos(rs.getInt("total_projetos"));
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
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

    public void setEndereco(String endereço) {
        this.endereco = endereço;
    }

    public boolean isExisteProjetos() {
        return existeProjetos;
    }

    public void setExisteProjetos(boolean existeProjetos) {
        this.existeProjetos = existeProjetos;
    }

    public int getTotalProjetos() {
        return totalProjetos;
    }

    public void setTotalProjetos(int totalProjetos) {
        this.totalProjetos = totalProjetos;
    }

}
