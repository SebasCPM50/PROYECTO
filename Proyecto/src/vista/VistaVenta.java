package vista;

import javax.swing.*;
import java.awt.*;

public class VistaVenta extends JFrame {
    private JTextField txtCodigo;
    private JTextField txtCantidad;
    private JTextField txtIdCliente;
    private JButton btnAgregar;
    private JButton btnFacturar;

    public VistaVenta() {
        setTitle("Módulo Venta");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(5, 2, 5, 5));

        getContentPane().add(new JLabel("Código Producto:"));
        txtCodigo = new JTextField();
        getContentPane().add(txtCodigo);

        getContentPane().add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        getContentPane().add(txtCantidad);

        getContentPane().add(new JLabel("ID Cliente:"));
        txtIdCliente = new JTextField();
        getContentPane().add(txtIdCliente);

        btnAgregar = new JButton("Agregar");
        getContentPane().add(btnAgregar);

        btnFacturar = new JButton("Facturar");
        getContentPane().add(btnFacturar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public JTextField getTxtIdCliente() {
        return txtIdCliente;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnFacturar() {
        return btnFacturar;
    }

    public static void main(String[] args) {
        VistaVenta vista = new VistaVenta();
    }
}