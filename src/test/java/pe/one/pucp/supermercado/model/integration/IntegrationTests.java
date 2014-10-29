package pe.one.pucp.supermercado.model.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import org.springframework.transaction.annotation.Transactional;
//import javax.persistence.EntityManager;

/**
 * Clase IntegrationTests.
 *
 * @author lmiguelmh
 * @version 0.0.1
 * @since 20/10/2014 05:21 PM
 */
@RunWith(SpringJUnit4ClassRunner. class)
//@ContextConfiguration(classes = {JPAConfiguration.class})
//@Transactional
//@TransactionConfiguration(defaultRollback = true)
public class IntegrationTests {

    @Test
    public void test() {
    }
    //@Autowired
    //EntityManager manager;
    //
    //@Test
    //public void testItemCustomMappingWorks() throws Exception {
    //    assertTableExists(manager, "SMTM_CLIENTE");
    //    //assertTableExists(manager, "SMTM_PRODUCTO");
    //    //assertTableExists(manager, "SMTM_USUARIO");
    //    //assertTableExists(manager, "SMTM_VENDEDOR");
    //    /*
    //    assertTableHasColumn(manager, "NOODLE_ORDERS", "ORDER_ID");
    //    assertTableHasColumn(manager, "NOODLE_ORDERS", "SUBMISSION_DATETIME");
    //    */
    //}
}
