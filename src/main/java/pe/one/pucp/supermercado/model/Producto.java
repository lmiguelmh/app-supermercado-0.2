package pe.one.pucp.supermercado.model;

public class Producto
        extends AbstractGenericModel
        implements GenericModel { //should be ProductoModel

    String coProducto;
    String noProducto;
    Double precioCompra;
    Double precioVenta;
    Integer inventario;

    public String getCoProducto() {
        return coProducto;
    }

    public void setCoProducto(String coProducto) {
        this.coProducto = coProducto;
    }

    public String getNoProducto() {
        return noProducto;
    }

    public void setNoProducto(String noProducto) {
        this.noProducto = noProducto;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    @Override
    public Object getId() {
        return coProducto;
    }

    @Override
    public boolean isValidForCreate() {
        return coProducto!=null && !coProducto.isEmpty();
    }

    @Override
    public boolean isValidForUpdate() {
        return coProducto!=null && !coProducto.isEmpty();
    }
}
