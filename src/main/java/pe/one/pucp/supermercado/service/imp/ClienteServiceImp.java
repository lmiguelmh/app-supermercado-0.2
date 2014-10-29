package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.ClienteDao;
import pe.one.pucp.supermercado.dao.GenericDao;
import pe.one.pucp.supermercado.model.Cliente;
import pe.one.pucp.supermercado.service.ClienteService;

import java.util.List;

@Service
public class ClienteServiceImp
        extends AbstractGenericService<Cliente>
        implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Override
    protected GenericDao<Cliente> getDao() {
        return clienteDao;
    }

    static final Object []tableHeader = new Object[] {"Código", "Nombre", "Clasificación"};

    @Override
    protected Object[][] _getTableModelData(List<Cliente> list) {
        //List<Cliente> list = list();
        Object [][]data = new Object[list.size()][tableHeader.length];
        for(int v=0; v<list.size(); v++) {
            data[v][0] = list.get(v).getCoCliente();
            data[v][1] = list.get(v).getNoCliente();
            data[v][2] = list.get(v).getClasificacion();
        }
        return data;
    }

    @Override
    protected Object[] _getTableModelHeader() {
        return tableHeader;
    }

}
