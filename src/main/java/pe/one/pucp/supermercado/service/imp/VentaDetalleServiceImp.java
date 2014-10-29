package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.GenericDao;
import pe.one.pucp.supermercado.dao.VentaDetalleDao;
import pe.one.pucp.supermercado.model.VentaDetalle;
import pe.one.pucp.supermercado.service.VentaDetalleService;

import java.util.List;

@Service
public class VentaDetalleServiceImp
        extends AbstractGenericService<VentaDetalle>
        implements VentaDetalleService {

    @Autowired
    VentaDetalleDao ventaDetalleDao;

    @Override
    protected GenericDao<VentaDetalle> getDao() {
        return ventaDetalleDao;
    }

    static final Object []tableHeader = new Object[] {"Código", "Código Venta", "Código Producto", "Cantidad", "Monto Total"};

    @Override
    protected Object[][] _getTableModelData(List<VentaDetalle> list) {
        Object [][]data = new Object[list.size()][tableHeader.length];
        for(int v=0; v<list.size(); v++) {
            data[v][0] = list.get(v).getCoVentaDetalle();
            data[v][1] = list.get(v).getCoVenta();
            data[v][2] = list.get(v).getCoProducto();
            data[v][3] = list.get(v).getCantidad();
            data[v][4] = list.get(v).getMontoTotal();
        }
        return data;
    }

    @Override
    protected Object[] _getTableModelHeader() {
        return tableHeader;
    }

    @Override
    public Integer getNextId() {
        return ventaDetalleDao.getNextId();
    }
}
