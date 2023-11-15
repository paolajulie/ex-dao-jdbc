package model.entities;

import java.io.Serializable;

public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEstoque;
    private float custo;
    private String descricao;
    private Integer quantidade;
    private Integer min;
    private Integer max;
    private Boolean statusEstoque;


    public Estoque(Integer idEstoque, Float custo, String descricao, Integer quantidade, Integer min, Integer max, Boolean statusEstoque) {
        this.idEstoque = idEstoque;
        this.custo = custo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.min = min;
        this.max = max;
        this.statusEstoque = statusEstoque;
    }


    public Estoque() {
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float f) {
        this.custo = f;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setStatusEstoque(Boolean statusEstoque) {
        this.statusEstoque = statusEstoque;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Boolean getStatusEstoque() {
        return statusEstoque;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEstoque == null) ? 0 : idEstoque.hashCode());
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
        Estoque other = (Estoque) obj;
        if (idEstoque == null) {
            return other.idEstoque == null;
        } else return idEstoque.equals(other.idEstoque);
    }

    @Override
    public String toString() {
        return "Estoque [idEstoque=" + idEstoque + ", custo=" + custo + ", descricao=" + descricao + ", quantidade=" + quantidade
                + ", min=" + min + ", max=" + max + ",  statusEstoque=" + statusEstoque + "]";
    }
}

