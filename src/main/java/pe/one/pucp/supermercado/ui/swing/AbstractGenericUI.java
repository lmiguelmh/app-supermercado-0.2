package pe.one.pucp.supermercado.ui.swing;

import pe.one.pucp.supermercado.model.GenericModel;
import pe.one.pucp.supermercado.ui.GenericUI;

import javax.swing.table.TableModel;

public abstract class AbstractGenericUI<T extends GenericModel> implements GenericUI<T> {

    @Override
    public Object getSelectedId() {
        int row = getSelectedRow();
        if (row >= 0) {
            return getTableModel().getValueAt(getSelectedRow(), 0);
        }
        return null;
    }

    protected abstract TableModel getTableModel();

    protected abstract int getSelectedRow();
}
