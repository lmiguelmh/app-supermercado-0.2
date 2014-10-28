package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.InventarioDao;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.InventarioService;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

/**
 * Clase InventarioImpService.
 *
 * @author lmiguelmh
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

    @Override
    public TableModel getProductoTableModel() {
        List<Producto> list = listProducto();
        Object []header = new Object[] {"Código", "Nombre", "PrecioCompra", "PrecioVenta", "Inventario"};
        Object [][]data = new Object[list.size()][5];
        for(int v=0; v<list.size(); v++) {
            data[v][0] = list.get(v).getCoProducto();
            data[v][1] = list.get(v).getNoProducto();
            data[v][2] = list.get(v).getPrecioCompra();
            data[v][3] = list.get(v).getPrecioVenta();
            data[v][4] = list.get(v).getInventario();
        }
        return new DefaultTableModel(data, header);
    }

    @Override
    public Producto getProducto(String codigo) {
        return inventarioDao.getProducto(codigo);
    }

    @Override
    public void deleteProducto(Producto producto) {
        inventarioDao.deleteProducto(producto);
    }
}
