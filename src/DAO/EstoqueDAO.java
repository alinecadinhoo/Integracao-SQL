package DAO;

import DAO.Generics.GenericDAO;
import br.com.cadinho.domain.Estoque;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO {

    public EstoqueDAO() {
        super();
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setCodigoProduto(entity.getCodigoProduto());
        entityCadastrado.setQuantidade(entity.getQuantidade());
        entityCadastrado.setDataAtualizacao(entity.getDataAtualizacao());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_ESTOQUE ");
        sb.append("(ID, CODIGO_PRODUTO, QUANTIDADE, DATA_ATUALIZACAO)");
        sb.append(" VALUES (nextval('sq_estoque'), ?, ?, ?)");
        return sb.toString();
    }

    @Override
    public void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigoProduto());
        stmInsert.setBigDecimal(2, entity.getQuantidade());
        stmInsert.setDate(3, entity.getDataAtualizacao());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE ID = ?";
    }

    @Override
    public void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
        stmExclusao.setLong(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_ESTOQUE ");
        sb.append("SET CODIGO_PRODUTO = ?,");
        sb.append("QUANTIDADE = ?,");
        sb.append("DATA_ATUALIZACAO = ?");
        sb.append(" WHERE ID = ?");
        return sb.toString();
    }

    @Override
    public void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigoProduto());
        stmUpdate.setBigDecimal(2, entity.getQuantidade());
        stmUpdate.setDate(3, entity.getDataAtualizacao());
        stmUpdate.setLong(4, entity.getId());
    }

    @Override
    public void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }
}