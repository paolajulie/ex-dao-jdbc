package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEntrada;
    private String observacao;
    private Date dataEntrada;

    public Entrada() {
    }

    public Entrada(Integer idEntrada, String observacao, Date dataEntrada) {
        this.idEntrada = idEntrada;
        this.observacao = observacao;
        this.dataEntrada = dataEntrada;
    }

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEntrada == null) ? 0 : idEntrada.hashCode());
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
        Entrada other = (Entrada) obj;
        if (idEntrada == null) {
            if (other.idEntrada != null)
                return false;
        } else if (!idEntrada.equals(other.idEntrada))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Entrada [idEntrada=" + idEntrada + ", observacao=" + observacao + ", dataEntrada=" + dataEntrada + "]";
    }
}
