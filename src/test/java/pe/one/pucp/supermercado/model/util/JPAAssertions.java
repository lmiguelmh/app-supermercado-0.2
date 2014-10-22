package pe.one.pucp.supermercado.model.util;

//import org.hibernate.Session;
//import org.hibernate.internal.SessionImpl;
//import org.hibernate.jdbc.Work;
//
//import javax.persistence.EntityManager;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;

/**
 * Clase JPAAssertions.
 *
 * @author lmiguelmh
 * @version 0.0.1
 * @since 20/10/2014 05:14 PM
 */
public class JPAAssertions {

    //public static void assertTableExists(EntityManager manager, final String name) {
    //    SessionImpl session = (SessionImpl) manager.unwrap(Session.class);
    //
    //    final ResultCollector rc = new ResultCollector();
    //
    //    session.doWork(new Work() {
    //        @Override
    //        public void execute(Connection connection) throws SQLException {
    //            ResultSet tables = connection.getMetaData().getTables(null, null, "%", null);
    //            while(tables.next()) {
    //                if (tables.getString(3).toUpperCase().equals(name.toUpperCase())) {
    //                    rc.found=true;
    //                }
    //            }
    //        }
    //    });
    //
    //    if (!rc.found) {
    //        fail("Table not found in schema : " + name);
    //    }
    //}
    //
    //static class ResultCollector {
    //    public boolean found = false;
    //}
}
