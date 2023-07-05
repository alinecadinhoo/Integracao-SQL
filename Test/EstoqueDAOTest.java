import DAO.EstoqueDAO;
import DAO.IEstoqueDAO;
import Exceptions.DAOException;
import Exceptions.MaisDeUmRegistroException;
import Exceptions.TableException;
import Exceptions.TipoChaveNaoEncontradaException;
import br.com.cadinho.domain.Estoque;
import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;

public class EstoqueDAOTest {

    private IEstoqueDAO estoqueDao;

    public EstoqueDAOTest() {
        estoqueDao = new EstoqueDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Estoque> list = estoqueDao.buscarTodos();
        list.forEach(estoque -> {
            try {
                estoqueDao.excluir(Long.valueOf(estoque.getCodigo()));
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    private Estoque criarEstoque(String codigo, int quantidade, Date dataAtualizacao) throws TipoChaveNaoEncontradaException, DAOException {
        Estoque estoque = new Estoque();
        estoque.setCodigo(codigo);
        estoque.setQuantidade(BigDecimal.valueOf(quantidade));
        estoque.setDataAtualizacao((java.sql.Date) dataAtualizacao);
        estoqueDao.cadastrar(estoque);
        return estoque;
    }

    private void excluir(String codigo) throws DAOException {
        this.estoqueDao.excluir(Long.valueOf(codigo));
    }

    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        Date dataAtualizacao = new Date();
        Estoque estoque = criarEstoque("A1", 10, dataAtualizacao);
        assertNotNull(estoque);
        Estoque estoqueDB = this.estoqueDao.consultar(Long.valueOf(estoque.getCodigo()));
        assertNotNull(estoqueDB);
        excluir(String.valueOf(estoqueDB.getCodigo()));
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
        Date dataAtualizacao = new Date();
        Estoque estoque = criarEstoque("A2", 10, dataAtualizacao);
        assertNotNull(estoque);
        excluir(String.valueOf(estoque.getCodigo()));
    }

    @Test
    public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Date dataAtualizacao = new Date();
        Estoque estoque = criarEstoque("A3", 10, dataAtualizacao);
        assertNotNull(estoque);
        excluir(estoque.getCodigo());
        Estoque estoqueBD = this.estoqueDao.consultar(Long.valueOf(estoque.getCodigo()));
        assertNull(estoqueBD);
    }

    @Test
    public void alterarEstoque() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Date dataAtualizacao = new Date();
        Estoque estoque = criarEstoque("A4", 10, dataAtualizacao);
        estoque.setQuantidade(BigDecimal.valueOf(20));
        estoqueDao.alterar(estoque);
        Estoque estoqueBD = this.estoqueDao.consultar(Long.valueOf(estoque.getCodigo()));
        assertNotNull(estoqueBD);
        assertEquals(20, estoqueBD.getQuantidade());

        excluir(estoque.getCodigo());
        Estoque estoqueBD1 = this.estoqueDao.consultar(Long.valueOf(estoque.getCodigo()));
        assertNull(estoqueBD1);
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        Date dataAtualizacao = new Date();
        criarEstoque("A5", 10, dataAtualizacao);
        criarEstoque("A6", 20, dataAtualizacao);
        Collection<Estoque> list = estoqueDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        for (Estoque estoque : list) {
            excluir(estoque.getCodigo());
        }

        list = estoqueDao.buscarTodos();
        assertNotNull(list);
        assertEquals(0, list.size());
    }
}