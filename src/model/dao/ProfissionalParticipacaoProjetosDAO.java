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
import model.bean.ProfissionalParticipacaoProjetos;

/**
 *
 * @author luisf
 */
public class ProfissionalParticipacaoProjetosDAO {
    
    public List<ProfissionalParticipacaoProjetos> carregarProfissionais() {
        List<ProfissionalParticipacaoProjetos> clienteParticipacaoProjeto = new ArrayList();

        String sql = "select * from view_profissional_participacao_projeto order by idprofissional";
        try ( Connection con = ConnectionFactory.getConnection();  PreparedStatement stmt = con.prepareStatement(sql);) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProfissionalParticipacaoProjetos profissional = new ProfissionalParticipacaoProjetos(rs);

                clienteParticipacaoProjeto.add(profissional);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler os profissionais");
            ex.printStackTrace();
        }
        return clienteParticipacaoProjeto;
    }
    
}
