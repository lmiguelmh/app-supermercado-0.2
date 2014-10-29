package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.GenericDao;
import pe.one.pucp.supermercado.dao.ProductoDao;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.service.ProductoService;

import java.util.List;

@Service
public class ProductoServiceImp
        extends AbstractGenericService<Producto>
        implements ProductoService {

    @Autowired
    ProductoDao productoDao;

    @Override
    protected GenericDao<Producto> getDao() {
        return productoDao;
    }

    static final Object []tableHeader = new Object[] {"Código", "Nombre", "PrecioCompra", "PrecioVenta", "Inventario"};

    @Override
    protected Object[][] _getTableModelData(List<Producto> list) {
        //List<Producto> list = list();
        Object [][]data = new Object[list.size()][tableHeader.length];
        for(int v=0; v<list.size(); v++) {
            data[v][0] = list.get(v).getCoProducto();
            data[v][1] = list.get(v).getNoProducto();
            data[v][2] = list.get(v).getPrecioCompra();
            data[v][3] = list.get(v).getPrecioVenta();
            data[v][4] = list.get(v).getInventario();
        }
        return data;
    }

    @Override
    protected Object[] _getTableModelHeader() {
        return tableHeader;
    }

}
