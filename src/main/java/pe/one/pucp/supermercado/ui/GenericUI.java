package pe.one.pucp.supermercado.ui;

import pe.one.pucp.supermercado.model.GenericModel;

import javax.swing.table.TableModel;
import java.awt.*;

public interface GenericUI<T extends GenericModel> {

    Container getMainPanel();

    Object getSelectedId();

    T getFromUI();

    void setToUI(T t);

    void resetUI();

    void resetFocus();

    void setTableModel(TableModel tableModel);
}
