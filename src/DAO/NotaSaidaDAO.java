/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexao.Conexao;
import DTOs.NotaSaidaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rapha
 */
public class NotaSaidaDAO {
    private Conexao conexao;
    private Connection con;

    public NotaSaidaDAO() {
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
    }

    // Inserir nota de saída
    public int inserirNotaSaida(NotaSaidaDTO nota) {
        int idGerado = 0;
        String sql = "INSERT INTO Tb_NotaSaida(nts_Data, nts_TipoCliente, nts_clf_Codigo) VALUES(?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, new java.sql.Date(nota.getNts_Data().getTime()));
            stmt.setString(2, nota.getNts_TipoCliente());
            if (nota.getNts_clf_Codigo() != null) {
                stmt.setInt(3, nota.getNts_clf_Codigo());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir NotaSaida: " + ex.getMessage());
        }

        return idGerado;
    }

    // Listar todas notas de saída
    public List<NotaSaidaDTO> listarNotasSaida() {
        List<NotaSaidaDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tb_NotaSaida";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NotaSaidaDTO nota = new NotaSaidaDTO();
                nota.setNts_Codigo(rs.getInt("nts_Codigo"));
                nota.setNts_Data(rs.getDate("nts_Data"));
                nota.setNts_TipoCliente(rs.getString("nts_TipoCliente"));
                int idCliente = rs.getInt("nts_clf_Codigo");
                if (!rs.wasNull()) {
                    nota.setNts_clf_Codigo(idCliente);
                }
                lista.add(nota);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar NotaSaida: " + ex.getMessage());
        }

        return lista;
    }
}
