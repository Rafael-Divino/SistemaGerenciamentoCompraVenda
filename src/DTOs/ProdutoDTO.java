/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author 2830482411018
 */
public class ProdutoDTO {
    private int pro_ID_Produto;
    private int pro_Codigo;
    private String pro_Nome;
    private String pro_Descricao;
    private double pro_PrecoCompra;
    private double pro_PrecoVenda;
    private int pro_QtdeEstoque;

    // Construtor vazio
    public ProdutoDTO() {}

    // Construtor completo
    public ProdutoDTO(int pro_Codigo, String pro_Nome, String pro_Descricao, double pro_PrecoCompra,
                      double pro_PrecoVenda, int pro_QtdeEstoque) {
        this.pro_Codigo = pro_Codigo;
        this.pro_Nome = pro_Nome;
        this.pro_Descricao = pro_Descricao;
        this.pro_PrecoCompra = pro_PrecoCompra;
        this.pro_PrecoVenda = pro_PrecoVenda;
        this.pro_QtdeEstoque = pro_QtdeEstoque;
    }

    // Getters e Setters
    public int getPro_ID_Produto() { return pro_ID_Produto; }
    public void setPro_ID_Produto(int pro_ID_Produto) { this.pro_ID_Produto = pro_ID_Produto; }

    public int getPro_Codigo() { return pro_Codigo; }
    public void setPro_Codigo(int pro_Codigo) { this.pro_Codigo = pro_Codigo; }

    public String getPro_Nome() { return pro_Nome; }
    public void setPro_Nome(String pro_Nome) { this.pro_Nome = pro_Nome; }

    public String getPro_Descricao() { return pro_Descricao; }
    public void setPro_Descricao(String pro_Descricao) { this.pro_Descricao = pro_Descricao; }

    public double getPro_PrecoCompra() { return pro_PrecoCompra; }
    public void setPro_PrecoCompra(double pro_PrecoCompra) { this.pro_PrecoCompra = pro_PrecoCompra; }

    public double getPro_PrecoVenda() { return pro_PrecoVenda; }
    public void setPro_PrecoVenda(double pro_PrecoVenda) { this.pro_PrecoVenda = pro_PrecoVenda; }

    public int getPro_QtdeEstoque() { return pro_QtdeEstoque; }
    public void setPro_QtdeEstoque(int pro_QtdeEstoque) { this.pro_QtdeEstoque = pro_QtdeEstoque; }
}