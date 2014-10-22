package pe.one.pucp.supermercado.model;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
public class Producto extends AbstractSupermercadoModel {
    String coProducto;
    String noProducto;
    Double precioCompra;
    Double precioVenta;
    Integer inventario;

    public Producto() {
        coProducto = "";
        noProducto = "";
        precioCompra = null;
        precioVenta = null;
        inventario = null;
    }

    public String getCoProducto() {
        return coProducto;
    }

    public void setCoProducto(String coProducto) {
        this.coProducto = coProducto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public String getNoProducto() {
        return noProducto;
    }

    public void setNoProducto(String noProducto) {
        this.noProducto = noProducto;
    }

    @Override
    public boolean isValidForDao() {
        return coProducto!=null && !coProducto.isEmpty();
    }
}
