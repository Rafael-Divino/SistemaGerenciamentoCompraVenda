/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexao.Conexao;
import DTOs.ItemNotaEntradaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rapha
 */
public class ItemNotaEntradaDAO {
    private Conexao conexao;
    private Connection con;

    public ItemNotaEntradaDAO() {
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
    }

    // Inserir item
    public void inserirItemNotaEntrada(ItemNotaEntradaDTO item) {
        String sql = "INSERT INTO Tb_ItemNotaEntrada(ite_nte_Codigo, ite_pro_Codigo, ite_Quantidade, ite_ValorUnitario) VALUES(?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, item.getIte_nte_Codigo());
            stmt.setInt(2, item.getIte_pro_Codigo());
            stmt.setInt(3, item.getIte_Quantidade());
            stmt.setDouble(4, item.getIte_ValorUnitario());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir ItemNotaEntrada: " + ex.getMessage());
        }
    }

    // Listar itens de uma nota
    public List<ItemNotaEntradaDTO> listarItensPorNota(int nte_Codigo) {
        List<ItemNotaEntradaDTO> lista = new ArrayList<>();
        String sql = "SELECT i.ite_Codigo, i.ite_nte_Codigo, i.ite_pro_Codigo, i.ite_Quantidade, i.ite_ValorUnitario, p.pro_Nome " +
                     "FROM Tb_ItemNotaEntrada i " +
                     "JOIN Tb_Produto p ON i.ite_pro_Codigo = p.pro_Codigo " +
                     "WHERE i.ite_nte_Codigo = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, nte_Codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ItemNotaEntradaDTO item = new ItemNotaEntradaDTO();
                item.setIte_Codigo(rs.getInt("ite_Codigo"));
                item.setIte_nte_Codigo(rs.getInt("ite_nte_Codigo"));
                item.setIte_pro_Codigo(rs.getInt("ite_pro_Codigo"));
                item.setIte_Quantidade(rs.getInt("ite_Quantidade"));
                item.setIte_ValorUnitario(rs.getDouble("ite_ValorUnitario"));
                lista.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar itens da NotaEntrada: " + ex.getMessage());
        }

        return lista;
    }
}
