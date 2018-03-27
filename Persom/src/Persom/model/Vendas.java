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
@Table(name = "vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),
    @NamedQuery(name = "Vendas.findByIdVendas", query = "SELECT v FROM Vendas v WHERE v.vendasPK.idVendas = :idVendas"),
    @NamedQuery(name = "Vendas.findByOrdemServico", query = "SELECT v FROM Vendas v WHERE v.ordemServico = :ordemServico"),
    @NamedQuery(name = "Vendas.findByDataVenda", query = "SELECT v FROM Vendas v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Vendas.findByNomeProduto", query = "SELECT v FROM Vendas v WHERE v.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Vendas.findByModeloProduto", query = "SELECT v FROM Vendas v WHERE v.modeloProduto = :modeloProduto"),
    @NamedQuery(name = "Vendas.findByMarcaProduto", query = "SELECT v FROM Vendas v WHERE v.marcaProduto = :marcaProduto"),
    @NamedQuery(name = "Vendas.findByPrecoUnit", query = "SELECT v FROM Vendas v WHERE v.precoUnit = :precoUnit"),
    @NamedQuery(name = "Vendas.findByQuantidadeProduto", query = "SELECT v FROM Vendas v WHERE v.quantidadeProduto = :quantidadeProduto"),
    @NamedQuery(name = "Vendas.findByValorTotal", query = "SELECT v FROM Vendas v WHERE v.valorTotal = :valorTotal"),
    @NamedQuery(name = "Vendas.findByGarantia", query = "SELECT v FROM Vendas v WHERE v.garantia = :garantia"),
    @NamedQuery(name = "Vendas.findByClienteCPFCNPJ", query = "SELECT v FROM Vendas v WHERE v.vendasPK.clienteCPFCNPJ = :clienteCPFCNPJ"),
    @NamedQuery(name = "Vendas.findByIdProduto", query = "SELECT v FROM Vendas v WHERE v.vendasPK.idProduto = :idProduto")})
public class Vendas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VendasPK vendasPK;
    @Basic(optional = false)
    @Column(name = "Ordem_Servico")
    private int ordemServico;
    @Basic(optional = false)
    @Column(name = "Data_Venda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Column(name = "NomeProduto")
    private String nomeProduto;
    @Column(name = "ModeloProduto")
    private String modeloProduto;
    @Column(name = "MarcaProduto")
    private String marcaProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrecoUnit")
    private BigDecimal precoUnit;
    @Column(name = "Quantidade_Produto")
    private Integer quantidadeProduto;
    @Basic(optional = false)
    @Column(name = "Valor_Total")
    private BigDecimal valorTotal;
    @Column(name = "Garantia")
    private String garantia;

    public Vendas() {
    }

    public Vendas(VendasPK vendasPK) {
        this.vendasPK = vendasPK;
    }

    public Vendas(VendasPK vendasPK, int ordemServico, Date dataVenda, BigDecimal valorTotal) {
        this.vendasPK = vendasPK;
        this.ordemServico = ordemServico;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public Vendas(int idVendas, String clienteCPFCNPJ, int idProduto) {
        this.vendasPK = new VendasPK(idVendas, clienteCPFCNPJ, idProduto);
    }

    public VendasPK getVendasPK() {
        return vendasPK;
    }

    public void setVendasPK(VendasPK vendasPK) {
        this.vendasPK = vendasPK;
    }

    public int getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(int ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getModeloProduto() {
        return modeloProduto;
    }

    public void setModeloProduto(String modeloProduto) {
        this.modeloProduto = modeloProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public BigDecimal getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(BigDecimal precoUnit) {
        this.precoUnit = precoUnit;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendasPK != null ? vendasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.vendasPK == null && other.vendasPK != null) || (this.vendasPK != null && !this.vendasPK.equals(other.vendasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.Vendas[ vendasPK=" + vendasPK + " ]";
    }
    
}
