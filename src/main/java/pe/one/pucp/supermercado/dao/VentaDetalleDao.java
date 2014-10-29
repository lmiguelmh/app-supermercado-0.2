package pe.one.pucp.supermercado.dao;

import pe.one.pucp.supermercado.model.VentaDetalle;

public interface VentaDetalleDao
        extends GenericDao<VentaDetalle>{

    Integer getNextId();
}
