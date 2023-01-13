/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Cliente;
import model.bean.Profissional;
import model.bean.Projeto;

/**
 *
 * @author luisf
 */
public class ProjetoDAO {
      public boolean create(Projeto projeto) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO projeto (nome, datainicio, dataconclusao, idprofissional, idcliente) VALUES (?,?,?,?,?) ");
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDatainicio());
            stmt.setString(3, projeto.getDataconclusao());
            stmt.setInt(4, projeto.getProfissional().getIdprofissional());
            stmt.setInt(5, projeto.getCliente().getIdcliente());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (Exception ex) {
            System.out.println("Erro ao salvar: " +  ex);
            return false;
        } finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
public ArrayList<Projeto> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        ArrayList<Projeto> listaProjetos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM view_projetoprofissionalcliente");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setIdprojeto(rs.getInt("idprojeto"));
                projeto.setNome(rs.getString("nome"));
                projeto.setDatainicio(rs.getString("datainicio"));
                projeto.setDataconclusao(rs.getString("dataconclusao"));
                
                Profissional prof = new Profissional();
                prof.setNome(rs.getString("prnome"));
                projeto.setProfissional(prof);
                
                Cliente c = new Cliente();
                c.setNome(rs.getString("cnome"));
                projeto.setCliente(c);
                
                listaProjetos.add(projeto);
                
            }
        } catch( SQLException ex){
            System.out.println("Erro ao ler os projetos");
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaProjetos;
        }

    public boolean update(Projeto projeto) {
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE projeto set nome = ?, datainicio = ?, dataconclusao = ?, idprofissional = ?, idcliente = ? WHERE idprojeto = ?");
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDatainicio());
            stmt.setString(3, projeto.getDataconclusao());
            stmt.setInt(4, projeto.getProfissional().getIdprofissional());
            stmt.setInt(5,projeto.getCliente().getIdcliente());
            stmt.setInt(6,projeto.getIdprojeto());
            
            
            stmt.executeUpdate();
            
            System.out.println("Atualizado com sucesso!");
            return true;
        } catch(SQLException ex) {
            System.out.println("Erro ao atualizar");
            
        } finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        return false;
    }
    public boolean delete (Projeto projeto) {
        
        
        PreparedStatement stmt = null;
        
        try (Connection con = ConnectionFactory.getConnection();) {
            stmt =  con.prepareStatement("DELETE FROM projeto WHERE idprojeto = ?");
            stmt.setInt(1, projeto.getIdprojeto());
            
            stmt.executeUpdate();
            
            System.out.println("Excluido com sucesso!");
            return true;
        
        } catch (SQLException ex) {
            
            System.out.println("Erro ao excluir");
            return false;
        
    }
}
}
