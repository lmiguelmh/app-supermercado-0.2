package pe.one.pucp.supermercado.gdao.mem;

import pe.one.pucp.supermercado.gdao.GenericDao;
import pe.one.pucp.supermercado.gmodel.GenericModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractGenericDao<T extends GenericModel>
        implements GenericDao<T> {

    private Class<T> type;

    public AbstractGenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
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
