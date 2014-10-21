package pe.one.pucp.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.InventarioService;
import pe.one.pucp.supermercado.service.PersonalService;
import pe.one.pucp.supermercado.ui.PersonalUI;

import javax.swing.*;
import java.awt.*;

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

    @Autowired
    InventarioService inventarioService;

    @Autowired
    PersonalUI personalUI;

    public void listarPersonalClick() {
        personalUI.setTableModel(personalService.getVendedorTableModel());

        String list = personalService.getListVendedorString();
        JOptionPane.showInputDialog(
                null,
                "",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                list);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame("PersonalUI");
                    //MainUI mainUI = new MainUI();
                    //personalUI.setLabelText("PUCP2014");
                    frame.setContentPane(personalUI.getMainPanel());
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });;
    }

    private int coVendedorCount = 0;

    public void modificarPersonalClick() {
        coVendedorCount++;
        Vendedor vendedor = new Vendedor();
        String coVendedor = (String) JOptionPane.showInputDialog(
                null,
                "Ingrese el código del vendedor:",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                ""+coVendedorCount);
        vendedor.setCoVendedor(coVendedor);

        String[] names = {"Dúnadan", "Strider", "Man of the West", "Ranger"};
        String noVendedor = (String) JOptionPane.showInputDialog(
                null,
                "Ingrese el nuevo nombre del vendedor:",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                names[(int) (Math.random() * (names.length-1))]);
        vendedor.setNoVendedor(noVendedor);
        vendedor.setEsVendedor("1");

        personalService.insertOrUpdateVendedor(vendedor);
    }

    public void listarProductosClick() {
        String list = inventarioService.getListProductoString();
        JOptionPane.showInputDialog(
                null,
                "",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                list);
    }

    private int coProductoCount = 0;

    public void modificarProductosClick() {
        coProductoCount++;
        Producto producto = new Producto();
        String coProducto = (String) JOptionPane.showInputDialog(
                null,
                "Ingrese el código del producto:",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                ""+coProductoCount);
        producto.setCoProducto(coProducto);

        String[] names = {"X3 TerranConflict", "X3 AlbionPrelude", "Sid Meiers' Alpha Centaury", "Tomb Raider Legend"};
        String noProducto = (String) JOptionPane.showInputDialog(
                null,
                "Ingrese el nuevo nombre del producto:",
                "Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                names[(int) (Math.random() * (names.length-1))]);
        producto.setNoProducto(noProducto);

        try {
            Integer inventario = Integer.valueOf((String) JOptionPane.showInputDialog(
                    null,
                    "Ingrese el nuevo inventario del producto:",
                    "Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "1"));
            producto.setInventario(inventario);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            producto.setInventario(0);
        }
        producto.setPrecioCompra(1.0);
        producto.setPrecioVenta(1.25);

        inventarioService.insertOrUpdateProducto(producto);
    }

    public void listarClientesClick() {

    }

    public void modificarClientesClick() {

    }
}
