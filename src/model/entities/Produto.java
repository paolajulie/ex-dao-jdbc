package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Float preco;
    private Date vali;
    private String uni;

    public Produto() {
    }

    public Produto(Integer id, String nome, Float preco, Date vali, String uni) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.vali = vali;
        this.uni = uni;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Date getVali() {
        return vali;
    }

    public void setVali(Date vali) {
        this.vali = vali;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", vali=" + (vali != null ? sdf.format(vali) : "null") +
                ", uni='" + uni + '\'' +
                '}';
    }
}
