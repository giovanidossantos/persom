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
import javax.persistence.Lob;
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
@Table(name = "orcamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o"),
    @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.orcamentoPK.idOrcamento = :idOrcamento"),
    @NamedQuery(name = "Orcamento.findByOrdemPrestacao", query = "SELECT o FROM Orcamento o WHERE o.ordemPrestacao = :ordemPrestacao"),
    @NamedQuery(name = "Orcamento.findByDataOrcamento", query = "SELECT o FROM Orcamento o WHERE o.dataOrcamento = :dataOrcamento"),
    @NamedQuery(name = "Orcamento.findByDataPrevistaOrca", query = "SELECT o FROM Orcamento o WHERE o.dataPrevistaOrca = :dataPrevistaOrca"),
    @NamedQuery(name = "Orcamento.findByDataEntregaProd", query = "SELECT o FROM Orcamento o WHERE o.dataEntregaProd = :dataEntregaProd"),
    @NamedQuery(name = "Orcamento.findByValorReparo", query = "SELECT o FROM Orcamento o WHERE o.valorReparo = :valorReparo"),
    @NamedQuery(name = "Orcamento.findBySinal", query = "SELECT o FROM Orcamento o WHERE o.sinal = :sinal"),
    @NamedQuery(name = "Orcamento.findByIdSerie", query = "SELECT o FROM Orcamento o WHERE o.idSerie = :idSerie"),
    @NamedQuery(name = "Orcamento.findByTipoProduto", query = "SELECT o FROM Orcamento o WHERE o.tipoProduto = :tipoProduto"),
    @NamedQuery(name = "Orcamento.findByModelo", query = "SELECT o FROM Orcamento o WHERE o.modelo = :modelo"),
    @NamedQuery(name = "Orcamento.findByMarca", query = "SELECT o FROM Orcamento o WHERE o.marca = :marca"),
    @NamedQuery(name = "Orcamento.findByClienteCPFCNPJ", query = "SELECT o FROM Orcamento o WHERE o.orcamentoPK.clienteCPFCNPJ = :clienteCPFCNPJ")})
public class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrcamentoPK orcamentoPK;
    @Basic(optional = false)
    @Column(name = "Ordem_Prestacao")
    private int ordemPrestacao;
    @Basic(optional = false)
    @Column(name = "Data_Orcamento")
    @Temporal(TemporalType.DATE)
    private Date dataOrcamento;
    @Basic(optional = false)
    @Column(name = "Data_Prevista_Orca")
    @Temporal(TemporalType.DATE)
    private Date dataPrevistaOrca;
    @Column(name = "Data_Entrega_Prod")
    @Temporal(TemporalType.DATE)
    private Date dataEntregaProd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor_Reparo")
    private BigDecimal valorReparo;
    @Column(name = "Sinal")
    private BigDecimal sinal;
    @Column(name = "idSerie")
    private Integer idSerie;
    @Column(name = "Tipo_Produto")
    private String tipoProduto;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Marca")
    private String marca;
    @Lob
    @Column(name = "Defeito_Reclamado")
    private String defeitoReclamado;
    @Lob
    @Column(name = "Causa_Provavel")
    private String causaProvavel;
    @Lob
    @Column(name = "Defeito_Encontrado")
    private String defeitoEncontrado;
    @Lob
    @Column(name = "Observacoes_Tecnicas")
    private String observacoesTecnicas;

    public Orcamento() {
    }

    public Orcamento(OrcamentoPK orcamentoPK) {
        this.orcamentoPK = orcamentoPK;
    }

    public Orcamento(OrcamentoPK orcamentoPK, int ordemPrestacao, Date dataOrcamento, Date dataPrevistaOrca) {
        this.orcamentoPK = orcamentoPK;
        this.ordemPrestacao = ordemPrestacao;
        this.dataOrcamento = dataOrcamento;
        this.dataPrevistaOrca = dataPrevistaOrca;
    }

    public Orcamento(int idOrcamento, String clienteCPFCNPJ) {
        this.orcamentoPK = new OrcamentoPK(idOrcamento, clienteCPFCNPJ);
    }

    public OrcamentoPK getOrcamentoPK() {
        return orcamentoPK;
    }

    public void setOrcamentoPK(OrcamentoPK orcamentoPK) {
        this.orcamentoPK = orcamentoPK;
    }

    public int getOrdemPrestacao() {
        return ordemPrestacao;
    }

    public void setOrdemPrestacao(int ordemPrestacao) {
        this.ordemPrestacao = ordemPrestacao;
    }

    public Date getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(Date dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public Date getDataPrevistaOrca() {
        return dataPrevistaOrca;
    }

    public void setDataPrevistaOrca(Date dataPrevistaOrca) {
        this.dataPrevistaOrca = dataPrevistaOrca;
    }

    public Date getDataEntregaProd() {
        return dataEntregaProd;
    }

    public void setDataEntregaProd(Date dataEntregaProd) {
        this.dataEntregaProd = dataEntregaProd;
    }

    public BigDecimal getValorReparo() {
        return valorReparo;
    }

    public void setValorReparo(BigDecimal valorReparo) {
        this.valorReparo = valorReparo;
    }

    public BigDecimal getSinal() {
        return sinal;
    }

    public void setSinal(BigDecimal sinal) {
        this.sinal = sinal;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDefeitoReclamado() {
        return defeitoReclamado;
    }

    public void setDefeitoReclamado(String defeitoReclamado) {
        this.defeitoReclamado = defeitoReclamado;
    }

    public String getCausaProvavel() {
        return causaProvavel;
    }

    public void setCausaProvavel(String causaProvavel) {
        this.causaProvavel = causaProvavel;
    }

    public String getDefeitoEncontrado() {
        return defeitoEncontrado;
    }

    public void setDefeitoEncontrado(String defeitoEncontrado) {
        this.defeitoEncontrado = defeitoEncontrado;
    }

    public String getObservacoesTecnicas() {
        return observacoesTecnicas;
    }

    public void setObservacoesTecnicas(String observacoesTecnicas) {
        this.observacoesTecnicas = observacoesTecnicas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orcamentoPK != null ? orcamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.orcamentoPK == null && other.orcamentoPK != null) || (this.orcamentoPK != null && !this.orcamentoPK.equals(other.orcamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.Orcamento[ orcamentoPK=" + orcamentoPK + " ]";
    }
    
}
