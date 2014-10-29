package pe.one.pucp.supermercado.service;

import pe.one.pucp.supermercado.model.VentaDetalle;

public interface VentaDetalleService
        extends GenericService<VentaDetalle> {
    Integer getNextId();
}
