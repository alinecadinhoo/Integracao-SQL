package DAO;

import DAO.Generics.GenericDAO;
import DAO.Generics.IGenericDAO;
import br.com.cadinho.domain.Estoque;

public interface IEstoqueDAO extends IGenericDAO<Estoque, Long> {

    Class<Estoque> getTipoClasse();

    void atualizar(Estoque estoque);
}