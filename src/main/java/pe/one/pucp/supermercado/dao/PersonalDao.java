package pe.one.pucp.supermercado.dao;


import pe.one.pucp.supermercado.model.Vendedor;

import java.util.List;

/**
 * Created by lmiguelmh on 05/10/2014.
 */
public interface PersonalDao {
    void insertOrUpdateVendedor(Vendedor vendedor);
    Vendedor getVendedor(String coVendedor);
    List<Vendedor> listVendedor();

    void deleteVendedor(Vendedor vendedor);
}
