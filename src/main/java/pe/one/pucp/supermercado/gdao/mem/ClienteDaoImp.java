package pe.one.pucp.supermercado.gdao.mem;

import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.gdao.ClienteDao;
import pe.one.pucp.supermercado.gmodel.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteDaoImp
        extends AbstractGenericDao<Cliente>
        implements ClienteDao {

    protected Map<String, Cliente> clientes = new HashMap<String, Cliente>();

    @Override
    protected Cliente _insert(Cliente cliente) throws RuntimeException {
        clientes.put(cliente.getCoCliente(), cliente);
        return cliente;
    }

    @Override
    protected Cliente _update(Cliente cliente) throws RuntimeException {
        clientes.remove(cliente.getCoCliente());
        clientes.put(cliente.getCoCliente(), cliente);
        return cliente;
    }

    @Override
    protected void _delete(Object id) throws RuntimeException {
        clientes.remove(id);
    }

    @Override
    protected Cliente _find(Object id) throws RuntimeException {
        if(clientes.containsKey(id)) {
            return clientes.get(id);
        }
        return null;
    }

    @Override
    public List<Cliente> list() throws RuntimeException {
        return new ArrayList<Cliente>(clientes.values());
    }
}
