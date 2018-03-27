/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giovani dos Santos
 */
@Entity
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByIdEndereco", query = "SELECT e FROM Endereco e WHERE e.enderecoPK.idEndereco = :idEndereco"),
    @NamedQuery(name = "Endereco.findByNomeendereco", query = "SELECT e FROM Endereco e WHERE e.nomeendereco = :nomeendereco"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep"),
    @NamedQuery(name = "Endereco.findByCidade", query = "SELECT e FROM Endereco e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "Endereco.findByEstado", query = "SELECT e FROM Endereco e WHERE e.estado = :estado"),
    @NamedQuery(name = "Endereco.findByClienteCPFCNPJ", query = "SELECT e FROM Endereco e WHERE e.enderecoPK.clienteCPFCNPJ = :clienteCPFCNPJ")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnderecoPK enderecoPK;
    @Basic(optional = false)
    @Column(name = "Nome_endereco")
    private String nomeendereco;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "Cidade")
    private String cidade;
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "Cliente_CPF_CNPJ", referencedColumnName = "CPF_CNPJ", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(EnderecoPK enderecoPK) {
        this.enderecoPK = enderecoPK;
    }

    public Endereco(EnderecoPK enderecoPK, String nomeendereco) {
        this.enderecoPK = enderecoPK;
        this.nomeendereco = nomeendereco;
    }

    public Endereco(int idEndereco, String clienteCPFCNPJ) {
        this.enderecoPK = new EnderecoPK(idEndereco, clienteCPFCNPJ);
    }

    public EnderecoPK getEnderecoPK() {
        return enderecoPK;
    }

    public void setEnderecoPK(EnderecoPK enderecoPK) {
        this.enderecoPK = enderecoPK;
    }

    public String getNomeendereco() {
        return nomeendereco;
    }

    public void setNomeendereco(String nomeendereco) {
        this.nomeendereco = nomeendereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enderecoPK != null ? enderecoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.enderecoPK == null && other.enderecoPK != null) || (this.enderecoPK != null && !this.enderecoPK.equals(other.enderecoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.Endereco[ enderecoPK=" + enderecoPK + " ]";
    }
    
}
