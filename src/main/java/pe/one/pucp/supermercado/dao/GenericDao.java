package pe.one.pucp.supermercado.dao;

import pe.one.pucp.supermercado.model.GenericModel;

import java.util.List;

// read on: http://www.codeproject.com/Articles/251166/The-Generic-DAO-pattern-in-Java-with-Spring-and
public interface GenericDao<T extends GenericModel> {

    List<T> list() throws RuntimeException;

    T insertOrUpdate(T t) throws RuntimeException;

    void delete(Object id) throws RuntimeException;

    T find(Object id) throws RuntimeException;
}
