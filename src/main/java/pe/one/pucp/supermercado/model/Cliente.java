package pe.one.pucp.supermercado.model;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
public class Cliente extends AbstractSupermercadoModel {
    String coCliente;
    String noCliente;
    String clasificacion; //A,B,C,D,E

    public String getCoCliente() {
        return coCliente;
    }

    public void setCoCliente(String coCliente) {
        this.coCliente = coCliente;
    }

    public String getNoCliente() {
        return noCliente;
    }

    public void setNoCliente(String noCliente) {
        this.noCliente = noCliente;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public boolean isValidForDao() {
        return coCliente!=null && !coCliente.isEmpty();
    }
}
