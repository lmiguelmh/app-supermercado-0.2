package pe.one.pucp.supermercado.dao;

import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.model.Producto;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
public interface InventarioDao {
    void insertOrUpdateProducto(Producto producto);
    Producto getProducto(String coProducto);
}
