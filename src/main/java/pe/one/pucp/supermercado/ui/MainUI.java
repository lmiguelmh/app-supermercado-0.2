package pe.one.pucp.supermercado.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.one.pucp.supermercado.controller.MainUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: lmiguelmh
 * Date: 14/10/14
 * Time: 09:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MainUI {

    private JPanel mainPanel;
    private JButton listarPersonalButton;
    private JButton listarProductosButton;
    private JButton modificarProductosButton;
    private JLabel sampleLabel;
    private JButton modificarPersonalButton;
    private JButton listarClientesButton;
    private JButton modificarClientesButton;

    // 1 controller per view
    @Autowired
    MainUIController controller;

    public MainUI() {
        listarPersonalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.listarPersonalClick();
            }
        });
        modificarPersonalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.modificarPersonalClick();
            }
        });
        listarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.listarProductosClick();
            }
        });
        modificarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.modificarProductosClick();
            }
        });
        listarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.listarClientesClick();
            }
        });
        modificarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.modificarClientesClick();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setLabelText(String text) {
        sampleLabel.setText(text);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(panel1, gbc);
        listarPersonalButton = new JButton();
        listarPersonalButton.setText("Listar Personal");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(listarPersonalButton, gbc);
        modificarPersonalButton = new JButton();
        modificarPersonalButton.setText("AgregarModificar");
        modificarPersonalButton.setMnemonic('M');
        modificarPersonalButton.setDisplayedMnemonicIndex(7);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(modificarPersonalButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Personal");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Productos");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(label2, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(panel2, gbc);
        listarProductosButton = new JButton();
        listarProductosButton.setText("Listar Productos");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(listarProductosButton, gbc);
        modificarProductosButton = new JButton();
        modificarProductosButton.setText("AgregarModificar");
        modificarProductosButton.setMnemonic('M');
        modificarProductosButton.setDisplayedMnemonicIndex(7);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(modificarProductosButton, gbc);
        sampleLabel = new JLabel();
        sampleLabel.setText("pe-text");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(sampleLabel, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Clientes");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(label3, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(panel3, gbc);
        listarClientesButton = new JButton();
        listarClientesButton.setText("Listar Clientes");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(listarClientesButton, gbc);
        modificarClientesButton = new JButton();
        modificarClientesButton.setText("AgregarModificar");
        modificarClientesButton.setMnemonic('M');
        modificarClientesButton.setDisplayedMnemonicIndex(7);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(modificarClientesButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
