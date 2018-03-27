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
public class MovimentoPK implements Serializable {

    private static final long serialVersionUID = -7386801484931587731L;
    
    @Basic(optional = false)
    @Column(name = "idMovimento")
    private int idMovimento;
    @Basic(optional = false)
    @Column(name = "idProduto")
    private int idProduto;

    public MovimentoPK() {
    }

    public MovimentoPK(int idMovimento, int idProduto) {
        this.idMovimento = idMovimento;
        this.idProduto = idProduto;
    }

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
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
        hash += idMovimento;
        hash += idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentoPK)) {
            return false;
        }
        MovimentoPK other = (MovimentoPK) object;
        if (this.idMovimento != other.idMovimento) {
            return false;
        }
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.MovimentoPK[ idMovimento=" + idMovimento + ", idProduto=" + idProduto + " ]";
    }
    
}
