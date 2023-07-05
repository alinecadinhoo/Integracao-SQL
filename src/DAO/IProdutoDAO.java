package DAO;

import DAO.Generics.IGenericDAO;
import br.com.cadinho.domain.Cliente;
import br.com.cadinho.domain.Produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public interface IProdutoDAO extends IGenericDAO<Produto, String> {

    Class<Produto> getTipoClasse();

    void atualiarDados(Produto entity, Produto entityCadastrado);

    void atualiarDados(Cliente entity, Cliente entityCadastrado);

    void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException;

    void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException;

    void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException;

    void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException;

    void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException;

    void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException;

    void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException;

    void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException;
}
