package pe.one.pucp.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.PersonalService;
import pe.one.pucp.supermercado.ui.PersonalUI;

import javax.swing.*;

/**
 * Clase PersonalUIController.
 *
 * @author lmamani[at]reniec.gob.pe
 *         lmiguelmh[at]gmail[dot]com
 * @version 0.0.1
 * @since 21/10/2014 11:06 AM
 */
@Controller
public class PersonalUIController {

    @Autowired
    PersonalService personalService;

    @Autowired
    PersonalUI personalUI;

    public void insertarClick() {
        Vendedor vendedor = readUI();
        try {
            personalService.insertOrUpdateVendedor(vendedor);
            Vendedor empty = new Vendedor();
            setUI(empty);
            personalUI.setTableModel(personalService.getVendedorTableModel());
            JOptionPane.showMessageDialog(null, "Registro insertado/actualizado", "", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Vendedor readUI() {
        Vendedor vendedor = new Vendedor();
        vendedor.setCoVendedor(personalUI.getCodigo());
        vendedor.setEsVendedor(personalUI.getEstado()?"1":"0");
        vendedor.setNoVendedor(personalUI.getNombre());
        return vendedor;
    }

    private void setUI(Vendedor vendedor) {
        personalUI.setCodigo(vendedor.getCoVendedor());
        personalUI.setEstado("1".equals(vendedor.getEsVendedor()));
        personalUI.setNombre(vendedor.getNoVendedor());
    }

    public void tableSelectionChanged() {
        Object obj = personalUI.getSelectedCodigo();
        if(obj != null) {
            String codigo = (String) obj;
            Vendedor vendedor = personalService.getVendedor(codigo);
            setUI(vendedor);
        }
    }

    public void nuevoClick() {
        Vendedor empty = new Vendedor();
        setUI(empty);
        personalUI.setFocusInCodigo();
    }

    public void randomClick() {
        final String[] names = {"Dúnadan", "Strider", "Man of the West", "Ranger", "Aragorn", "Tom Bombadil", "Iarwain Ben-Adar", "Forn", "Horald"};
        Vendedor vendedor = new Vendedor();
        vendedor.setCoVendedor(""+personalService.listVendedor().size());
        vendedor.setNoVendedor(names[(int)Math.round(Math.random() * (names.length-1))]);
        vendedor.setEsVendedor("" + (int)Math.round(Math.random()*1));
        setUI(vendedor);
    }
}
