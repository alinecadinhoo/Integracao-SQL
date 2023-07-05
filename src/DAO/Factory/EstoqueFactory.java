package DAO.Factory;


import br.com.cadinho.domain.Estoque;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueFactory {

    public static Estoque convert(ResultSet rs) throws SQLException {
        Estoque estoque = new Estoque();
        estoque.setId(rs.getLong("ID_ESTOQUE"));
        estoque.setCodigoProduto(rs.getString("CODIGO DO PRODUTO"));
        estoque.setQuantidade(rs.getBigDecimal("QUANTIDADE"));
        estoque.setDataAtualizacao(rs.getDate("DATA ATUALIZACAO"));
        return estoque;
    }
}