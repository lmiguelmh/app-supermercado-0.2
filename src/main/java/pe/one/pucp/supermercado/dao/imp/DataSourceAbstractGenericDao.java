package pe.one.pucp.supermercado.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import pe.one.pucp.supermercado.dao.GenericDao;
import pe.one.pucp.supermercado.dao.mem.AbstractGenericDao;
import pe.one.pucp.supermercado.model.GenericModel;

import javax.sql.DataSource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
public abstract class DataSourceAbstractGenericDao extends AbstractGenericDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
*/

public abstract class DataSourceAbstractGenericDao<T extends GenericModel>
        implements GenericDao<T> {

    private Class<T> type;
    protected final JdbcTemplate jdbcTemplate;

    //@Autowired
    public DataSourceAbstractGenericDao(JdbcTemplate jdbcTemplate) {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public T insertOrUpdate(T t) {
        if(t==null || !t.isValidForCreate()) {
            throw new IllegalArgumentException("Datos no válidos en " + type.getSimpleName());
        }
        if(find(t.getId()) == null) {
            return _insert(t);
        } else {
            return _update(t);
        }
    }

    @Override
    public void delete(Object id) throws RuntimeException {
        if(id==null) {
            throw new IllegalArgumentException("Id no válido para " + type.getSimpleName());
        }
        if(find(id) == null) {
            throw new IllegalStateException(type.getSimpleName() + " no existe");
        } else {
            _delete(id);
        }
    }

    @Override
    public T find(Object id) throws RuntimeException {
        if(id==null) {
            throw new IllegalArgumentException("Id no válido para " + type.getSimpleName());
        }
        return _find(id);
    }

    protected abstract T _insert(T t) throws RuntimeException;

    protected abstract T _update(T t) throws RuntimeException;

    protected abstract void _delete(Object id) throws RuntimeException;

    protected abstract T _find(Object id) throws RuntimeException;

}
