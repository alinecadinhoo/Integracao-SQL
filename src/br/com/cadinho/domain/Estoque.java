package br.com.cadinho.domain;

import Anotacao.ColunaTabela;
import Anotacao.Tabela;
import DAO.Persistente;

import java.math.BigDecimal;
import java.sql.Date;

@Tabela("TB_ESTOQUE")
public class Estoque implements Persistente {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "codigo_produto", setJavaName = "setCodigoProduto")
    private String codigoProduto;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private BigDecimal quantidade;

    @ColunaTabela(dbName = "data_atualizacao", setJavaName = "setDataAtualizacao")
    private Date dataAtualizacao;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getCodigo() {
        return null;
    }

    public void setCodigo(String codigo) {
    }
}
