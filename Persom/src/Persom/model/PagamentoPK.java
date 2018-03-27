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
public class PagamentoPK implements Serializable {

    private static final long serialVersionUID = -5342520138410217977L;
    
    @Basic(optional = false)
    @Column(name = "idPagamento")
    private int idPagamento;
    @Basic(optional = false)
    @Column(name = "Cliente_CPF_CNPJ")
    private String clienteCPFCNPJ;

    public PagamentoPK() {
    }

    public PagamentoPK(int idPagamento, String clienteCPFCNPJ) {
        this.idPagamento = idPagamento;
        this.clienteCPFCNPJ = clienteCPFCNPJ;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
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
        hash += idPagamento;
        hash += (clienteCPFCNPJ != null ? clienteCPFCNPJ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagamentoPK)) {
            return false;
        }
        PagamentoPK other = (PagamentoPK) object;
        if (this.idPagamento != other.idPagamento) {
            return false;
        }
        if ((this.clienteCPFCNPJ == null && other.clienteCPFCNPJ != null) || (this.clienteCPFCNPJ != null && !this.clienteCPFCNPJ.equals(other.clienteCPFCNPJ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.PagamentoPK[ idPagamento=" + idPagamento + ", clienteCPFCNPJ=" + clienteCPFCNPJ + " ]";
    }
    
}
