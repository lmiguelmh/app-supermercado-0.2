package pe.one.pucp.supermercado.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.one.pucp.supermercado.dao.ClienteDao;
import pe.one.pucp.supermercado.dao.mem.AbstractGenericDao;
import pe.one.pucp.supermercado.model.Cliente;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteDaoImp
        extends DataSourceAbstractGenericDao<Cliente>
        implements ClienteDao {

    @Autowired
    public ClienteDaoImp(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    final String INSERT = "insert into smtm_cliente values(?, ?, ?)";
    @Override
    protected Cliente _insert(Cliente cliente) throws RuntimeException {
        jdbcTemplate.update(INSERT, cliente.getCoCliente(), cliente.getNoCliente(), cliente.getClasificacion());
        return cliente;
    }

    final String UPDATE = "update smtm_cliente set no_cliente=?, clasificacion=? where co_cliente=?";
    @Override
    protected Cliente _update(Cliente cliente) throws RuntimeException {
        jdbcTemplate.update(UPDATE, cliente.getNoCliente(), cliente.getClasificacion(), cliente.getCoCliente());
        return cliente;
    }

    final String DELETE = "delete smtm_cliente where co_cliente=? limit 1";
    @Override
    protected void _delete(Object id) throws RuntimeException {
        jdbcTemplate.update(DELETE, new Object[]{id}, new int[]{Types.NVARCHAR});
    }

    final String SELECT = "select * from smtm_cliente where co_cliente=?";
    @Override
    protected Cliente _find(Object id) throws RuntimeException {
        Cliente cliente;
        try {
            cliente = jdbcTemplate.queryForObject(SELECT, BeanPropertyRowMapper.newInstance(Cliente.class), new Object[]{id});
            //cliente = jdbcTemplate.queryForObject(SELECT, BeanPropertyRowMapper.newInstance(Cliente.class), new Object[]{id}, new int[]{Types.NVARCHAR});
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            cliente = null;
        } catch (IncorrectResultSizeDataAccessException e) {
            e.printStackTrace();
            cliente = null;
        }
        return cliente;
    }

    final String SELECT_ALL = "select * from smtm_cliente";
    @Override
    public List<Cliente> list() throws RuntimeException {
        return  jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Cliente.class));
    }
}
