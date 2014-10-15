package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.InventarioDao;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.service.InventarioService;

import java.util.List;

/**
 * Clase InventarioImpService.
 *
 * @author lmamani[at]reniec.gob.pe
 *         lmiguelmh[at]gmail[dot]com
 * @version 0.0.1
 * @since 15/10/2014 10:22 AM
 */
@Service
public class InventarioImpService implements InventarioService {

    @Autowired
    InventarioDao inventarioDao;

    @Override
    public List<Producto> listProducto() {
        return inventarioDao.listProducto();
    }

    @Override
    public String getListProductoString() {
        List<Producto> list = listProducto();
        StringBuffer sb = new StringBuffer();
        for(Producto producto:list) {
            sb.append(producto).append(" ");
        }
        return sb.toString();
    }

    @Override
    public void insertOrUpdateProducto(Producto producto) {
        inventarioDao.insertOrUpdateProducto(producto);
    }
}
