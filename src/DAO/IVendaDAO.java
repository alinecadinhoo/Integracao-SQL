package DAO;

import DAO.Generics.IGenericDAO;
import Exceptions.DAOException;
import Exceptions.MaisDeUmRegistroException;
import Exceptions.TableException;
import Exceptions.TipoChaveNaoEncontradaException;
import br.com.cadinho.domain.Venda;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    Class<Venda> getTipoClasse();

    void atualiarDados(Venda entity, Venda entityCadastrado);

    void excluir(String valor);

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    void setParametrosQueryInsercao(PreparedStatement stmInsert, Venda entity) throws SQLException;

    void setParametrosQueryExclusao(PreparedStatement stmInsert, String valor) throws SQLException;

    void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Venda entity) throws SQLException;

    void setParametrosQuerySelect(PreparedStatement stm, String valor) throws SQLException;

    Venda consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException;

    Collection<Venda> buscarTodos() throws DAOException;

    Boolean cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException;
}
