package pe.one.pucp.supermercado.dao;

import pe.one.pucp.supermercado.model.Producto;

import java.util.List;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
public interface InventarioDao {
    void insertOrUpdateProducto(Producto producto);
    Producto getProducto(String coProducto);
    List<Producto> listProducto();

    void deleteProducto(Producto producto);
}
