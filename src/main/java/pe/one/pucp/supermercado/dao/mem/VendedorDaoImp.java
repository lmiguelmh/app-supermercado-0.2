package pe.one.pucp.supermercado.dao.mem;

import pe.one.pucp.supermercado.dao.VendedorDao;
import pe.one.pucp.supermercado.model.Vendedor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class VendedorDaoImp
        extends AbstractGenericDao<Vendedor>
        implements VendedorDao {

    private Map<String, Vendedor> repository = new HashMap<String, Vendedor>();

    @Override
    protected Vendedor _insert(Vendedor vendedor) throws RuntimeException {
        repository.put(vendedor.getCoVendedor(), vendedor);
        return vendedor;
    }

    @Override
    protected Vendedor _update(Vendedor vendedor) throws RuntimeException {
        repository.remove(vendedor.getCoVendedor());
        repository.put(vendedor.getCoVendedor(), vendedor);
        return vendedor;
    }

    @Override
    protected void _delete(Object id) throws RuntimeException {
        repository.remove(id);
    }

    @Override
    protected Vendedor _find(Object id) throws RuntimeException {
        if(repository.containsKey(id)) {
            return repository.get(id);
        }
        return null;
    }

    @Override
    public List<Vendedor> list() throws RuntimeException {
        return new ArrayList<Vendedor>(repository.values());
    }

    @Override
    public List<Vendedor> listLikeId(Object id) throws RuntimeException {
        throw new UnsupportedOperationException();
    }
}
