/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTOs.NotaEntradaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rapha
 */
public class NotaEntradaDAO {
    private Conexao conexao;
    private Connection con;

    public NotaEntradaDAO() {
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
    }

    // Inserir nota de entrada
    public int inserirNotaEntrada(NotaEntradaDTO nota) {
        int idGerado = 0;
        String sql = "INSERT INTO Tb_NotaEntrada(nte_Data, nte_fnd_Codigo) VALUES(?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, new java.sql.Date(nota.getNte_Data().getTime()));
            stmt.setInt(2, nota.getNte_fnd_Codigo());

            int linhas = stmt.executeUpdate();
            
            if (linhas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir NotaEntrada: " + ex.getMessage());
        }

        return idGerado;
    }

    // Listar todas notas de entrada
    public List<NotaEntradaDTO> listarNotasEntrada() {
        List<NotaEntradaDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tb_NotaEntrada";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NotaEntradaDTO nota = new NotaEntradaDTO();
                nota.setNte_Codigo(rs.getInt("nte_Codigo"));
                nota.setNte_Data(rs.getDate("nte_Data"));
                nota.setNte_fnd_Codigo(rs.getInt("nte_fnd_Codigo"));
                lista.add(nota);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar NotaEntrada: " + ex.getMessage());
        }

        return lista;
    }
}