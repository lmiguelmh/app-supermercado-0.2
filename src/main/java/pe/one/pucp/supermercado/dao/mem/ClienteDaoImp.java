package pe.one.pucp.supermercado.dao.mem;

import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.ClienteDao;
import pe.one.pucp.supermercado.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class ClienteDaoImp
        extends AbstractGenericDao<Cliente>
        implements ClienteDao {

    private Map<String, Cliente> repository = new HashMap<String, Cliente>();

    @Override
    protected Cliente _insert(Cliente cliente) throws RuntimeException {
        repository.put(cliente.getCoCliente(), cliente);
        return cliente;
    }

    @Override
    protected Cliente _update(Cliente cliente) throws RuntimeException {
        repository.remove(cliente.getCoCliente());
        repository.put(cliente.getCoCliente(), cliente);
        return cliente;
    }

    @Override
    protected void _delete(Object id) throws RuntimeException {
        repository.remove(id);
    }

    @Override
    protected Cliente _find(Object id) throws RuntimeException {
        if(repository.containsKey(id)) {
            return repository.get(id);
        }
        return null;
    }

    @Override
    public List<Cliente> list() throws RuntimeException {
        return new ArrayList<Cliente>(repository.values());
    }
}
