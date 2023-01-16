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
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author USER
 */
public class ClienteDAO {
     public boolean create(Cliente cliente) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome, cpf, telefone, endereco) VALUES (?,?,?,?) ");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (Exception ex) {
            System.out.println("Erro ao salvar: " +  ex);
        } finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
     public ArrayList<Cliente> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente ORDER by idcliente");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                listaClientes.add(cliente);
                
            }
        } catch( SQLException ex){
            System.out.println("Erro ao ler os clientes");
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaClientes;
        }

    public boolean update(Cliente cliente) {
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente set nome = ?, cpf = ?, telefone = ?, endereco = ? WHERE idcliente = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            
            
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
    public boolean delete (Cliente cliente) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt =  con.prepareStatement("DELETE FROM cliente WHERE idcliente = ?");
            stmt.setInt(1, cliente.getIdcliente());
            
            stmt.executeUpdate();
            
            System.out.println("Excluido com sucesso!");
            return true;
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao excluir");
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
    }
        
    }
    
}
