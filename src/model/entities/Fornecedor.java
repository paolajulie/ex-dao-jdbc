package model.entities;

import java.io.Serializable;

public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFornecedor;
    private String nome;
    private String cnpj;
    private String localizacao;
    private String contato;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor, String nome, String cnpj, String localizacao, String contato) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.localizacao = localizacao;
        this.contato = contato;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idFornecedor == null) ? 0 : idFornecedor.hashCode());
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
        Fornecedor other = (Fornecedor) obj;
        if (idFornecedor == null) {
            if (other.idFornecedor != null)
                return false;
        } else if (!idFornecedor.equals(other.idFornecedor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor [idFornecedor=" + idFornecedor + ", nome=" + nome + ", cnpj=" + cnpj + ", localizacao=" + localizacao + ", contato=" + contato + "]";
    }
}
