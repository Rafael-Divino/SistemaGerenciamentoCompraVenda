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
public class NotaEntradaDTO {
    private int nte_Codigo;
    private Date nte_Data;
    private int nte_fnd_Codigo;

    public NotaEntradaDTO() {}

    public NotaEntradaDTO(Date nte_Data, int nte_fnd_Codigo) {
        this.nte_Data = nte_Data;
        this.nte_fnd_Codigo = nte_fnd_Codigo;
    }

    public int getNte_Codigo() { return nte_Codigo; }
    public void setNte_Codigo(int nte_Codigo) { this.nte_Codigo = nte_Codigo; }

    public Date getNte_Data() { return nte_Data; }
    public void setNte_Data(Date nte_Data) { this.nte_Data = nte_Data; }

    public int getNte_fnd_Codigo() { return nte_fnd_Codigo; }
    public void setNte_fnd_Codigo(int nte_fnd_Codigo) { this.nte_fnd_Codigo = nte_fnd_Codigo; }
}