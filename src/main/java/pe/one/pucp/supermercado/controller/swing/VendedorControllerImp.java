package pe.one.pucp.supermercado.controller.swing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.controller.VendedorController;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.GenericService;
import pe.one.pucp.supermercado.service.VendedorService;
import pe.one.pucp.supermercado.ui.GenericUI;
import pe.one.pucp.supermercado.ui.VendedorUI;

@Controller
public class VendedorControllerImp
        extends AbstractGenericController<Vendedor>
        implements VendedorController {

    @Autowired
    VendedorService service;

    @Autowired
    VendedorUI ui;

    @Override
    protected GenericUI<Vendedor> getUI() {
        return ui;
    }

    @Override
    protected GenericService<Vendedor> getService() {
        return service;
    }

    static final String[] names = {"Dúnadan", "Strider", "Man of the West", "Ranger", "Aragorn", "Tom Bombadil", "Iarwain Ben-Adar", "Forn", "Horald"};

    @Override
    public void randomClick() {
        Vendedor vendedor = new Vendedor();
        vendedor.setCoVendedor(""+getService().list().size());
        vendedor.setNoVendedor(names[(int)Math.round(Math.random() * (names.length-1))]);
        vendedor.setEsVendedor("" + (int)Math.round(Math.random()*1));
        getUI().setToUI(vendedor);
    }

}
