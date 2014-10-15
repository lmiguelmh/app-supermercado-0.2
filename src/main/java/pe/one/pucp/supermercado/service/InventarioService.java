package pe.one.pucp.supermercado.service;

import pe.one.pucp.supermercado.model.Producto;

import java.util.List;

/**
 * Clase InventarioService.
 *
 * @author lmamani[at]reniec.gob.pe
 *         lmiguelmh[at]gmail[dot]com
 * @version 0.0.1
 * @since 15/10/2014 10:21 AM
 */
public interface InventarioService {
    List<Producto> listProducto();
    String getListProductoString();
    void insertOrUpdateProducto(Producto producto);
}
