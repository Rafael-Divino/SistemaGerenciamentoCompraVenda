/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;
import java.util.Date;

/**
 *
 * @author rapha
 */
public class NotaSaidaDTO {
    private int nts_Codigo;
    private Date nts_Data;
    private String nts_TipoCliente; // 'FISICO' ou 'JURIDICO'
    private Integer nts_clf_Codigo; // null se cliente jurídico

    public NotaSaidaDTO() {}

    public NotaSaidaDTO(Date nts_Data, String nts_TipoCliente, Integer nts_clf_Codigo) {
        this.nts_Data = nts_Data;
        this.nts_TipoCliente = nts_TipoCliente;
        this.nts_clf_Codigo = nts_clf_Codigo;
    }

    public int getNts_Codigo() { return nts_Codigo; }
    public void setNts_Codigo(int nts_Codigo) { this.nts_Codigo = nts_Codigo; }

    public Date getNts_Data() { return nts_Data; }
    public void setNts_Data(Date nts_Data) { this.nts_Data = nts_Data; }

    public String getNts_TipoCliente() { return nts_TipoCliente; }
    public void setNts_TipoCliente(String nts_TipoCliente) { this.nts_TipoCliente = nts_TipoCliente; }

    public Integer getNts_clf_Codigo() { return nts_clf_Codigo; }
    public void setNts_clf_Codigo(Integer nts_clf_Codigo) { this.nts_clf_Codigo = nts_clf_Codigo; }
}
