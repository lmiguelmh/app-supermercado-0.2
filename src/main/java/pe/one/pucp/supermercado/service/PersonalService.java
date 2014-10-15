package pe.one.pucp.supermercado.service;

import pe.one.pucp.supermercado.model.Vendedor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lmiguelmh
 * Date: 14/10/14
 * Time: 11:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PersonalService {
    List<Vendedor> listVendedor();
    String getListVendedorString();
    void insertOrUpdateVendedor(Vendedor vendedor);
}
