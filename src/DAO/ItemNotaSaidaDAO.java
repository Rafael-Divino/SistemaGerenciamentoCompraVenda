/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTOs.ItemNotaSaidaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rapha
 */
public class ItemNotaSaidaDAO {
    private Conexao conexao;
    private Connection con;

    public ItemNotaSaidaDAO() {
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
    }

    public void inserirItemNotaSaida(ItemNotaSaidaDTO item) {
        String sql = "INSERT INTO Tb_ItemNotaSaida(its_nts_Codigo, its_pro_Codigo, its_Quantidade, its_ValorUnitario) VALUES(?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, item.getIts_nts_Codigo());
            stmt.setInt(2, item.getIts_pro_Codigo());
            stmt.setInt(3, item.getIts_Quantidade());
            stmt.setDouble(4, item.getIts_ValorUnitario());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir ItemNotaSaida: " + ex.getMessage());
        }
    }

    public List<ItemNotaSaidaDTO> listarItensPorNota(int nts_Codigo) {
        List<ItemNotaSaidaDTO> lista = new ArrayList<>();
        String sql = "SELECT i.its_Codigo, i.its_nts_Codigo, i.its_pro_Codigo, i.its_Quantidade, i.its_ValorUnitario, p.pro_Nome " +
                     "FROM Tb_ItemNotaSaida i " +
                     "JOIN Tb_Produto p ON i.its_pro_Codigo = p.pro_Codigo " +
                     "WHERE i.its_nts_Codigo = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, nts_Codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ItemNotaSaidaDTO item = new ItemNotaSaidaDTO();
                item.setIts_Codigo(rs.getInt("its_Codigo"));
                item.setIts_nts_Codigo(rs.getInt("its_nts_Codigo"));
                item.setIts_pro_Codigo(rs.getInt("its_pro_Codigo"));
                item.setIts_Quantidade(rs.getInt("its_Quantidade"));
                item.setIts_ValorUnitario(rs.getDouble("its_ValorUnitario"));
                lista.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar itens da NotaSaida: " + ex.getMessage());
        }

        return lista;
    }
}
