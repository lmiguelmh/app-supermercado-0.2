package pe.one.pucp.supermercado.controller.swing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.controller.ProductoController;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.service.GenericService;
import pe.one.pucp.supermercado.service.ProductoService;
import pe.one.pucp.supermercado.ui.GenericUI;
import pe.one.pucp.supermercado.ui.ProductoUI;

@Controller
public class ProductoControllerImp
        extends AbstractGenericController<Producto>
        implements ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoUI productoUI;

    @Override
    protected GenericUI<Producto> getUI() {
        return productoUI;
    }

    @Override
    protected GenericService<Producto> getService() {
        return productoService;
    }

    static final String[] names = {"X3 TerranConflict", "X3 AlbionPrelude", "Sid Meiers' Alpha Centaury", "Tomb Raider Legend", "Ogame", "Eve Online", "StarCraft", "StarCraft II", "Tekken", "Metal Slug", "Contra III"};
    static final double maxPrice = 100.0;
    static final double spread = 0.25; //25% spread = precioVenta-precioCompra

    @Override
    public void randomClick() {
        Producto producto = new Producto();
        producto.setCoProducto(""+getService().list().size());
        producto.setNoProducto(names[(int) Math.round(Math.random() * (names.length - 1))]);
        producto.setPrecioCompra(Math.round(Math.random()*maxPrice * 100.0)/100.0);
        producto.setPrecioVenta(Math.round(producto.getPrecioCompra()*(1+spread) *100.0)/100.0);
        producto.setInventario((int) Math.round(Math.random() * 25));
        getUI().setToUI(producto);
    }

}
