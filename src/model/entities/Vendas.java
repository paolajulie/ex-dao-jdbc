package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Vendas implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idVendas;
    private String observacao;
    private Date dataSaida;

    public Vendas() {
    }

    public Vendas(Integer idVendas, String observacao, Date dataSaida) {
        this.idVendas = idVendas;
        this.observacao = observacao;
        this.dataSaida = dataSaida;
    }

    public Integer getIdVendas() {
        return idVendas;
    }

    public void setIdVendas(Integer idVendas) {
        this.idVendas = idVendas;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idVendas == null) ? 0 : idVendas.hashCode());
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
        Vendas other = (Vendas) obj;
        if (idVendas == null) {
            if (other.idVendas != null)
                return false;
        } else if (!idVendas.equals(other.idVendas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vendas [idVendas=" + idVendas + ", observacao=" + observacao + ", dataSaida=" + dataSaida + "]";
    }
}
