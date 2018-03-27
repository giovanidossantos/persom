/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Giovani dos Santos
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCpfCnpj", query = "SELECT c FROM Cliente c WHERE c.cpfCnpj = :cpfCnpj"),
    @NamedQuery(name = "Cliente.findByNomeRazao", query = "SELECT c FROM Cliente c WHERE c.nomeRazao = :nomeRazao"),
    @NamedQuery(name = "Cliente.findByTipoPessoa", query = "SELECT c FROM Cliente c WHERE c.tipoPessoa = :tipoPessoa"),
    @NamedQuery(name = "Cliente.findByInscricaoMunicipal", query = "SELECT c FROM Cliente c WHERE c.inscricaoMunicipal = :inscricaoMunicipal"),
    @NamedQuery(name = "Cliente.findByInscricaoEstadual", query = "SELECT c FROM Cliente c WHERE c.inscricaoEstadual = :inscricaoEstadual"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;
    @Basic(optional = false)
    @Column(name = "Nome_Razao")
    private String nomeRazao;
    @Column(name = "Tipo_Pessoa")
    private String tipoPessoa;
    @Column(name = "Inscricao_Municipal")
    private String inscricaoMunicipal;
    @Column(name = "Inscricao_Estadual")
    private String inscricaoEstadual;
    @Column(name = "Email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Telefone> telefoneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Endereco> enderecoCollection;

    public Cliente() {
    }

    public Cliente(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Cliente(String cpfCnpj, String nomeRazao) {
        this.cpfCnpj = cpfCnpj;
        this.nomeRazao = nomeRazao;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<Telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfCnpj != null ? cpfCnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cpfCnpj == null && other.cpfCnpj != null) || (this.cpfCnpj != null && !this.cpfCnpj.equals(other.cpfCnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.Cliente[ cpfCnpj=" + cpfCnpj + " ]";
    }
    
}
