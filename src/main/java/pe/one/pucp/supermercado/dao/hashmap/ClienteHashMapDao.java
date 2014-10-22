package pe.one.pucp.supermercado.dao.hashmap;

import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.ClienteDao;
import pe.one.pucp.supermercado.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
@Repository
public class ClienteHashMapDao implements ClienteDao {
    //protected List<Cliente> clientes = new ArrayList<Cliente>();
    protected Map<String, Cliente> clientes = new HashMap<String, Cliente>();

    @Override
    public void insertOrUpdateCliente(Cliente cliente) {
        if(cliente==null || !cliente.isValidForDao()) {
            throw new IllegalArgumentException();
        }

        if(clientes.containsKey(cliente.getCoCliente())) {
            clientes.remove(cliente.getCoCliente());
            clientes.put(cliente.getCoCliente(), cliente);
            //System.out.println("updated: "+cliente);
        } else {
            clientes.put(cliente.getCoCliente(), cliente);
            //System.out.println("inserted: " + cliente);
        }
    }

    @Override
    public Cliente getCliente(String coCliente) {
        if(coCliente==null || coCliente.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if(clientes.containsKey(coCliente))
            return clientes.get(coCliente);
        return new Cliente();
    }

    @Override
    public List<Cliente> listCliente() {
        return new ArrayList<Cliente>(clientes.values());
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        if(cliente==null || !cliente.isValidForDao()) {
            throw new IllegalArgumentException("Datos no válidos en bean Cliente");
        }

        if(clientes.containsKey(cliente.getCoCliente())) {
            clientes.remove(cliente.getCoCliente());
        } else {
            throw new IllegalArgumentException("Cliente no existe");
        }
    }
}
