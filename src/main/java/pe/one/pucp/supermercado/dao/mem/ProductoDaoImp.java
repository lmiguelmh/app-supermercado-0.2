package pe.one.pucp.supermercado.dao.mem;

import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.ProductoDao;
import pe.one.pucp.supermercado.model.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductoDaoImp
        extends AbstractGenericDao<Producto>
        implements ProductoDao {

    private Map<String, Producto> repository = new HashMap<String, Producto>();

    @Override
    protected Producto _insert(Producto cliente) throws RuntimeException {
        repository.put(cliente.getCoProducto(), cliente);
        return cliente;
    }

    @Override
    protected Producto _update(Producto cliente) throws RuntimeException {
        repository.remove(cliente.getCoProducto());
        repository.put(cliente.getCoProducto(), cliente);
        return cliente;
    }

    @Override
    protected void _delete(Object id) throws RuntimeException {
        repository.remove(id);
    }

    @Override
    protected Producto _find(Object id) throws RuntimeException {
        if(repository.containsKey(id)) {
            return repository.get(id);
        }
        return null;
    }

    @Override
    public List<Producto> list() throws RuntimeException {
        return new ArrayList<Producto>(repository.values());
    }
}
