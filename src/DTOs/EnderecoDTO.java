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


public class EnderecoDTO {

    public static String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int end_Codigo;
    private String end_Estado;
    private String end_Cidade;
    private String end_Bairro;
    private String end_Rua;
    private String end_Cep;

    public EnderecoDTO(String end_Estado, String end_Cidade, String end_Bairro, String end_Rua, String end_Cep) {
        this.end_Estado = end_Estado;
        this.end_Cidade = end_Cidade;
        this.end_Bairro = end_Bairro;
        this.end_Rua = end_Rua;
        this.end_Cep = end_Cep;
    }

    public int getEnd_Codigo() {
        return end_Codigo;
    }

    public void setEnd_Codigo(int end_Codigo) {
        this.end_Codigo = end_Codigo;
    }

    public String getEnd_Estado() {
        return end_Estado;
    }

    public void setEnd_Estado(String end_Estado) {
        this.end_Estado = end_Estado;
    }

    public String getEnd_Cidade() {
        return end_Cidade;
    }

    public void setEnd_Cidade(String end_Cidade) {
        this.end_Cidade = end_Cidade;
    }

    public String getEnd_Bairro() {
        return end_Bairro;
    }

    public void setEnd_Bairro(String end_Bairro) {
        this.end_Bairro = end_Bairro;
    }

    public String getEnd_Rua() {
        return end_Rua;
    }

    public void setEnd_Rua(String end_Rua) {
        this.end_Rua = end_Rua;
    }

    public String getEnd_Cep() {
        return end_Cep;
    }

    public void setEnd_Cep(String end_Cep) {
        this.end_Cep = end_Cep;
    }
    
}
