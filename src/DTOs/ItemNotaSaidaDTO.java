/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author rapha
 */
public class ItemNotaSaidaDTO {
    private int its_Codigo;
    private int its_nts_Codigo;
    private int its_pro_Codigo;
    private int its_Quantidade;
    private double its_ValorUnitario;

    public ItemNotaSaidaDTO() {}

    public ItemNotaSaidaDTO(int its_nts_Codigo, int its_pro_Codigo, int its_Quantidade, double its_ValorUnitario) {
        this.its_nts_Codigo = its_nts_Codigo;
        this.its_pro_Codigo = its_pro_Codigo;
        this.its_Quantidade = its_Quantidade;
        this.its_ValorUnitario = its_ValorUnitario;
    }

    public int getIts_Codigo() { return its_Codigo; }
    public void setIts_Codigo(int its_Codigo) { this.its_Codigo = its_Codigo; }

    public int getIts_nts_Codigo() { return its_nts_Codigo; }
    public void setIts_nts_Codigo(int its_nts_Codigo) { this.its_nts_Codigo = its_nts_Codigo; }

    public int getIts_pro_Codigo() { return its_pro_Codigo; }
    public void setIts_pro_Codigo(int its_pro_Codigo) { this.its_pro_Codigo = its_pro_Codigo; }

    public int getIts_Quantidade() { return its_Quantidade; }
    public void setIts_Quantidade(int its_Quantidade) { this.its_Quantidade = its_Quantidade; }

    public double getIts_ValorUnitario() { return its_ValorUnitario; }
    public void setIts_ValorUnitario(double its_ValorUnitario) { this.its_ValorUnitario = its_ValorUnitario; }
}