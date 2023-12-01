/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author bolin
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto"),
    @NamedQuery(name = "Produto.findByProdutonome", query = "SELECT p FROM Produto p WHERE p.produtonome = :produtonome"),
    @NamedQuery(name = "Produto.findByProdutomarca", query = "SELECT p FROM Produto p WHERE p.produtomarca = :produtomarca"),
    @NamedQuery(name = "Produto.findByProdutopreco", query = "SELECT p FROM Produto p WHERE p.produtopreco = :produtopreco"),
    @NamedQuery(
        name = "Produto.updateProduto",
        query = "UPDATE Produto "
                + "SET produtonome = p.produtonome,"
                + "produtomarca = p.produtomarca,"
                + "produtopreco = p.produtopreco "
                + "WHERE p.idproduto = :idproduto")
})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idproduto;
    private String produtonome;
    private String produtomarca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double produtopreco;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getProdutonome() {
        return produtonome;
    }

    public void setProdutonome(String produtonome) {
        this.produtonome = produtonome;
    }

    public String getProdutomarca() {
        return produtomarca;
    }

    public void setProdutomarca(String produtomarca) {
        this.produtomarca = produtomarca;
    }

    public Double getProdutopreco() {
        return produtopreco;
    }

    public void setProdutopreco(Double produtopreco) {
        this.produtopreco = produtopreco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
