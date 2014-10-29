package pe.one.pucp.supermercado.dao.imp;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import pe.one.pucp.supermercado.dao.GenericDao;
import pe.one.pucp.supermercado.model.GenericModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class DataSourceAbstractGenericDao<T extends GenericModel>
        implements GenericDao<T> {

    private Class<T> type;
    protected final JdbcTemplate jdbcTemplate;
    protected final Logger log = Logger.getLogger(this.getClass());

    public DataSourceAbstractGenericDao(JdbcTemplate jdbcTemplate) {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public T insertOrUpdate(T t) {
        if (t == null || !t.isValidForCreate()) {
            throw new IllegalArgumentException("Datos no válidos en " + type.getSimpleName());
        }
        if (find(t.getId()) == null) {
            return _insert(t);
        } else {
            return _update(t);
        }
    }

    @Override
    public void delete(Object id) throws RuntimeException {
        if (id == null) {
            throw new IllegalArgumentException("Id no válido para " + type.getSimpleName());
        }
        if (find(id) == null) {
            throw new IllegalStateException(type.getSimpleName() + " no existe");
        } else {
            _delete(id);
        }
    }

    @Override
    public T find(Object id) throws RuntimeException {
        if (id == null) {
            throw new IllegalArgumentException("Id no válido para " + type.getSimpleName());
        }
        return _find(id);
    }

    protected abstract T _insert(T t) throws RuntimeException;
    protected abstract T _update(T t) throws RuntimeException;
    protected abstract void _delete(Object id) throws RuntimeException;
    protected abstract T _find(Object id) throws RuntimeException;

}
