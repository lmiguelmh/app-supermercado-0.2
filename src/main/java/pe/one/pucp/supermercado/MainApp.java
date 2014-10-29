package pe.one.pucp.supermercado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import pe.one.pucp.supermercado.ui.MainUI;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: lmiguelmh
 * Date: 14/10/14
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
// extend from JFrame http://stackoverflow.com/questions/22864008/how-to-configure-spring-boot-with-swing-application
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"pe.one"})
public class MainApp extends JFrame implements CommandLineRunner {

    @Autowired
    MainUI mainUI;

    @Bean
    //@ConfigurationProperties(prefix="jdbc")
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUrl("jdbc:h2:file:./sm-1.0");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

    @Override
    public void run(String... args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame("MainUI");
                    //MainUI mainUI = new MainUI();
                    mainUI.setLabelText("PUCP2014");
                    frame.setContentPane(mainUI.getMainPanel());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setPreferredSize(new Dimension(200, 300));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        /*
        org.springframework.jdbc.datasource.SimpleDriverDataSource dataSource = new org.springframework.jdbc.datasource.SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("");
        dataSource.setUrl("jdbc:h2:file:G:/h2/bin/test");
        dataSource.setPassword("");

        org.springframework.jdbc.core.JdbcTemplate jdbcTemplate = new org.springframework.jdbc.core.JdbcTemplate(dataSource);
        System.out.println("Creating tables");
        jdbcTemplate.execute("select * from smtm_cliente");
        */

    }


    public static void main(String[] args) throws Exception {

        /*
        DriverManager.registerDriver(new org.h2.Driver());
        Connection c = DriverManager.getConnection("jdbc:h2:file:G:/h2/bin/test");
        Statement s = c.createStatement();
        try {
            s.execute("select * from smtm_cliente");
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
        /*PreparedStatement stmt = c.prepareStatement("CREATE TABLE PERSON (ID INT PRIMARY KEY, FIRSTNAME VARCHAR(64), LASTNAME VARCHAR(64))");
        stmt.execute();
        stmt.close();
        * /
        c.close();
        */

        /*
        org.springframework.jdbc.datasource.SimpleDriverDataSource dataSource = new org.springframework.jdbc.datasource.SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("");
        dataSource.setUrl("jdbc:h2:G:\\h2\\bin\\test");
        dataSource.setPassword("");


        org.springframework.jdbc.core.JdbcTemplate jdbcTemplate = new org.springframework.jdbc.core.JdbcTemplate(dataSource);
        System.out.println("Creating tables");
        jdbcTemplate.update("select * from smtm_cliente");
                          */
        SpringApplication.run(MainApp.class, args);
    }
}