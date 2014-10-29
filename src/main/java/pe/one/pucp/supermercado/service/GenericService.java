package pe.one.pucp.supermercado.service;

import pe.one.pucp.supermercado.model.GenericModel;

import javax.swing.table.TableModel;
import java.util.List;

public interface GenericService<T extends GenericModel> {

    List<T> list() throws RuntimeException;

    T insertOrUpdate(T t) throws RuntimeException;

    void delete(Object id) throws RuntimeException;

    T find(Object id) throws RuntimeException;

    List<T> listLikeId(Object id) throws RuntimeException;

    // I think this shouldn't be here...
    TableModel getTableModel(List<T> list);
}
