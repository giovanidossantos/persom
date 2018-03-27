/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
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
@Table(name = "telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t"),
    @NamedQuery(name = "Telefone.findByIdTelefone", query = "SELECT t FROM Telefone t WHERE t.telefonePK.idTelefone = :idTelefone"),
    @NamedQuery(name = "Telefone.findByTelefoneResidencial", query = "SELECT t FROM Telefone t WHERE t.telefoneResidencial = :telefoneResidencial"),
    @NamedQuery(name = "Telefone.findByTelefoneComercial", query = "SELECT t FROM Telefone t WHERE t.telefoneComercial = :telefoneComercial"),
    @NamedQuery(name = "Telefone.findByCelular", query = "SELECT t FROM Telefone t WHERE t.celular = :celular"),
    @NamedQuery(name = "Telefone.findByOperadora", query = "SELECT t FROM Telefone t WHERE t.operadora = :operadora"),
    @NamedQuery(name = "Telefone.findByClienteCPFCNPJ", query = "SELECT t FROM Telefone t WHERE t.telefonePK.clienteCPFCNPJ = :clienteCPFCNPJ")})
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefonePK telefonePK;
    @Column(name = "Telefone_Residencial")
    private String telefoneResidencial;
    @Column(name = "Telefone_Comercial")
    private String telefoneComercial;
    @Column(name = "Celular")
    private String celular;
    @Column(name = "Operadora")
    private String operadora;
    @JoinColumn(name = "Cliente_CPF_CNPJ", referencedColumnName = "CPF_CNPJ", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(TelefonePK telefonePK) {
        this.telefonePK = telefonePK;
    }

    public Telefone(int idTelefone, String clienteCPFCNPJ) {
        this.telefonePK = new TelefonePK(idTelefone, clienteCPFCNPJ);
    }

    public TelefonePK getTelefonePK() {
        return telefonePK;
    }

    public void setTelefonePK(TelefonePK telefonePK) {
        this.telefonePK = telefonePK;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
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
        hash += (telefonePK != null ? telefonePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.telefonePK == null && other.telefonePK != null) || (this.telefonePK != null && !this.telefonePK.equals(other.telefonePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persom.model.Telefone[ telefonePK=" + telefonePK + " ]";
    }
    
}
