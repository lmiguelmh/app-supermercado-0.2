package pe.one.pucp.supermercado.model;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
public class Vendedor extends AbstractSupermercadoModel {
    String coVendedor;
    String esVendedor; // estado vendedor
    String noVendedor; // nombre

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
    public boolean isValidForDao() {
        return coVendedor!=null && !coVendedor.isEmpty();
    }
}
