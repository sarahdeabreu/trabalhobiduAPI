package sarah.com.br.provacliente.repository.cliente;

import sarah.com.br.provacliente.model.Cliente;
import sarah.com.br.provacliente.repository.filter.ClienteFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepositoryImpl implements ClienteRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Cliente> Filtrar(ClienteFilter clienteFilter, Pageable pageable){

    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
    Root<Cliente> root = criteria.from(Cliente.class);

    Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomeCliente")));

    TypedQuery<Cliente> query = manager.createQuery(criteria);

    return null;
  }


}
