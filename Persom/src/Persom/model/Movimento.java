/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giovani dos Santos
 */
@Entity
@Table(name = "movimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m"),
    @NamedQuery(name = "Movimento.findByIdMovimento", query = "SELECT m FROM Movimento m WHERE m.movimentoPK.idMovimento = :idMovimento"),
    @NamedQuery(name = "Movimento.findByDataMovimento", query = "SELECT m FROM Movimento m WHERE m.dataMovimento = :dataMovimento"),
    @NamedQuery(name = "Movimento.findByTipoMovimento", query = "SELECT m FROM Movimento m WHERE m.tipoMovimento = :tipoMovimento"),
    @NamedQuery(name = "Movimento.findByQuantidade", query = "SELECT m FROM Movimento m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "Movimento.findByPrecocompra", query = "SELECT m FROM Movimento m WHERE m.precocompra = :precocompra"),
    @NamedQuery(name = "Movimento.findByIdProduto", query = "SELECT m FROM Movimento m WHERE m.movimentoPK.idProduto = :idProduto")})
public class Movimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovimentoPK movimentoPK;
    @Basic(optional = false)
    @Column(name = "Data_Movimento")
    @Temporal(TemporalType.DATE)
    private Date dataMovimento;
    @Column(name = "Tipo_Movimento")
    private String tipoMovimento;
    @Basic(optional = false)
    @Column(name = "Quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Preco_compra")
    private Double precocompra;

    public Movimento() {
    }

    public Movimento(MovimentoPK movimentoPK) {
        this.movimentoPK = movimentoPK;
    }

    public Movimento(MovimentoPK movimentoPK, Date dataMovimento, int quantidade) {
        this.movimentoPK = movimentoPK;
        this.dataMovimento = dataMovimento;
        this.quantidade = quantidade;
    }

    public Movimento(int idMovimento, int idProduto) {
        this.movimentoPK = new MovimentoPK(idMovimento, idProduto);
    }

    public MovimentoPK getMovimentoPK() {
        return movimentoPK;
    }

    public void setMovimentoPK(MovimentoPK movimentoPK) {
        this.movimentoPK = movimentoPK;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecocompra() {
        return precocompra;
    }

    public void setPrecocompra(Double precocompra) {
        this.precocompra = precocompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movimentoPK != null ? movimentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.movimentoPK == null && other.movimentoPK != null) || (this.movimentoPK != null && !this.movimentoPK.equals(other.movimentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.Movimento[ movimentoPK=" + movimentoPK + " ]";
    }
    
}
