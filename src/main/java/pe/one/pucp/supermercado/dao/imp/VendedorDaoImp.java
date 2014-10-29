package pe.one.pucp.supermercado.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.VendedorDao;
import pe.one.pucp.supermercado.dao.mem.AbstractGenericDao;
import pe.one.pucp.supermercado.model.Producto;
import pe.one.pucp.supermercado.model.Vendedor;
import pe.one.pucp.supermercado.ui.swing.VentaUISwing;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VendedorDaoImp
        extends DataSourceAbstractGenericDao<Vendedor>
        implements VendedorDao {

    @Autowired
    public VendedorDaoImp(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    final String INSERT = "insert into smtm_vendedor values(?, ?, ?)";
    @Override
    protected Vendedor _insert(Vendedor vendedor) throws RuntimeException {
        jdbcTemplate.update(INSERT, vendedor.getCoVendedor(), vendedor.getNoVendedor(), vendedor.getEsVendedor());
        return vendedor;
    }

    final String UPDATE = "update smtm_vendedor set no_vendedor=?, es_vendedor=? where co_vendedor=?";
    @Override
    protected Vendedor _update(Vendedor vendedor) throws RuntimeException {
        jdbcTemplate.update(UPDATE, vendedor.getNoVendedor(), vendedor.getEsVendedor(), vendedor.getCoVendedor());
        return vendedor;
    }

    final String DELETE = "delete smtm_vendedor where co_vendedor=? limit 1";
    @Override
    protected void _delete(Object id) throws RuntimeException {
        jdbcTemplate.update(DELETE, new Object[]{id}, new int[]{Types.NVARCHAR});
    }

    final String SELECT = "select * from smtm_vendedor where co_vendedor=?";
    @Override
    protected Vendedor _find(Object id) throws RuntimeException {
        Vendedor vendedor;
        try {
            vendedor = jdbcTemplate.queryForObject(SELECT, BeanPropertyRowMapper.newInstance(Vendedor.class), new Object[]{id});
        } catch (EmptyResultDataAccessException e) {
            log.error("ID=" + id + " " + e.getMessage());
            vendedor = null;
        } catch (IncorrectResultSizeDataAccessException e) {
            log.error("ID=" + id + " " + e.getMessage());
            vendedor = null;
        }
        return vendedor;
    }

    final String SELECT_ALL = "select * from smtm_vendedor";
    @Override
    public List<Vendedor> list() throws RuntimeException {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Vendedor.class));
    }

    final String SELECT_LIKE_ID = "select * from smtm_vendedor where co_vendedor like ?";
    @Override
    public List<Vendedor> listLikeId(Object id) throws RuntimeException {
        return jdbcTemplate.query(SELECT_LIKE_ID, BeanPropertyRowMapper.newInstance(Vendedor.class), id);
    }
}
