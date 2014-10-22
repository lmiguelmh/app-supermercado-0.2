package pe.one.pucp.supermercado.gservice.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.gdao.ClienteDao;
import pe.one.pucp.supermercado.gmodel.Cliente;
import pe.one.pucp.supermercado.gservice.ClienteService;

import javax.swing.table.TableModel;
import java.util.List;

@Service
public class ClienteServiceImp
        implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

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
    public TableModel getTableModel() {
        return null;
    }

}
