package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProduto;
    private String nome;
    private String unidade;
    private Date validade;
    private Float preco;

    public Produto() {
    }

    public Produto(Integer idProduto, String nome, String unidade, Date validade, Float preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.unidade = unidade;
        this.validade = validade;
        this.preco = preco;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (idProduto == null) {
            if (other.idProduto != null)
                return false;
        } else if (!idProduto.equals(other.idProduto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", unidade=" + unidade + ", validade=" + validade + ", preco=" + preco + "]";
    }
}
