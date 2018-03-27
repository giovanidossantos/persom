/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Giovani dos Santos
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByDataProduto", query = "SELECT p FROM Produto p WHERE p.dataProduto = :dataProduto"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByFornecedor", query = "SELECT p FROM Produto p WHERE p.fornecedor = :fornecedor"),
    @NamedQuery(name = "Produto.findByModelo", query = "SELECT p FROM Produto p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Produto.findByEstoqueMinimo", query = "SELECT p FROM Produto p WHERE p.estoqueMinimo = :estoqueMinimo"),
    @NamedQuery(name = "Produto.findByUnidMedida", query = "SELECT p FROM Produto p WHERE p.unidMedida = :unidMedida"),
    @NamedQuery(name = "Produto.findByPrecovenda", query = "SELECT p FROM Produto p WHERE p.precovenda = :precovenda")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    @Basic(optional = false)
    @Column(name = "Data_Produto")
    @Temporal(TemporalType.DATE)
    private Date dataProduto;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Fornecedor")
    private String fornecedor;
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "Estoque_Minimo")
    private int estoqueMinimo;
    @Basic(optional = false)
    @Column(name = "Unid_Medida")
    private String unidMedida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Preco_venda")
    private BigDecimal precovenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Vendas> vendasCollection;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, Date dataProduto, String nome, int estoqueMinimo, String unidMedida, BigDecimal precovenda) {
        this.idProduto = idProduto;
        this.dataProduto = dataProduto;
        this.nome = nome;
        this.estoqueMinimo = estoqueMinimo;
        this.unidMedida = unidMedida;
        this.precovenda = precovenda;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Date getDataProduto() {
        return dataProduto;
    }

    public void setDataProduto(Date dataProduto) {
        this.dataProduto = dataProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(String unidMedida) {
        this.unidMedida = unidMedida;
    }

    public BigDecimal getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(BigDecimal precovenda) {
        this.precovenda = precovenda;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.Produto[ idProduto=" + idProduto + " ]";
    }
    
}
