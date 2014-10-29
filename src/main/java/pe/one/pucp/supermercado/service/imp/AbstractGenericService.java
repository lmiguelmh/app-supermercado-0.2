package pe.one.pucp.supermercado.service.imp;

import pe.one.pucp.supermercado.dao.GenericDao;
import pe.one.pucp.supermercado.model.GenericModel;
import pe.one.pucp.supermercado.service.GenericService;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public abstract class AbstractGenericService<T extends GenericModel>
        implements GenericService<T> {

    protected abstract GenericDao<T> getDao();

    @Override
    public List<T> list() throws RuntimeException {
        return getDao().list();
    }

    @Override
    public T insertOrUpdate(T t) throws RuntimeException {
        return getDao().insertOrUpdate(t);
    }

    @Override
    public void delete(Object id) throws RuntimeException {
        getDao().delete(id);
    }

    @Override
    public T find(Object id) throws RuntimeException {
        return getDao().find(id);
    }

    @Override
    public List<T> listLikeId(Object id) throws RuntimeException {
        return getDao().listLikeId(id);
    }

    @Override
    public TableModel getTableModel(List<T> list) {
        return new DefaultTableModel(_getTableModelData(list),_getTableModelHeader());
    }

    protected abstract Object[][] _getTableModelData(List<T> list);

    protected abstract Object[] _getTableModelHeader();

}
