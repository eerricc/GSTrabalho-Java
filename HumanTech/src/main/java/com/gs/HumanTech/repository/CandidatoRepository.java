package com.gs.HumanTech.repository;

import com.gs.HumanTech.dao.DBConnection;
import com.gs.HumanTech.model.CandidatoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CandidatoRepository {

    @Autowired
    private DBConnection dbConn;

    // CREATE
    public CandidatoModel saveCandidato(CandidatoModel candidato) {
        String sql = "INSERT INTO candidatos (nome, email, cidade, pais) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, candidato.getNome());
            stmt.setString(2, candidato.getEmail());
            stmt.setString(3, candidato.getCidade());
            stmt.setString(4, candidato.getPais());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                candidato.setId_candidato(rs.getInt(1));
            }

            System.out.println("Candidato salvo");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar candidato: " + e.getMessage());
        }

        return candidato;
    }

    public CandidatoModel findById(int id) {
        String sql = "SELECT * FROM candidato WHERE id_candidato = ?";
        CandidatoModel candidato = null;

        try (Connection conn = dbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                candidato = new CandidatoModel(
                        rs.getInt("id_candidato"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("cidade"),
                        rs.getString("pais")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar candidato: " + e.getMessage());
        }

        return candidato;
    }

    public List<CandidatoModel> findAll() {
        String sql = "SELECT * FROM candidato";
        List<CandidatoModel> candidatos = new ArrayList<>();

        try (Connection conn = dbConn.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                candidatos.add(new CandidatoModel(
                        rs.getInt("id_candidato"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("cidade"),
                        rs.getString("pais")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar candidatos: " + e.getMessage());
        }

        return candidatos;
    }

    public CandidatoModel updateCandidato(CandidatoModel candidato) {
        String sql = "UPDATE candidato SET nome = ?, email = ?, cidade = ?, pais = ? WHERE id_candidato = ?";

        try (Connection conn = dbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, candidato.getNome());
            stmt.setString(2, candidato.getEmail());
            stmt.setString(3, candidato.getCidade());
            stmt.setString(4, candidato.getPais());
            stmt.setInt(5, candidato.getId_candidato());

            stmt.executeUpdate();
            System.out.println("Candidato atualizado");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar candidato: " + e.getMessage());
        }

        return candidato;
    }

    public boolean deleteCandidato(int id) {
        String sql = "DELETE FROM candidato WHERE id_candidato = ?";

        try (Connection conn = dbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println("Candidato excluído");
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir candidato: " + e.getMessage());
            return false;
        }
    }
}
