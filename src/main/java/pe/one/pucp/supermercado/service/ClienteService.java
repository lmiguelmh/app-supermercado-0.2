package pe.one.pucp.supermercado.service;

import pe.one.pucp.supermercado.model.Cliente;
import pe.one.pucp.supermercado.model.Producto;

import javax.swing.table.TableModel;
import java.util.List;

public interface ClienteService {

    List<Cliente> listCliente();

    void insertOrUpdateCliente(Cliente cliente);

    TableModel getClienteTableModel();

    Cliente getCliente(String codigo);

    void deleteCliente(Cliente cliente);
}
