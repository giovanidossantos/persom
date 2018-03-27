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
public class OrcamentoPK implements Serializable {

    private static final long serialVersionUID = -7174145289027633436L;
    
    @Basic(optional = false)
    @Column(name = "idOrcamento")
    private int idOrcamento;
    @Basic(optional = false)
    @Column(name = "Cliente_CPF_CNPJ")
    private String clienteCPFCNPJ;

    public OrcamentoPK() {
    }

    public OrcamentoPK(int idOrcamento, String clienteCPFCNPJ) {
        this.idOrcamento = idOrcamento;
        this.clienteCPFCNPJ = clienteCPFCNPJ;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
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
        hash += idOrcamento;
        hash += (clienteCPFCNPJ != null ? clienteCPFCNPJ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrcamentoPK)) {
            return false;
        }
        OrcamentoPK other = (OrcamentoPK) object;
        if (this.idOrcamento != other.idOrcamento) {
            return false;
        }
        if ((this.clienteCPFCNPJ == null && other.clienteCPFCNPJ != null) || (this.clienteCPFCNPJ != null && !this.clienteCPFCNPJ.equals(other.clienteCPFCNPJ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.OrcamentoPK[ idOrcamento=" + idOrcamento + ", clienteCPFCNPJ=" + clienteCPFCNPJ + " ]";
    }
    
}
