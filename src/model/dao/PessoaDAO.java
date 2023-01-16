/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Pessoa;


public class PessoaDAO {
     private Connection con = null;
    
    public PessoaDAO(){
        
        con = ConnectionFactory.getConnection();
                
    }
    
    public boolean create(Pessoa pessoa) {
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO pessoa (nome, cpf, telefone, endereco) VALUES (?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEndereco());
            
            stmt.executeUpdate();
            
            return true;
           
        } catch (Exception ex) {
            System.out.println("Erro ao salvar: " +  ex);
            return false;
        } finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
    }public ArrayList<Pessoa> read() {
   
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        
        String sql = "select * from view_produtocategoria order by pid";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pessoa pessoa = new Pessoa() {};
                pessoa.setIdpessoa(rs.getInt("idpessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEndereco(rs.getString("endereco"));
                
                
                listaPessoas.add(pessoa);
                
            }
        } catch( SQLException ex){
            System.out.println("Erro ao ler os produtos");
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return listaPessoas;
        }
    public boolean update(Pessoa pessoa) {
    
      
        PreparedStatement stmt = null;
        String sql = "UPDATE pessoa set nome = ?, cpf = ?, telefone = ?, endereco = ? WHERE idpessoa = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEndereco());
            stmt.setInt(5, pessoa.getIdpessoa());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch(SQLException ex) {
            System.out.println("Erro ao atualizar");
            return false;
        } finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    public boolean delete (Pessoa pessoa) {
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM pessoa WHERE idpessoa = ?";

        try {
            stmt =  con.prepareStatement(sql);
            stmt.setInt(1, pessoa.getIdpessoa());
            stmt.executeUpdate();
            return true;
        
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir");
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
    }
    }
    }