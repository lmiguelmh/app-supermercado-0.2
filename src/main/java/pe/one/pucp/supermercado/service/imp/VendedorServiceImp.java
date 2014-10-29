package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.GenericDao;
import pe.one.pucp.supermercado.dao.VendedorDao;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.VendedorService;

import java.util.List;

@Service
public class VendedorServiceImp
        extends AbstractGenericService<Vendedor>
        implements VendedorService {

    @Autowired
    VendedorDao vendedorDao;

    @Override
    protected GenericDao<Vendedor> getDao() {
        return vendedorDao;
    }

    static final Object []tableHeader = new Object[] {"Código", "Nombre", "Estado"};

    @Override
    protected Object[][] _getTableModelData() {
        List<Vendedor> list = list();
        Object [][]data = new Object[list.size()][tableHeader.length];
        for(int v=0; v<list.size(); v++) {
            data[v][0] = list.get(v).getCoVendedor();
            data[v][1] = list.get(v).getNoVendedor();
            data[v][2] = list.get(v).getEsVendedor();
        }
        return data;
    }

    @Override
    protected Object[] _getTableModelHeader() {
        return tableHeader;
    }

}
