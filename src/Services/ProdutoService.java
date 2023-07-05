package Services;

import DAO.IProdutoDAO;
import Services.Generics.GenericService;
import br.com.cadinho.domain.Produto;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}

