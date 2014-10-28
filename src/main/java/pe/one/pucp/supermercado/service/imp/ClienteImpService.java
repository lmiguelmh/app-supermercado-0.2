package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.ClienteDao;
import pe.one.pucp.supermercado.model.Cliente;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.service.ClienteService;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

@Service
public class ClienteImpService implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Override
    public List<Cliente> listCliente() {
        return clienteDao.listCliente();
    }

    @Override
    public void insertOrUpdateCliente(Cliente cliente) {
        clienteDao.insertOrUpdateCliente(cliente);
    }

    @Override
    public TableModel getClienteTableModel() {
        List<Cliente> list = listCliente();
        Object []header = new Object[] {"Código", "Nombre", "Clasif"};
        Object [][]data = new Object[list.size()][3];
        for(int v=0; v<list.size(); v++) {
            data[v][0] = list.get(v).getCoCliente();
            data[v][1] = list.get(v).getNoCliente();
            data[v][2] = list.get(v).getClasificacion();
        }
        return new DefaultTableModel(data, header);
    }

    @Override
    public Cliente getCliente(String codigo) {
        return clienteDao.getCliente(codigo);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteDao.deleteCliente(cliente);
    }
}
