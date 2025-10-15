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
public class ItemNotaEntradaDTO {
    private int ite_Codigo;
    private int ite_nte_Codigo;
    private int ite_pro_Codigo;
    private int ite_Quantidade;
    private double ite_ValorUnitario;

    public ItemNotaEntradaDTO() {}

    public ItemNotaEntradaDTO(int ite_nte_Codigo, int ite_pro_Codigo, int ite_Quantidade, double ite_ValorUnitario) {
        this.ite_nte_Codigo = ite_nte_Codigo;
        this.ite_pro_Codigo = ite_pro_Codigo;
        this.ite_Quantidade = ite_Quantidade;
        this.ite_ValorUnitario = ite_ValorUnitario;
    }

    public int getIte_Codigo() { return ite_Codigo; }
    public void setIte_Codigo(int ite_Codigo) { this.ite_Codigo = ite_Codigo; }

    public int getIte_nte_Codigo() { return ite_nte_Codigo; }
    public void setIte_nte_Codigo(int ite_nte_Codigo) { this.ite_nte_Codigo = ite_nte_Codigo; }

    public int getIte_pro_Codigo() { return ite_pro_Codigo; }
    public void setIte_pro_Codigo(int ite_pro_Codigo) { this.ite_pro_Codigo = ite_pro_Codigo; }

    public int getIte_Quantidade() { return ite_Quantidade; }
    public void setIte_Quantidade(int ite_Quantidade) { this.ite_Quantidade = ite_Quantidade; }

    public double getIte_ValorUnitario() { return ite_ValorUnitario; }
    public void setIte_ValorUnitario(double ite_ValorUnitario) { this.ite_ValorUnitario = ite_ValorUnitario; }
}