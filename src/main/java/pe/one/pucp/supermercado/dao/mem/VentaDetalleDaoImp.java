package pe.one.pucp.supermercado.dao.mem;

import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.VentaDetalleDao;
import pe.one.pucp.supermercado.model.VentaDetalle;

import java.util.*;

@Repository
public class VentaDetalleDaoImp
        extends AbstractGenericDao<VentaDetalle>
        implements VentaDetalleDao {

    private Map<Integer, VentaDetalle> repository = new HashMap<Integer, VentaDetalle>();

    @Override
    protected VentaDetalle _insert(VentaDetalle ventaDetalle) throws RuntimeException {
        repository.put(ventaDetalle.getCoVentaDetalle(), ventaDetalle);
        return ventaDetalle;
    }

    @Override
    protected VentaDetalle _update(VentaDetalle ventaDetalle) throws RuntimeException {
        repository.remove(ventaDetalle.getCoVentaDetalle());
        repository.put(ventaDetalle.getCoVentaDetalle(), ventaDetalle);
        return ventaDetalle;
    }

    @Override
    protected void _delete(Object id) throws RuntimeException {
        repository.remove(id);
    }

    @Override
    protected VentaDetalle _find(Object id) throws RuntimeException {
        if(repository.containsKey(id)) {
            return repository.get(id);
        }
        return null;
    }

    @Override
    public List<VentaDetalle> list() throws RuntimeException {
        return new ArrayList<VentaDetalle>(repository.values());
    }

    @Override
    public List<VentaDetalle> listLikeId(Object id) throws RuntimeException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer getNextId() {
        if(repository.size()==0) {
            return 1;
        } else {
            Integer maxId = Collections.max(repository.keySet());
            return maxId + 1;
        }
    }
}
