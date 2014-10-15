package pe.one.pucp.supermercado.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.one.pucp.supermercado.service.HelloWorldService;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: lmiguelmh
 * Date: 14/10/14
 * Time: 09:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MainUI implements CommandLineRunner {
    private JPanel mainPanel;
    private JButton listarPersonasButton;
    private JButton agregarPersonaButton;
    private JButton listarProductosButton;
    private JButton agregarProductoButton;
    private JLabel sampleLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainUI");
        frame.setContentPane(new MainUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public void run(String... arg0) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame("MainUI");
                    MainUI mainUI = new MainUI();
                    mainUI.setLabelText(helloWorldService.getHelloMessage());
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

    private void setLabelText(String text) {
        sampleLabel.setText(text);
    }
}
