package DAO;

import DAO.Generics.IGenericDAO;
import br.com.cadinho.domain.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {


    Class<Cliente> getTipoClasse();
}
