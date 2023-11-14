package model.entities;

import java.io.Serializable;

public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEstoque;
    private float custo;
    private String descricao;
    private Integer qtd;
    private Integer min;
    private Integer max;
    private Boolean statusEstoque;

    public Estoque(Integer o, Float custo, String descricao, int quantidade, int min, int max, boolean statusEstoque) {
    }

    public Estoque(Integer idEstoque, float custo, String descricao, Integer qtd, Integer min, Integer max, Boolean statusEstoque) {
        this.idEstoque = idEstoque;
        this.custo = custo;
        this.descricao = descricao;
        this.qtd = qtd;
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

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
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

    public Boolean getStatusEstoque() {
        return statusEstoque;
    }

    public void setStatusEstoque(Boolean statusEstoque) {
        this.statusEstoque = statusEstoque;
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
            if (other.idEstoque != null)
                return false;
        } else if (!idEstoque.equals(other.idEstoque))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estoque [idEstoque=" + idEstoque + ", custo=" + custo + ", descricao=" + descricao + ", qtd=" + qtd
                + ", min=" + min + ", max=" + max + ", status=" + statusEstoque + "]";
    }
}
