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
public class FornecedorDTO {
    private int fnd_codigo;
    private String fnd_razaoSocial;
    private String fnd_nomeFantasia;
    private String fnd_cnpj;
    private String fnd_email;
    private String fnd_telefone;
    private int fnd_end_Codigo;

    // Construtor vazio
    public FornecedorDTO() {}

    // Construtor completo
    public FornecedorDTO(String fnd_razaoSocial, String fnd_nomeFantasia, String fnd_cnpj,
                         String fnd_email, String fnd_telefone, int fnd_end_Codigo) {
        this.fnd_razaoSocial = fnd_razaoSocial;
        this.fnd_nomeFantasia = fnd_nomeFantasia;
        this.fnd_cnpj = fnd_cnpj;
        this.fnd_email = fnd_email;
        this.fnd_telefone = fnd_telefone;
        this.fnd_end_Codigo = fnd_end_Codigo;
    }

    // Getters e Setters
    public int getFnd_codigo() { return fnd_codigo; }
    public void setFnd_codigo(int fnd_codigo) { this.fnd_codigo = fnd_codigo; }

    public String getFnd_razaoSocial() { return fnd_razaoSocial; }
    public void setFnd_razaoSocial(String fnd_razaoSocial) { this.fnd_razaoSocial = fnd_razaoSocial; }

    public String getFnd_nomeFantasia() { return fnd_nomeFantasia; }
    public void setFnd_nomeFantasia(String fnd_nomeFantasia) { this.fnd_nomeFantasia = fnd_nomeFantasia; }

    public String getFnd_cnpj() { return fnd_cnpj; }
    public void setFnd_cnpj(String fnd_cnpj) { this.fnd_cnpj = fnd_cnpj; }

    public String getFnd_email() { return fnd_email; }
    public void setFnd_email(String fnd_email) { this.fnd_email = fnd_email; }

    public String getFnd_telefone() { return fnd_telefone; }
    public void setFnd_telefone(String fnd_telefone) { this.fnd_telefone = fnd_telefone; }

    public int getFnd_end_Codigo() { return fnd_end_Codigo; }
    public void setFnd_end_Codigo(int fnd_end_Codigo) { this.fnd_end_Codigo = fnd_end_Codigo; }
}
