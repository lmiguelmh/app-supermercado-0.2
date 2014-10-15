package pe.one.pucp.supermercado.dao.hashmap;

import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.InventarioDao;
import pe.one.pucp.supermercado.model.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
@Repository
public class InventarioHashMapDao implements InventarioDao {

    protected Map<String, Producto> inventario = new HashMap<String, Producto>();

    @Override
    public void insertOrUpdateProducto(Producto producto) {
        if(producto==null || !producto.isValidForDao()) {
            throw new IllegalArgumentException();
        }

        if(inventario.containsKey(producto.getCoProducto())) {
            inventario.remove(producto.getCoProducto());
            inventario.put(producto.getCoProducto(), producto);
            //System.out.println("updated: "+producto);
        } else {
            inventario.put(producto.getCoProducto(), producto);
            //System.out.println("inserted: " + producto);
        }
    }

    @Override
    public Producto getProducto(String coProducto) {
        if(coProducto==null || coProducto.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if(inventario.containsKey(coProducto))
            return inventario.get(coProducto);
        return new Producto();
    }

    @Override
    public List<Producto> listProducto() {
        return new ArrayList<Producto>(inventario.values());
    }
}
