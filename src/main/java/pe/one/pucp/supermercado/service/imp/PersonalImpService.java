package pe.one.pucp.supermercado.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.one.pucp.supermercado.dao.PersonalDao;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.service.PersonalService;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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

    @Override
    public TableModel getVendedorTableModel() {
        List<Vendedor> list = listVendedor();
        Object []header = new Object[] {"Código", "Nombre", "Estado"};
        Object [][]data = new Object[list.size()][3];
        for(int v=0; v<list.size(); v++) {
            data[v][0] = list.get(v).getCoVendedor();
            data[v][1] = list.get(v).getNoVendedor();
            data[v][2] = list.get(v).getEsVendedor();
        }
        return new DefaultTableModel(data, header);
    }
}
