package pe.one.pucp.supermercado.ui;

import pe.one.pucp.supermercado.gmodel.GenericModel;

import javax.swing.table.TableModel;

public interface GenericUI<T extends GenericModel> {

    Object getSelectedId();

    T getFromUI();

    void setToUI(T t);

    void resetUI();

    void resetFocus();

    void setTableModel(TableModel tableModel);
}
