/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTOs.FornecedorDTO;
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
public class FornecedorDAO {
    
    private Conexao conexao;
    private Connection con;

    public FornecedorDAO() {
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
    }

    // Inserir fornecedor
    public int inserirFornecedor(FornecedorDTO fornecedor) {
        int idGerado = 0;
        String sql = "INSERT INTO Tb_Fornecedor(fnd_RazaoSocial, fnd_NomeFantasia, fnd_Cnpj, fnd_Email, fnd_Telefone, fnd_end_Codigo) VALUES(?,?,?,?,?,?)";

        if (con == null) {
            System.out.println("Conexão não estabelecida!");
            return idGerado;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, fornecedor.getFnd_razaoSocial());
            stmt.setString(2, fornecedor.getFnd_nomeFantasia());
            stmt.setString(3, fornecedor.getFnd_cnpj());
            stmt.setString(4, fornecedor.getFnd_email());
            stmt.setString(5, fornecedor.getFnd_telefone());
            stmt.setInt(6, fornecedor.getFnd_end_Codigo());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir fornecedor: " + ex.getMessage());
        }

        return idGerado;
    }

    public List<FornecedorDTO> listarFornecedores() {
        List<FornecedorDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tb_Fornecedor";

        if (con == null) {
            System.out.println("Conexão não estabelecida!");
            return lista;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FornecedorDTO fornecedor = new FornecedorDTO();
                fornecedor.setFnd_codigo(rs.getInt("fnd_Codigo"));
                fornecedor.setFnd_razaoSocial(rs.getString("fnd_RazaoSocial"));
                fornecedor.setFnd_nomeFantasia(rs.getString("fnd_NomeFantasia"));
                fornecedor.setFnd_cnpj(rs.getString("fnd_Cnpj"));
                fornecedor.setFnd_email(rs.getString("fnd_Email"));
                fornecedor.setFnd_telefone(rs.getString("fnd_Telefone"));
                fornecedor.setFnd_end_Codigo(rs.getInt("fnd_end_Codigo"));

                lista.add(fornecedor);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar fornecedores: " + ex.getMessage());
        }

        return lista;
    }
    
}
