/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByIdPagamento", query = "SELECT p FROM Pagamento p WHERE p.pagamentoPK.idPagamento = :idPagamento"),
    @NamedQuery(name = "Pagamento.findByData", query = "SELECT p FROM Pagamento p WHERE p.data = :data"),
    @NamedQuery(name = "Pagamento.findByOrdemPagamento", query = "SELECT p FROM Pagamento p WHERE p.ordemPagamento = :ordemPagamento"),
    @NamedQuery(name = "Pagamento.findByTipoOperacao", query = "SELECT p FROM Pagamento p WHERE p.tipoOperacao = :tipoOperacao"),
    @NamedQuery(name = "Pagamento.findByValorTotal", query = "SELECT p FROM Pagamento p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "Pagamento.findByValorRecebido", query = "SELECT p FROM Pagamento p WHERE p.valorRecebido = :valorRecebido"),
    @NamedQuery(name = "Pagamento.findByTroco", query = "SELECT p FROM Pagamento p WHERE p.troco = :troco"),
    @NamedQuery(name = "Pagamento.findByClienteCPFCNPJ", query = "SELECT p FROM Pagamento p WHERE p.pagamentoPK.clienteCPFCNPJ = :clienteCPFCNPJ")})
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagamentoPK pagamentoPK;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "OrdemPagamento")
    private Integer ordemPagamento;
    @Basic(optional = false)
    @Column(name = "Tipo_Operacao")
    private String tipoOperacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Valor_Total")
    private BigDecimal valorTotal;
    @Column(name = "Valor_Recebido")
    private BigDecimal valorRecebido;
    @Column(name = "Troco")
    private BigDecimal troco;

    public Pagamento() {
    }

    public Pagamento(PagamentoPK pagamentoPK) {
        this.pagamentoPK = pagamentoPK;
    }

    public Pagamento(PagamentoPK pagamentoPK, Date data, String tipoOperacao, BigDecimal valorTotal) {
        this.pagamentoPK = pagamentoPK;
        this.data = data;
        this.tipoOperacao = tipoOperacao;
        this.valorTotal = valorTotal;
    }

    public Pagamento(int idPagamento, String clienteCPFCNPJ) {
        this.pagamentoPK = new PagamentoPK(idPagamento, clienteCPFCNPJ);
    }

    public PagamentoPK getPagamentoPK() {
        return pagamentoPK;
    }

    public void setPagamentoPK(PagamentoPK pagamentoPK) {
        this.pagamentoPK = pagamentoPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getOrdemPagamento() {
        return ordemPagamento;
    }

    public void setOrdemPagamento(Integer ordemPagamento) {
        this.ordemPagamento = ordemPagamento;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(BigDecimal valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagamentoPK != null ? pagamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.pagamentoPK == null && other.pagamentoPK != null) || (this.pagamentoPK != null && !this.pagamentoPK.equals(other.pagamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.Pagamento[ pagamentoPK=" + pagamentoPK + " ]";
    }
    
}
