package com.gs.HumanTech.repository;

import com.gs.HumanTech.dao.DBConnection;
import com.gs.HumanTech.model.VagaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VagaRepository {

    @Autowired
    private DBConnection dbConn;

    // CREATE
    public VagaModel saveVaga(VagaModel vaga) {
        String sql = "INSERT INTO vagas (titulo, tipo_trabalho, salario, descricao) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, vaga.getTitulo());
            stmt.setString(2, vaga.getTipo_trabalho());
            stmt.setFloat(3, vaga.getSalario());
            stmt.setString(4, vaga.getDescricao());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                vaga.setId_vaga(rs.getInt(1));
            }

            System.out.println("Vaga salva com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar vaga: " + e.getMessage());
        }

        return vaga;
    }

    // READ - Buscar por ID
    public VagaModel findById(Integer id) {
        String sql = "SELECT * FROM vagas WHERE id_vaga = ?";
        VagaModel vaga = null;

        try (Connection conn = dbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                vaga = new VagaModel();
                vaga.setId_vaga(rs.getInt("id_vaga"));
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setTipo_trabalho(rs.getString("tipo_trabalho"));
                vaga.setSalario(rs.getFloat("salario"));
                vaga.setDescricao(rs.getString("descricao"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar vaga por ID: " + e.getMessage());
        }

        return vaga;
    }

    // READ - Listar todas
    public List<VagaModel> findAll() {
        String sql = "SELECT * FROM vagas";
        List<VagaModel> vagas = new ArrayList<>();

        try (Connection conn = dbConn.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                VagaModel vaga = new VagaModel();
                vaga.setId_vaga(rs.getInt("id_vaga"));
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setTipo_trabalho(rs.getString("tipo_trabalho"));
                vaga.setSalario(rs.getFloat("salario"));
                vaga.setDescricao(rs.getString("descricao"));
                vagas.add(vaga);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar vagas: " + e.getMessage());
        }

        return vagas;
    }

    // UPDATE
    public boolean updateVaga(VagaModel vaga) {
        String sql = "UPDATE vagas SET titulo = ?, tipo_trabalho = ?, salario = ?, descricao = ? WHERE id_vaga = ?";

        try (Connection conn = dbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vaga.getTitulo());
            stmt.setString(2, vaga.getTipo_trabalho());
            stmt.setFloat(3, vaga.getSalario());
            stmt.setString(4, vaga.getDescricao());
            stmt.setInt(5, vaga.getId_vaga());

            int updated = stmt.executeUpdate();
            return updated > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar vaga: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean deleteVaga(Integer id) {
        String sql = "DELETE FROM vagas WHERE id_vaga = ?";

        try (Connection conn = dbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();
            return deleted > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar vaga: " + e.getMessage());
            return false;
        }
    }
}
