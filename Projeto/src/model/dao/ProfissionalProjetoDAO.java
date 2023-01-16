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
import model.bean.Profissional;
import model.bean.ProfissionalProjeto;
import model.bean.Projeto;

/**
 *
 * @author Aluno
 */
public class ProfissionalProjetoDAO {
     private Connection con = null;
    
    public ProfissionalProjetoDAO() {
        con = ConnectionFactory.getConnection();
    
    }
    public boolean create(ProfissionalProjeto profissionalprojeto) {
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO profissionaisprojeto"
                +" (valor, horastrabalhadas, idprofissional, idprojeto)"
                +"VALUES (?,?,?,?,)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, profissionalprojeto.getValor());
            stmt.setString(2, profissionalprojeto.getHorastrabalhadas());
            stmt.setInt(3, profissionalprojeto.getProfissional().getIdprofissional());
            stmt.setInt(4, profissionalprojeto.getProjeto().getIdprojeto());

            stmt.executeUpdate();
            
            return true;
           
        } catch (Exception ex) {
            System.out.println("Erro ao salvar: " +  ex);
            return false;
        } finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public boolean update(ProfissionalProjeto profissionalprojeto) {
        PreparedStatement stmt = null;
        
        String sql = "UPDATE profissionaisprojeto SET valor = ?, horastrabalhadas = ?,"
                +" WHERE idprofissional = ? and idprojeto = ?";
               
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, profissionalprojeto.getValor());
            stmt.setString(2, profissionalprojeto.getHorastrabalhadas());
            stmt.setInt(3, profissionalprojeto.getProfissional().getIdprofissional());
            stmt.setInt(4, profissionalprojeto.getProjeto().getIdprojeto());

            stmt.executeUpdate();
            
            return true;
           
        } catch (Exception ex) {
            System.out.println("Erro ao salvar: " +  ex);
            return false;
        } finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public boolean delete (ProfissionalProjeto profissionalprojeto) {
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM profissionaisprojeto WHERE idprofissional = ? and idprojeto = ?";

        try {
            stmt =  con.prepareStatement(sql);
            stmt.setInt(1, profissionalprojeto.getProfissional().getIdprofissional());
            stmt.setInt(2, profissionalprojeto.getProjeto().getIdprojeto());
            stmt.executeUpdate();
            return true;
        
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir");
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
    }
    }
    public ArrayList<ProfissionalProjeto> getProjetoPorProfissional(int idprofissional){
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        ArrayList<ProfissionalProjeto> listaProfissionalProjetos = new ArrayList<>();
        
        String sql = "select * from view_profissional_projeto where idprofissional = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idprofissional);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                ProfissionalProjeto profissionalProjeto = new ProfissionalProjeto();
                Profissional profissional = new Profissional();
                profissional.setIdprofissional(rs.getInt("idprofissional"));
                profissional.setNome(rs.getString("nome"));
                profissionalProjeto.setProfissional(profissional);
                
                Projeto projeto = new Projeto();
                projeto.setIdprojeto(rs.getInt("idprojeto"));
                projeto.setNome(rs.getString("nome"));
                profissionalProjeto.setProjeto(projeto);
                
                
                profissionalProjeto.setValor(rs.getDouble("valor"));
                profissionalProjeto.setHorastrabalhadas( rs.getString("horastrabalhadas"));

                
                
                listaProfissionalProjetos.add(profissionalProjeto);
                
            }
        } catch( SQLException ex){
            System.out.println("Erro ao ler os produtos");
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return listaProfissionalProjetos;
    
    }
}
