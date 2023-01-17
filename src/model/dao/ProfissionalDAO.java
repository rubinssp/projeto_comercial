/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import filtros.FiltroConsulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Profissional;

/**
 *
 * @author USER
 */
public class ProfissionalDAO {

    public boolean create(Profissional profissional) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO profissional (nome, cpf, telefone, endereco, regprofissional, descricao) VALUES (?,?,?,?,?,?) ");
            stmt.setString(1, profissional.getNome());
            stmt.setString(2, profissional.getCpf());
            stmt.setString(3, profissional.getTelefone());
            stmt.setString(4, profissional.getEndereco());
            stmt.setString(5, profissional.getRegprofissional());
            stmt.setString(6, profissional.getDescricao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao salvar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Profissional> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Profissional> listaProfissionais = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM profissional ORDER by idprofissional");
            rs = stmt.executeQuery();

            while (rs.next()) {

                listaProfissionais.add(new Profissional(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao ler os profissionais");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaProfissionais;
    }

    public boolean update(Profissional profissional) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE profissional set nome = ?, cpf = ?, telefone = ?, endereco = ?, regprofissional = ?, descricao = ? WHERE idprofissional = ?");
            stmt.setString(1, profissional.getNome());
            stmt.setString(2, profissional.getCpf());
            stmt.setString(3, profissional.getTelefone());
            stmt.setString(4, profissional.getEndereco());
            stmt.setString(5, profissional.getRegprofissional());
            stmt.setString(6, profissional.getDescricao());
            stmt.setInt(7, profissional.getIdprofissional());

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    public boolean delete(Profissional profissional) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM profissional WHERE idprofissional = ?");
            stmt.setInt(1, profissional.getIdprofissional());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir");

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;

    }

    public List<Profissional> rodarFiltro(FiltroConsulta filtro) {

        List<Profissional> profissionais = new ArrayList();
        String sql = construirQueryFiltroConsulta(filtro);

        try ( Connection con = ConnectionFactory.getConnection();  PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setString(1, "%" + filtro.getText() + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Profissional profissional = new Profissional(rs);

                profissionais.add(profissional);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler os clientes");
            ex.printStackTrace();
        }
        return profissionais;
    }

    private String construirQueryFiltroConsulta(FiltroConsulta filtro) {

        StringBuilder sql = new StringBuilder("SELECT * from PROFISSIONAL P ");
        sql.append(" WHERE UPPER(");
        switch (filtro.getTipo()) {
            case CPF:
                
                sql.append("P.CPF");
                break;
            case NOME:

                sql.append("P.NOME");
                break;
            case REGISTRO:

                sql.append("P.REGPROFISSIONAL");
                break;
        }
        
        sql.append(") LIKE UPPER(?)");

        return sql.toString();
    }
}
