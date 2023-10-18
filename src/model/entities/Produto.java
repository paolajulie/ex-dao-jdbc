package model.entities;

import java.io.Serializable;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String preco;
    private String validade;
    private String unidade;

    public Produto() {
    }

    public Produto(Integer id, String nome, String preco, String validade, String unidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.unidade = unidade;
    }

    public Produto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getter e Setter para id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para preco
    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    // Getter e Setter para validade
    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    // Getter e Setter para unidade
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
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
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                ", validade='" + validade + '\'' +
                ", unidade='" + unidade + '\'' +
                '}';
    }
}
