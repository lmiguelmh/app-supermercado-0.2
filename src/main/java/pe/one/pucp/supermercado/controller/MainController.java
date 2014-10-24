package pe.one.pucp.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.service.ClienteService;
import pe.one.pucp.supermercado.service.ProductoService;
import pe.one.pucp.supermercado.service.VendedorService;
import pe.one.pucp.supermercado.ui.ClienteUI;
import pe.one.pucp.supermercado.ui.ProductoUI;
import pe.one.pucp.supermercado.ui.VendedorUI;

import javax.swing.*;
import java.awt.*;

@Controller
public class MainController {

    @Autowired
    VendedorUI vendedorUI;

    @Autowired
    VendedorService vendedorService;

    public void administrarVendedorClick() {
        vendedorUI.setTableModel(vendedorService.getTableModel());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame("VendedorUI");
                    frame.setContentPane(vendedorUI.getMainPanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setPreferredSize(new Dimension(500, 400));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Autowired
    ProductoUI productoUI;

    @Autowired
    ProductoService productoService;

    public void administrarProductoClick() {
        productoUI.setTableModel(productoService.getTableModel());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame("ProductoUI");
                    frame.setContentPane(productoUI.getMainPanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setPreferredSize(new Dimension(500, 400));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Autowired
    ClienteUI clienteUI;

    @Autowired
    ClienteService clienteService;

    public void administrarClienteClick() {
        clienteUI.setTableModel(clienteService.getTableModel());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame("ClienteUI");
                    frame.setContentPane(clienteUI.getMainPanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setPreferredSize(new Dimension(500, 400));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
