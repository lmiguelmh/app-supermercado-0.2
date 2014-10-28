package pe.one.pucp.supermercado.dao.hashmap;

import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.PersonalDao;
import pe.one.pucp.supermercado.model.Vendedor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
@Repository
public class PersonalHashMapDao implements PersonalDao {

    protected Map<String, Vendedor> personal = new HashMap<String, Vendedor>();

    @Override
    public void insertOrUpdateVendedor(Vendedor vendedor) {
        if(vendedor==null || !vendedor.isValidForDao()) {
            throw new IllegalArgumentException("Datos no válidos en bean Vendedor");
        }

        if(personal.containsKey(vendedor.getCoVendedor())) {
            personal.remove(vendedor.getCoVendedor());
            personal.put(vendedor.getCoVendedor(), vendedor);
            //System.out.println("updated: "+vendedor);
        } else {
            personal.put(vendedor.getCoVendedor(), vendedor);
            //System.out.println("inserted: " + vendedor);
        }
    }

    @Override
    public Vendedor getVendedor(String coVendedor) {
        if(coVendedor==null || coVendedor.isEmpty()) {
            throw new IllegalArgumentException("Código de vendedor no válido");
        }

        if(personal.containsKey(coVendedor))
            return personal.get(coVendedor);
        return new Vendedor();
    }

    @Override
    public List<Vendedor> listVendedor() {
        return new ArrayList<Vendedor>(personal.values());
    }

    @Override
    public void deleteVendedor(Vendedor vendedor) {
        if(vendedor==null || !vendedor.isValidForDao()) {
            throw new IllegalArgumentException("Datos no válidos en bean Vendedor");
        }

        if(personal.containsKey(vendedor.getCoVendedor())) {
            personal.remove(vendedor.getCoVendedor());
        } else {
            throw new IllegalArgumentException("Vendedor no existe");
        }
    }
}
