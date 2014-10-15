package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.PersonalDao;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.PersonalService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lmiguelmh
 * Date: 14/10/14
 * Time: 11:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PersonalImpService implements PersonalService {

    @Autowired
    PersonalDao personalDao;

    @Override
    public List<Vendedor> listVendedor() {
        return personalDao.listVendedor();
    }

    @Override
    public String getListVendedorString() {
        List<Vendedor> list = listVendedor();
        StringBuffer sb = new StringBuffer();
        for(Vendedor vendedor:list) {
            sb.append(vendedor).append(" ");
        }
        return sb.toString();
    }

    @Override
    public void insertOrUpdateVendedor(Vendedor vendedor) {
        personalDao.insertOrUpdateVendedor(vendedor);
    }
}
