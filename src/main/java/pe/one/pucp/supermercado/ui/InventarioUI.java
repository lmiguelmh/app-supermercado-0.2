package pe.one.pucp.supermercado.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.one.pucp.supermercado.controller.InventarioUIController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: lmiguelmh
 * Date: 21/10/14
 * Time: 09:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class InventarioUI {
    private JPanel mainPanel;
    private JTextField codigoTextField;
    private JTextField nombreTextField;
    private JTextField inventarioTextField;
    private JButton nuevoButton;
    private JButton randomButton;
    private JButton insertarButton;
    private JTable inventarioTable;
    private JTextField precioCompraTextField;
    private JTextField precioVentaTextField;

    @Autowired
    InventarioUIController controller;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public InventarioUI() {
        /*
        final NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        format.setParseIntegerOnly(true);
        format.setRoundingMode(RoundingMode.HALF_UP);

        final NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMaximum(100000.0);
        formatter.setMinimum(0.0);
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(false);

        precioCompraTextField.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return formatter;
            }
        });
        precioCompraTextField.setValue(1235.5);

        precioVentaTextField.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return formatter;
            }
        });
        */

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.nuevoClick();
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.randomClick();
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertarClick();
            }
        });

        inventarioTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                controller.tableSelectionChanged();
            }
        });
    }

    public String getCodigo() {
        return codigoTextField.getText();
    }

    public String getInventario() {
        return inventarioTextField.getText();
    }

    public String getNombre() {
        return nombreTextField.getText();
    }

    public String getPrecioCompra() {
        return precioCompraTextField.getText();
    }

    public String getPrecioVenta() {
        return precioVentaTextField.getText();
    }

    public void setCodigo(String codigo) {
        codigoTextField.setText(codigo);
    }

    public void setInventario(String inventario) {
        inventarioTextField.setText(inventario);
    }

    public void setNombre(String nombre) {
        nombreTextField.setText(nombre);
    }

    public void setPrecioCompra(String precioCompra) {
        precioCompraTextField.setText(precioCompra);
    }

    public void setPrecioVenta(String precioVenta) {
        precioVentaTextField.setText(precioVenta);
    }

    public void setTableModel(TableModel tableModel) {
        inventarioTable.setModel(tableModel);
    }

    public void setFocusInCodigo() {
        codigoTextField.requestFocus();
    }

    public int getSelectedRow() {
        return inventarioTable.getSelectedRow();
    }

    public Object getSelectedCodigo() {
        int row = getSelectedRow();
        if (row >= 0) {
            return inventarioTable.getModel().getValueAt(getSelectedRow(), 0);
        }
        return null;
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
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        mainPanel.add(panel1, BorderLayout.NORTH);
        final JLabel label1 = new JLabel();
        label1.setText("Código");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer2, gbc);
        codigoTextField = new JTextField();
        codigoTextField.setPreferredSize(new Dimension(200, 28));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(codigoTextField, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Nombre");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label2, gbc);
        nombreTextField = new JTextField();
        nombreTextField.setPreferredSize(new Dimension(200, 28));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(nombreTextField, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Precio Compra");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Precio Venta");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("Inventario");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label5, gbc);
        inventarioTextField = new JTextField();
        inventarioTextField.setPreferredSize(new Dimension(200, 28));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(inventarioTextField, gbc);
        nuevoButton = new JButton();
        nuevoButton.setText("Nuevo");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(nuevoButton, gbc);
        insertarButton = new JButton();
        insertarButton.setText("Insertar");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(insertarButton, gbc);
        randomButton = new JButton();
        randomButton.setText("Random");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(randomButton, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer3, gbc);
        precioCompraTextField = new JTextField();
        precioCompraTextField.setColumns(4);
        precioCompraTextField.setPreferredSize(new Dimension(50, 28));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(precioCompraTextField, gbc);
        precioVentaTextField = new JTextField();
        precioVentaTextField.setPreferredSize(new Dimension(200, 28));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(precioVentaTextField, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        mainPanel.add(panel2, BorderLayout.CENTER);
        final JScrollPane scrollPane1 = new JScrollPane();
        panel2.add(scrollPane1, BorderLayout.CENTER);
        inventarioTable = new JTable();
        inventarioTable.setAutoCreateRowSorter(true);
        scrollPane1.setViewportView(inventarioTable);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(0, 0));
        mainPanel.add(panel3, BorderLayout.SOUTH);
        final JLabel label6 = new JLabel();
        label6.setHorizontalAlignment(0);
        label6.setHorizontalTextPosition(0);
        label6.setText("PUCP 2014");
        panel3.add(label6, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}