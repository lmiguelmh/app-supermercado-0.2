package pe.one.pucp.supermercado.controller.swing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.controller.VentaController;
import pe.one.pucp.supermercado.model.Cliente;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.model.VentaDetalle;
import pe.one.pucp.supermercado.service.ClienteService;
import pe.one.pucp.supermercado.service.ProductoService;
import pe.one.pucp.supermercado.service.VendedorService;
import pe.one.pucp.supermercado.service.VentaDetalleService;
import pe.one.pucp.supermercado.ui.swing.VentaUISwing;

import javax.swing.*;
import java.util.List;

@Controller
public class VentaControllerImp
        implements VentaController {

    @Autowired
    VentaUISwing ventaUISwing;

    @Autowired
    ClienteService clienteService;
    @Override
    public void buscarClienteClick() {
        try {
            // puede ser id o nombre, id para esta versión
            String coCliente = validateQuery(ventaUISwing.getClienteQuery());
            List<Cliente> list = clienteService.listLikeId(coCliente);
            ventaUISwing.setClienteTableModel(clienteService.getTableModel(list));
        } catch (RuntimeException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Autowired
    VendedorService vendedorService;
    @Override
    public void buscarVendedorClick() {
        try {
            // puede ser id o nombre, id para esta versión
            String coVendedor = validateQuery(ventaUISwing.getVendedorQuery());
            List<Vendedor> list = vendedorService.listLikeId(coVendedor);
            ventaUISwing.setVendedorTableModel(vendedorService.getTableModel(list));
        } catch (RuntimeException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Autowired
    ProductoService productoService;
    @Override
    public void buscarProductoClick() {
        try {
            // puede ser id o nombre, id para esta versión
            String coProducto = validateQuery(ventaUISwing.getProductoQuery());
            List<Producto> list = productoService.listLikeId(coProducto);
            ventaUISwing.setProductoTableModel(productoService.getTableModel(list));
        } catch (RuntimeException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Autowired
    VentaDetalleService ventaDetalleService;
    @Override
    public void agregarVentaDetalleClick() {
        try {
            // puede ser id o nombre, id para esta versión
            VentaDetalle ventaDetalle = ventaUISwing.getVentaDetalleFromUI();
            ventaDetalle.setCoVentaDetalle(ventaDetalleService.getNextId());
            ventaDetalleService.insertOrUpdate(ventaDetalle);
            List<VentaDetalle> list = ventaDetalleService.list();
            ventaUISwing.setVendaDetalleTableModel(ventaDetalleService.getTableModel(list));
        } catch (RuntimeException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void eliminarVentaDetalleClick() {
        try {
            ventaDetalleService.delete(ventaUISwing.getVentaDetalleSelectedId());
            List<VentaDetalle> list = ventaDetalleService.list();
            ventaUISwing.setVendaDetalleTableModel(ventaDetalleService.getTableModel(list));
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void insertarVentaClick() {
        ;
    }


    private String validateQuery(String clienteQuery) {
        if(clienteQuery==null || clienteQuery.isEmpty() || clienteQuery.length()<1) {
            throw new IllegalArgumentException("Datos no válidos");
        }
        return "%" +clienteQuery+ "%";
    }

}
