package pe.one.pucp.supermercado.dao;

import pe.one.pucp.supermercado.model.Cliente;

import java.util.List;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
public interface ClienteDao {
    void insertOrUpdateCliente(Cliente cliente);
    Cliente getCliente(String coCliente);
    List<Cliente> listCliente();

    void deleteCliente(Cliente cliente);
}
