package pe.one.pucp.supermercado.service;

import pe.one.pucp.supermercado.model.Producto;

import javax.swing.table.TableModel;
import java.util.List;

/**
 * Clase InventarioService.
 *
 * @author lmiguelmh
 * @version 0.0.1
 * @since 15/10/2014 10:21 AM
 */
public interface InventarioService {
    List<Producto> listProducto();
    String getListProductoString();
    void insertOrUpdateProducto(Producto producto);

    TableModel getProductoTableModel();

    Producto getProducto(String codigo);

    void deleteProducto(Producto producto);
}
