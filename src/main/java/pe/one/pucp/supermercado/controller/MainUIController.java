package pe.one.pucp.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.PersonalService;

import javax.swing.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lmiguelmh
 * Date: 14/10/14
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
// paradigm: model-view-adapter/presenter
@Controller
public class MainUIController {

    @Autowired
    PersonalService personalService;

    public void listarPersonalClick() {
        String list = personalService.getListVendedorString();
        JOptionPane.showInputDialog(
                null,
                "",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                list);
    }

    int coVendedor = 0;
    public void agregarPersonalClick() {
        coVendedor++;
        Vendedor vendedor = new Vendedor();
        vendedor.setCoVendedor(""+ coVendedor);
        vendedor.setNoVendedor(String.format("%s%04d", "V", coVendedor));
        vendedor.setEsVendedor("1");
        personalService.insertOrUpdateVendedor(vendedor);
    }

    public void modificarPersonalClick() {
        Vendedor vendedor = new Vendedor();
        String coVendedor = (String) JOptionPane.showInputDialog(
                null,
                "Ingrese el código del vendedor:",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "1");
        vendedor.setCoVendedor(coVendedor);

        String noVendedor = (String) JOptionPane.showInputDialog(
                null,
                "Ingrese el nuevo nombre del vendedor:",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "Dúnadan");
        vendedor.setNoVendedor(noVendedor);
        vendedor.setEsVendedor("1");

        personalService.insertOrUpdateVendedor(vendedor);
    }

    public void listarProductosClick() {
        ;
    }

    public void agregarProductoClick() {
        ;
    }
}
