package pe.one.pucp.supermercado.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.ProductoDao;
import pe.one.pucp.supermercado.dao.mem.AbstractGenericDao;
import pe.one.pucp.supermercado.model.Cliente;
import pe.one.pucp.supermercado.model.Producto;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductoDaoImp
        extends DataSourceAbstractGenericDao<Producto>
        implements ProductoDao {

    @Autowired
    public ProductoDaoImp(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    final String INSERT = "insert into smtm_producto values(?, ?, ?, ?, ?)";
    @Override
    protected Producto _insert(Producto producto) throws RuntimeException {
        jdbcTemplate.update(INSERT, producto.getCoProducto(), producto.getNoProducto(), producto.getPrecioCompra(), producto.getPrecioVenta(), producto.getInventario());
        return producto;
    }

    final String UPDATE = "update smtm_producto set no_producto=?, precio_compra=?, precio_venta=?, inventario=? where co_producto=?";
    @Override
    protected Producto _update(Producto producto) throws RuntimeException {
        jdbcTemplate.update(UPDATE, producto.getNoProducto(), producto.getPrecioCompra(), producto.getPrecioVenta(), producto.getInventario(), producto.getCoProducto());
        return producto;
    }

    final String DELETE = "delete smtm_producto where co_producto=? limit 1";
    @Override
    protected void _delete(Object id) throws RuntimeException {
        jdbcTemplate.update(DELETE, new Object[]{id}, new int[]{Types.NVARCHAR});
    }

    final String SELECT = "select * from smtm_producto where co_producto=?";
    @Override
    protected Producto _find(Object id) throws RuntimeException {
        Producto producto;
        try {
            producto = jdbcTemplate.queryForObject(SELECT, BeanPropertyRowMapper.newInstance(Producto.class), new Object[]{id});
        } catch (EmptyResultDataAccessException e) {
            log.error("ID=" + id + " " + e.getMessage());
            producto = null;
        } catch (IncorrectResultSizeDataAccessException e) {
            log.error("ID=" + id + " " + e.getMessage());
            producto = null;
        }
        return producto;
    }

    final String SELECT_ALL = "select * from smtm_producto";
    @Override
    public List<Producto> list() throws RuntimeException {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Producto.class));
    }

    final String SELECT_LIKE_ID = "select * from smtm_producto where co_producto like ?";
    @Override
    public List<Producto> listLikeId(Object id) throws RuntimeException {
        return jdbcTemplate.query(SELECT_LIKE_ID, BeanPropertyRowMapper.newInstance(Producto.class), id);
    }
}
