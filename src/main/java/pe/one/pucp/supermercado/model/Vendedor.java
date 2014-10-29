package pe.one.pucp.supermercado.model;

public class Vendedor
        extends AbstractGenericModel
        implements GenericModel {

    String coVendedor;
    String esVendedor;
    String noVendedor;

    public Vendedor() {
        coVendedor = "";
        noVendedor = "";
        esVendedor = "0";
    }

    public String getCoVendedor() {
        return coVendedor;
    }

    public void setCoVendedor(String coVendedor) {
        this.coVendedor = coVendedor;
    }

    public String getEsVendedor() {
        return esVendedor;
    }

    public void setEsVendedor(String esVendedor) {
        this.esVendedor = esVendedor;
    }

    public String getNoVendedor() {
        return noVendedor;
    }

    public void setNoVendedor(String noVendedor) {
        this.noVendedor = noVendedor;
    }

    @Override
    public Object getId() {
        return coVendedor;
    }

    @Override
    public boolean isValidForCreate() {
        return coVendedor!=null && !coVendedor.isEmpty();
    }

    @Override
    public boolean isValidForUpdate() {
        return coVendedor!=null && !coVendedor.isEmpty();
    }
}
