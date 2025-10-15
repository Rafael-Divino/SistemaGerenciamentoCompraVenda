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
public class ClienteDTO {
    private int clf_codigo;
    private String clf_nome;
    private String clf_cpf;
    private String clf_Email;
    private String clf_Telefone;
    private int clf_end_Codigo;
    

    public ClienteDTO(String clf_nome, String clf_cpf, String clf_Email, String clf_Telefone, int clf_end_Codigo) {
        this.clf_nome = clf_nome;
        this.clf_cpf = clf_cpf;
        this.clf_Email = clf_Email;
        this.clf_Telefone = clf_Telefone;
        this.clf_end_Codigo = clf_end_Codigo;
    } 

    public ClienteDTO() {
        
    }
    

    public int getClf_codigo() {
        return clf_codigo;
    }

    public void setClf_codigo(int clf_codigo) {
        this.clf_codigo = clf_codigo;
    }

    public String getClf_nome() {
        return clf_nome;
    }

    public void setClf_nome(String clf_nome) {
        this.clf_nome = clf_nome;
    }

    public String getClf_cpf() {
        return clf_cpf;
    }

    public void setClf_cpf(String clf_cpf) {
        this.clf_cpf = clf_cpf;
    }

    public String getClf_Email() {
        return clf_Email;
    }

    public void setClf_Email(String clf_Email) {
        this.clf_Email = clf_Email;
    }

    public String getClf_Telefone() {
        return clf_Telefone;
    }

    public void setClf_Telefone(String clf_Telefone) {
        this.clf_Telefone = clf_Telefone;
    }

    public int getClf_end_Codigo() {
        return clf_end_Codigo;
    }

    public void setClf_end_Codigo(int clf_end_Codigo) {
        this.clf_end_Codigo = clf_end_Codigo;
    }
    
    
     
}


