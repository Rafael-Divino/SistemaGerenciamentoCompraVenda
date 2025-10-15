/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTOs.ProdutoDTO;
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
public class ProdutoDAO {
    private Conexao conexao;
    private Connection con;

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
    }

    // Inserir produto
    public int inserirProduto(ProdutoDTO produto) {
        int idGerado = 0;
        String sql = "INSERT INTO Tb_Produto(pro_Codigo, pro_Nome, pro_Descricao, pro_PrecoCompra, pro_PrecoVenda, pro_QtdeEstoque) VALUES(?,?,?,?,?,?)";

        if (con == null) {
            System.out.println("Conexão não estabelecida!");
            return idGerado;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, produto.getPro_Codigo());
            stmt.setString(2, produto.getPro_Nome());
            stmt.setString(3, produto.getPro_Descricao());
            stmt.setDouble(4, produto.getPro_PrecoCompra());
            stmt.setDouble(5, produto.getPro_PrecoVenda());
            stmt.setInt(6, produto.getPro_QtdeEstoque());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }

        return idGerado;
    }

    // Listar produtos
    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tb_Produto";

        if (con == null) {
            System.out.println("Conexão não estabelecida!");
            return lista;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO();
                produto.setPro_ID_Produto(rs.getInt("pro_ID_Produto"));
                produto.setPro_Codigo(rs.getInt("pro_Codigo"));
                produto.setPro_Nome(rs.getString("pro_Nome"));
                produto.setPro_Descricao(rs.getString("pro_Descricao"));
                produto.setPro_PrecoCompra(rs.getDouble("pro_PrecoCompra"));
                produto.setPro_PrecoVenda(rs.getDouble("pro_PrecoVenda"));
                produto.setPro_QtdeEstoque(rs.getInt("pro_QtdeEstoque"));

                lista.add(produto);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }

        return lista;
    }
}
