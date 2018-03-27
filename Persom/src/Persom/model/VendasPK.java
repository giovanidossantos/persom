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
public class VendasPK implements Serializable {

    private static final long serialVersionUID = -2962800926075685694L;
    
    @Basic(optional = false)
    @Column(name = "idVendas")
    private int idVendas;
    @Basic(optional = false)
    @Column(name = "Cliente_CPF_CNPJ")
    private String clienteCPFCNPJ;
    @Basic(optional = false)
    @Column(name = "idProduto")
    private int idProduto;

    public VendasPK() {
    }

    public VendasPK(int idVendas, String clienteCPFCNPJ, int idProduto) {
        this.idVendas = idVendas;
        this.clienteCPFCNPJ = clienteCPFCNPJ;
        this.idProduto = idProduto;
    }

    public int getIdVendas() {
        return idVendas;
    }

    public void setIdVendas(int idVendas) {
        this.idVendas = idVendas;
    }

    public String getClienteCPFCNPJ() {
        return clienteCPFCNPJ;
    }

    public void setClienteCPFCNPJ(String clienteCPFCNPJ) {
        this.clienteCPFCNPJ = clienteCPFCNPJ;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += idVendas;
        hash += (clienteCPFCNPJ != null ? clienteCPFCNPJ.hashCode() : 0);
        hash += idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendasPK)) {
            return false;
        }
        VendasPK other = (VendasPK) object;
        if (this.idVendas != other.idVendas) {
            return false;
        }
        if ((this.clienteCPFCNPJ == null && other.clienteCPFCNPJ != null) || (this.clienteCPFCNPJ != null && !this.clienteCPFCNPJ.equals(other.clienteCPFCNPJ))) {
            return false;
        }
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.VendasPK[ idVendas=" + idVendas + ", clienteCPFCNPJ=" + clienteCPFCNPJ + ", idProduto=" + idProduto + " ]";
    }
    
}
