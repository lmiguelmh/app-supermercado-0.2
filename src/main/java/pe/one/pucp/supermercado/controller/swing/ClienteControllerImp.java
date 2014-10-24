package pe.one.pucp.supermercado.controller.swing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.controller.ClienteController;
import pe.one.pucp.supermercado.model.Cliente;
import pe.one.pucp.supermercado.service.ClienteService;
import pe.one.pucp.supermercado.service.GenericService;
import pe.one.pucp.supermercado.ui.ClienteUI;
import pe.one.pucp.supermercado.ui.GenericUI;

@Controller
public class ClienteControllerImp
        extends AbstractGenericController<Cliente>
        implements ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteUI clienteUI;

    @Override
    protected GenericUI<Cliente> getUI() {
        return clienteUI;
    }

    @Override
    protected GenericService<Cliente> getService() {
        return clienteService;
    }

    static final String[] names = {"Dúnadan", "Strider", "Man of the West", "Ranger", "Aragorn", "Tom Bombadil", "Iarwain Ben-Adar", "Forn", "Horald"};
    static final String[] clasifs = {"A+","A","B","C","D","E"};

    @Override
    public void randomClick() {
        Cliente cliente = new Cliente();
        cliente.setCoCliente("" + getService().list().size());
        cliente.setNoCliente(names[(int) Math.round(Math.random() * (names.length - 1))]);
        cliente.setClasificacion(clasifs[(int)Math.round(Math.random() * (clasifs.length-1))]);
        getUI().setToUI(cliente);
    }
}
