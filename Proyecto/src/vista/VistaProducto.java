package vista;

import javax.swing.*;

import controlador.ControladorProducto;
import modelo.dao.ProductoDao;

import java.awt.*;

public class VistaProducto extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtDiasCaducar;
    private JTextField txtTipo;

    private JRadioButton rdbPerecedero;
    private JRadioButton rdbNoPerecedero;

    private JButton btnGuardar;

    public VistaProducto() {
        setTitle("Registro de Producto");
        setBounds(100, 100, 400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 20, 80, 20);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 200, 20);
        getContentPane().add(txtCodigo);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(30, 50, 80, 20);
        getContentPane().add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(120, 50, 200, 20);
        getContentPane().add(txtDescripcion);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 80, 80, 20);
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(120, 80, 200, 20);
        getContentPane().add(txtPrecio);

        rdbPerecedero = new JRadioButton("Perecedero");
        rdbPerecedero.setBounds(30, 110, 120, 20);
        getContentPane().add(rdbPerecedero);

        rdbNoPerecedero = new JRadioButton("No Perecedero");
        rdbNoPerecedero.setBounds(150, 110, 150, 20);
        getContentPane().add(rdbNoPerecedero);

        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(rdbPerecedero);
        grupoTipo.add(rdbNoPerecedero);

        JLabel lblDiasCaducar = new JLabel("Días a caducar:");
        lblDiasCaducar.setBounds(30, 140, 120, 20);
        getContentPane().add(lblDiasCaducar);

        txtDiasCaducar = new JTextField();
        txtDiasCaducar.setBounds(150, 140, 100, 20);
        getContentPane().add(txtDiasCaducar);

        JLabel lblTipo = new JLabel("Tipo (1-3):");
        lblTipo.setBounds(30, 170, 100, 20);
        getContentPane().add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(150, 170, 100, 20);
        getContentPane().add(txtTipo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(120, 220, 120, 30);
        getContentPane().add(btnGuardar);
    }

    public JTextField getTxtCodigo() { return txtCodigo; }
    public JTextField getTxtDescripcion() { return txtDescripcion; }
    public JTextField getTxtPrecio() { return txtPrecio; }
    public JTextField getTxtDiasCaducar() { return txtDiasCaducar; }
    public JTextField getTxtTipo() { return txtTipo; }
    public JRadioButton getRdbPerecedero() { return rdbPerecedero; }
    public JRadioButton getRdbNoPerecedero() { return rdbNoPerecedero; }
    public JButton getBtnGuardar() { return btnGuardar; }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtDiasCaducar.setText("");
        txtTipo.setText("");
        rdbPerecedero.setSelected(false);
        rdbNoPerecedero.setSelected(false);
    }

    public static void main(String[] args) {
        VistaProducto vista = new VistaProducto();
        ProductoDao modelo = new ProductoDao();
        ControladorProducto controlador = new ControladorProducto(vista, modelo);
        vista.setVisible(true);
    }
}