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
import java.util.List;
import model.bean.ClienteParticipacaoProjetos;

/**
 *
 * @author luisf
 */
public class ClienteParticipacaoProjetosDAO {

    public List<ClienteParticipacaoProjetos> carregarClientes() {
        List<ClienteParticipacaoProjetos> clienteParticipacaoProjeto = new ArrayList();

        ResultSet rs = null;

        String sql = "select * from view_cliente_participacao_projeto order by idcliente";
        try ( Connection con = ConnectionFactory.getConnection();  PreparedStatement stmt = con.prepareStatement(sql);) {

            rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteParticipacaoProjetos cliente = new ClienteParticipacaoProjetos(rs);

                clienteParticipacaoProjeto.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler os clientes");

        }
        return clienteParticipacaoProjeto;
    }
}
