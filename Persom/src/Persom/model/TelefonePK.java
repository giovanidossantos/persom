/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Giovani dos Santos
 */
@Embeddable
public class TelefonePK implements Serializable {

    private static final long serialVersionUID = 5858291652032230565L;
    
    @Basic(optional = false)
    @Column(name = "idTelefone")
    private int idTelefone;
    @Basic(optional = false)
    @Column(name = "Cliente_CPF_CNPJ")
    private String clienteCPFCNPJ;

    public TelefonePK() {
    }

    public TelefonePK(int idTelefone, String clienteCPFCNPJ) {
        this.idTelefone = idTelefone;
        this.clienteCPFCNPJ = clienteCPFCNPJ;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getClienteCPFCNPJ() {
        return clienteCPFCNPJ;
    }

    public void setClienteCPFCNPJ(String clienteCPFCNPJ) {
        this.clienteCPFCNPJ = clienteCPFCNPJ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += idTelefone;
        hash += (clienteCPFCNPJ != null ? clienteCPFCNPJ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonePK)) {
            return false;
        }
        TelefonePK other = (TelefonePK) object;
        if (this.idTelefone != other.idTelefone) {
            return false;
        }
        if ((this.clienteCPFCNPJ == null && other.clienteCPFCNPJ != null) || (this.clienteCPFCNPJ != null && !this.clienteCPFCNPJ.equals(other.clienteCPFCNPJ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.TelefonePK[ idTelefone=" + idTelefone + ", clienteCPFCNPJ=" + clienteCPFCNPJ + " ]";
    }
    
}
