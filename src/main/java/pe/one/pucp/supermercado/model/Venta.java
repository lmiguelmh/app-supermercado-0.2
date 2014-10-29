package pe.one.pucp.supermercado.model;

import java.sql.Timestamp;

public class Venta
        extends AbstractGenericModel
        implements GenericModel {

    String coVenta;
    String coCliente;
    String coVendedor;
    Double montoTotal;
    Timestamp fechaVenta;

    public String getCoVenta() {
        return coVenta;
    }

    public void setCoVenta(String coVenta) {
        this.coVenta = coVenta;
    }

    public String getCoCliente() {
        return coCliente;
    }

    public void setCoCliente(String coCliente) {
        this.coCliente = coCliente;
    }

    public String getCoVendedor() {
        return coVendedor;
    }

    public void setCoVendedor(String coVendedor) {
        this.coVendedor = coVendedor;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Timestamp getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Timestamp fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public Object getId() {
        return coVenta;
    }

    @Override
    public boolean isValidForCreate() {
        return  (coVenta!=null && !coVenta.isEmpty()) &&
                (coCliente!=null && !coCliente.isEmpty()) &&
                (coVendedor!=null && !coVendedor.isEmpty());
    }

    @Override
    public boolean isValidForUpdate() {
        return  (coVenta!=null && !coVenta.isEmpty()) &&
                (coCliente!=null && !coCliente.isEmpty()) &&
                (coVendedor!=null && !coVendedor.isEmpty());
    }
}
