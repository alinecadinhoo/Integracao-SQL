package mock;

import DAO.IProdutoDAO;
import Exceptions.TipoChaveNaoEncontradaException;
import br.com.cadinho.domain.Cliente;
import br.com.cadinho.domain.Produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class ProdutoDaoMock implements IProdutoDAO {

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void excluir(String valor) {
        // TODO Auto-generated method stub

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub

    }

    @Override
    public Produto consultar(String valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return null;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {

    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }


    @Override
    public void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException {

    }

    @Override
    public void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {

    }

    @Override
    public void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {

    }

    @Override
    public void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {

    }

    @Override
    public void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException {

    }

    @Override
    public void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {

    }

    @Override
    public void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {

    }

    @Override
    public void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {

    }
}
