package pe.one.pucp.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.InventarioService;
import pe.one.pucp.supermercado.ui.InventarioUI;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: lmiguelmh
 * Date: 21/10/14
 * Time: 10:20 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class InventarioUIController {

    @Autowired
    InventarioUI inventarioUI;

    @Autowired
    InventarioService inventarioService;

    public void nuevoClick() {
        Producto empty = new Producto();
        setUI(empty);
        inventarioUI.setFocusInCodigo();
    }

    public void randomClick() {
        final String[] names = {"X3 TerranConflict", "X3 AlbionPrelude", "Sid Meiers' Alpha Centaury", "Tomb Raider Legend", "Ogame", "Eve Online", "StarCraft", "StarCraft II", "Tekken", "Metal Slug", "Contra III"};
        Producto producto = new Producto();
        producto.setCoProducto(""+inventarioService.listProducto().size());
        producto.setNoProducto(names[(int) Math.round(Math.random() * (names.length - 1))]);
        final double maxPrice = 100.0;
        producto.setPrecioCompra(Math.round(Math.random()*maxPrice * 100.0)/100.0);
        final double spread = 0.25; //25% spread
        producto.setPrecioVenta(Math.round(producto.getPrecioCompra()*(1+spread) *100.0)/100.0);
        producto.setInventario((int) Math.round(Math.random() * 25));
        setUI(producto);
    }

    public void insertarClick() {
        try {
            Producto producto = readUI();
            inventarioService.insertOrUpdateProducto(producto);
            Producto empty = new Producto();
            setUI(empty);
            inventarioUI.setTableModel(inventarioService.getProductoTableModel());
            JOptionPane.showMessageDialog(null, "Registro insertado/actualizado", "", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setUI(Producto producto) {
        inventarioUI.setCodigo(producto.getCoProducto());
        inventarioUI.setNombre(producto.getNoProducto());
        inventarioUI.setInventario(producto.getInventario() == null ? "" : String.valueOf(producto.getInventario()));
        inventarioUI.setPrecioCompra(producto.getPrecioCompra() == null ? "" : String.valueOf(producto.getPrecioCompra()));
        inventarioUI.setPrecioVenta(producto.getPrecioVenta() == null ? "" : String.valueOf(producto.getPrecioVenta()));
    }

    private Producto readUI() {
        Producto producto = new Producto();
        producto.setCoProducto(inventarioUI.getCodigo());
        producto.setNoProducto(inventarioUI.getNombre());
        try {
            producto.setInventario(Integer.valueOf(inventarioUI.getInventario()));
            producto.setPrecioCompra(Double.valueOf(inventarioUI.getPrecioCompra()));
            producto.setPrecioVenta(Double.valueOf(inventarioUI.getPrecioVenta()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número(s) ingresado(s) no válido(s)");
        }
        return producto;
    }

    public void tableSelectionChanged() {
        Object obj = inventarioUI.getSelectedCodigo();
        if(obj != null) {
            String codigo = (String) obj;
            Producto producto = inventarioService.getProducto(codigo);
            setUI(producto);
        }
    }
}
