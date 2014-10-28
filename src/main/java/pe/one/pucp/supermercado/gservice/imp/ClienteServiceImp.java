package pe.one.pucp.supermercado.gservice.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.gdao.ClienteDao;
import pe.one.pucp.supermercado.gmodel.Cliente;
import pe.one.pucp.supermercado.gservice.ClienteService;

import java.util.List;

@Service
public class ClienteServiceImp
        extends AbstractGenericService<Cliente>
        implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    static final Object []tableHeader = new Object[] {"Código", "Nombre", "Clasif"};

    @Override
    public List<Cliente> list() throws RuntimeException {
        return clienteDao.list();
    }

    @Override
    public Cliente insertOrUpdate(Cliente cliente) throws RuntimeException {
        return clienteDao.insertOrUpdate(cliente);
    }

    @Override
    public void delete(Object id) throws RuntimeException {
        clienteDao.delete(id);
    }

    @Override
    public Cliente find(Object id) throws RuntimeException {
        return clienteDao.find(id);
    }

    @Override
    protected Object[][] _getTableModelData() {
        List<Cliente> list = list();
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
