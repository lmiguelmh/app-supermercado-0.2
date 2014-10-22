package pe.one.pucp.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.one.pucp.supermercado.model.Cliente;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.ClienteService;
import pe.one.pucp.supermercado.ui.ClienteUI;

import javax.swing.*;

@Controller
public class ClienteUIController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteUI clienteUI;

    public void nuevoClick() {
        Cliente empty = new Cliente();
        setUI(empty);
        clienteUI.setFocusInCodigo();
    }

    private void setUI(Cliente cliente) {
        clienteUI.setCodigo(cliente.getCoCliente());
        clienteUI.setNombre(cliente.getNoCliente());
        clienteUI.setClasificacion(cliente.getClasificacion());
    }


    public void randomClick() {
        final String[] names = {"Dúnadan", "Strider", "Man of the West", "Ranger", "Aragorn", "Tom Bombadil", "Iarwain Ben-Adar", "Forn", "Horald"};
        Cliente cliente = new Cliente();
        cliente.setCoCliente("" + clienteService.listCliente().size());
        cliente.setNoCliente(names[(int) Math.round(Math.random() * (names.length - 1))]);
        final String[] clasifs = {"A+","A","B","C","D","E"};
        cliente.setClasificacion(clasifs[(int)Math.round(Math.random() * (clasifs.length-1))]);
        setUI(cliente);
    }

    public void insertarClick() {
        try {
            Cliente cliente = readUI();
            clienteService.insertOrUpdateCliente(cliente);
            Cliente empty = new Cliente();
            setUI(empty);
            clienteUI.setTableModel(clienteService.getClienteTableModel());
            JOptionPane.showMessageDialog(null, "Registro insertado/actualizado", "", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Cliente readUI() {
        Cliente cliente = new Cliente();
        cliente.setCoCliente(clienteUI.getCodigo());
        cliente.setNoCliente(clienteUI.getNombre());
        cliente.setClasificacion(clienteUI.getClasificacion());
        return cliente;
    }

    public void tableSelectionChanged() {
        Object obj = clienteUI.getSelectedCodigo();
        if(obj != null) {
            String codigo = (String) obj;
            Cliente cliente = clienteService.getCliente(codigo);
            setUI(cliente);
        }
    }

    public void eliminarClick() {
        try {
            Cliente cliente = readUI();
            clienteService.deleteCliente(cliente);
            Cliente empty = new Cliente();
            setUI(empty);
            clienteUI.setTableModel(clienteService.getClienteTableModel());
            JOptionPane.showMessageDialog(null, "Registro eliminado", "", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
