package pe.one.pucp.supermercado.gcontroller;

import pe.one.pucp.supermercado.gmodel.GenericModel;

public interface GenericController<T extends GenericModel> {

    void nuevoClick();

    void insertarClick();

    void eliminarClick();

    void tablaSelectionChanged();
}
