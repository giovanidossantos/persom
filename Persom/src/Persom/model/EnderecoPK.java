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
public class EnderecoPK implements Serializable {

    private static final long serialVersionUID = -7028286474340909647L;
    
    @Basic(optional = false)
    @Column(name = "idEndereco")
    private int idEndereco;
    @Basic(optional = false)
    @Column(name = "Cliente_CPF_CNPJ")
    private String clienteCPFCNPJ;

    public EnderecoPK() {
    }

    public EnderecoPK(int idEndereco, String clienteCPFCNPJ) {
        this.idEndereco = idEndereco;
        this.clienteCPFCNPJ = clienteCPFCNPJ;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
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
        hash += idEndereco;
        hash += (clienteCPFCNPJ != null ? clienteCPFCNPJ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnderecoPK)) {
            return false;
        }
        EnderecoPK other = (EnderecoPK) object;
        if (this.idEndereco != other.idEndereco) {
            return false;
        }
        if ((this.clienteCPFCNPJ == null && other.clienteCPFCNPJ != null) || (this.clienteCPFCNPJ != null && !this.clienteCPFCNPJ.equals(other.clienteCPFCNPJ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.EnderecoPK[ idEndereco=" + idEndereco + ", clienteCPFCNPJ=" + clienteCPFCNPJ + " ]";
    }
    
}
