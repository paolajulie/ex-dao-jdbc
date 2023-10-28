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
    private String unidade;
    private Boolean status;

    public Estoque(Object object, Float custo2, String descricao2, int quantidade, int min2, int max2, boolean statusEstoque) {
    }

    public Estoque(Integer idEstoque, float custo, String descricao, Integer qtd, Integer min, Integer max, String unidade, Boolean status) {
        this.idEstoque = idEstoque;
        this.custo = custo;
        this.descricao = descricao;
        this.qtd = qtd;
        this.min = min;
        this.max = max;
        this.unidade = unidade;
        this.status = status;
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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
                + ", min=" + min + ", max=" + max + ", unidade=" + unidade + ", status=" + status + "]";
    }

    public void setQuantidade(int parseInt) {
    }

    public void setStatusEstoque(boolean parseBoolean) {
    }

    public int getQuantidade() {
        return 0;
    }

    public boolean getStatusEstoque() {
        return false;
    }
}
