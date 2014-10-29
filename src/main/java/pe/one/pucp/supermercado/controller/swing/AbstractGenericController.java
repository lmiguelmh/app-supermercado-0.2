package pe.one.pucp.supermercado.controller.swing;

import pe.one.pucp.supermercado.controller.GenericController;
import pe.one.pucp.supermercado.model.GenericModel;
import pe.one.pucp.supermercado.service.GenericService;
import pe.one.pucp.supermercado.ui.GenericUI;

import javax.swing.*;
import java.util.List;

public abstract class AbstractGenericController<T extends GenericModel> implements GenericController {

    protected abstract GenericUI<T> getUI();

    protected abstract GenericService<T> getService();

    @Override
    public void nuevoClick() {
        getUI().resetUI();
        getUI().resetFocus();
    }

    @Override
    public void insertarClick() {
        try {
            T t = getUI().getFromUI();
            getService().insertOrUpdate(t);
            List<T> list = getService().list();
            getUI().resetUI();
            getUI().setTableModel(getService().getTableModel(list));
            JOptionPane.showMessageDialog(null, "Registro insertado/actualizado", "", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void eliminarClick() {
        try {
            T t = getUI().getFromUI();
            getService().delete(t.getId());
            List<T> list = getService().list();
            getUI().resetUI();
            getUI().setTableModel(getService().getTableModel(list));
            JOptionPane.showMessageDialog(null, "Registro eliminado", "", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void tablaSelectionChanged() {
        Object id = getUI().getSelectedId();
        if(id != null) {
            T t = getService().find(id);
            if(t != null) {
                getUI().setToUI(t);
            } else {
                getUI().resetUI();
            }
        }
    }

}
