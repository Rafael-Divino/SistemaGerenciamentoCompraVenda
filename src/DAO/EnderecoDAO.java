/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTOs.EnderecoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rapha
 */
public class EnderecoDAO {
    private Conexao conexao;
    private Connection con;

    public EnderecoDAO() {
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
    }
    
    public int inserirEndereco(EnderecoDTO endereco){
        int idGerado = 0;
        String sql = "INSERT INTO Tb_Endereco(end_Estado"
                + ", end_Cidade, end_Bairro, end_Rua, end_Cep) VALUES(?,?,?,?,?);";
        
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, endereco.getEnd_Estado());
            stmt.setString(2, endereco.getEnd_Cidade());
            stmt.setString(3, endereco.getEnd_Bairro());
            stmt.setString(4, endereco.getEnd_Rua());
            stmt.setString(5, endereco.getEnd_Cep());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
        }
    
        catch(SQLException ex){
            System.out.println("Erro ao inserir Endereço:" + ex.getMessage());
        }
        return idGerado;
    }
    
}
