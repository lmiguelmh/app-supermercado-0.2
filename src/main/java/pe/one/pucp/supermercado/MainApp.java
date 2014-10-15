package pe.one.pucp.supermercado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pe.one.pucp.supermercado.service.HelloWorldService;
import pe.one.pucp.supermercado.ui.MainUI;

import javax.swing.*;
import java.awt.*;

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
                    frame.pack();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApp.class, args);
    }
}