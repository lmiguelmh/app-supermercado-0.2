package pe.one.pucp.supermercado.model;

public class VentaDetalle
        extends AbstractGenericModel
        implements GenericModel {

    Integer coVentaDetalle;
    String coVenta;
    String coProducto;
    Integer cantidad;
    Double montoTotal;

    public Integer getCoVentaDetalle() {
        return coVentaDetalle;
    }

    public void setCoVentaDetalle(Integer coVentaDetalle) {
        this.coVentaDetalle = coVentaDetalle;
    }

    public String getCoVenta() {
        return coVenta;
    }

    public void setCoVenta(String coVenta) {
        this.coVenta = coVenta;
    }

    public String getCoProducto() {
        return coProducto;
    }

    public void setCoProducto(String coProducto) {
        this.coProducto = coProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public Object getId() {
        return coVentaDetalle;
    }

    @Override
    public boolean isValidForCreate() {
        //return (coVenta!=null && !coVenta.isEmpty()) &&
        return       (coProducto!=null && !coProducto.isEmpty());
    }

    @Override
    public boolean isValidForUpdate() {
        //return (coVenta!=null && !coVenta.isEmpty()) &&
        return        (coProducto!=null && !coProducto.isEmpty());
    }
}
