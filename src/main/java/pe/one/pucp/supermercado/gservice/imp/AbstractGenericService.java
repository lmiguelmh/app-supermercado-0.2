package pe.one.pucp.supermercado.gservice.imp;

import pe.one.pucp.supermercado.gdao.GenericDao;
import pe.one.pucp.supermercado.gservice.GenericService;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public abstract class AbstractGenericService<T extends GenericDao>
        implements GenericService {
    @Override
    public TableModel getTableModel() {
        List<T> list = list();
        /*
        Object []header = new Object[] {"Código", "Nombre", "Clasif"};
        Object [][]data = new Object[list.size()][3];
        for(int v=0; v<list.size(); v++) {
            data[v][0] = list.get(v).getCoCliente();
            data[v][1] = list.get(v).getNoCliente();
            data[v][2] = list.get(v).getClasificacion();
        }
        return new DefaultTableModel(data, header);
        */
        return new DefaultTableModel();
    }
}
