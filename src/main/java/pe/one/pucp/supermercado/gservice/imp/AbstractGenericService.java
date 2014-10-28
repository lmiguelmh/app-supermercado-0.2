package pe.one.pucp.supermercado.gservice.imp;

import pe.one.pucp.supermercado.gmodel.GenericModel;
import pe.one.pucp.supermercado.gservice.GenericService;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public abstract class AbstractGenericService<T extends GenericModel>
        implements GenericService<T> {

    @Override
    public TableModel getTableModel() {
        return new DefaultTableModel(_getTableModelData(),_getTableModelHeader());
    }

    protected abstract Object[][] _getTableModelData();

    protected abstract Object[] _getTableModelHeader();

}
