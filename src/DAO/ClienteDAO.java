/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTOs.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rapha
 */
public class ClienteDAO {
    private Conexao conexao;
    private Connection con;

    public ClienteDAO() {
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
    }
    
    public void inserirCliente(ClienteDTO cliente){
        String sql = "INSERT INTO Tb_ClienteFisico(clf_Nome"
                + ", clf_Cpf, clf_Email, clf_Telefone, clf_end_Codigo) VALUES(?,?,?,?,?);";
        
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, cliente.getClf_nome());
            stmt.setString(2, cliente.getClf_cpf());
            stmt.setString(3, cliente.getClf_Email());
            stmt.setString(4, cliente.getClf_Telefone());
            stmt.setInt(5, cliente.getClf_end_Codigo());
            stmt.execute();
            
            System.out.println("Parabéns");
            JOptionPane.showMessageDialog(null, "cliente adicionado com sucesso!");
        }
    
        catch(SQLException ex){
            System.out.println("Erro ao inserir Cliente:" + ex.getMessage());
        }
    }
    
    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tb_ClienteFisico";

        if (con == null) {
            System.out.println("Conexão não estabelecida!");
            return lista;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setClf_codigo(rs.getInt("clf_Codigo"));
                cliente.setClf_nome(rs.getString("clf_Nome"));
                cliente.setClf_cpf(rs.getString("clf_Cpf"));
                cliente.setClf_Email(rs.getString("clf_Email"));
                cliente.setClf_Telefone(rs.getString("clf_Telefone"));
                cliente.setClf_end_Codigo(rs.getInt("clf_end_Codigo"));
                lista.add(cliente);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar clientes: " + ex.getMessage());
        }

    return lista;
    }
}
