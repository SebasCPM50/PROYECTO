package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import modelo.dto.Cliente;
import modelo.dao.ClienteDao;
import controlador.ControladorCliente;

public class VistaCliente extends JFrame {
    private JTextField txtId;
    private JTextField txtNombre;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;

    public VistaCliente() {
        setTitle("Gestión de Clientes");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 20, 100, 25);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(130, 20, 150, 25);
        getContentPane().add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 100, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 60, 150, 25);
        getContentPane().add(txtNombre);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(310, 20, 120, 25);
        getContentPane().add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(310, 55, 120, 25);
        getContentPane().add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(310, 90, 120, 25);
        getContentPane().add(btnEliminar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(310, 125, 120, 25);
        getContentPane().add(btnBuscar);

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0);
        tablaClientes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        scrollPane.setBounds(30, 170, 400, 150);
        getContentPane().add(scrollPane);
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JTable getTablaClientes() {
        return tablaClientes;
    }

    public void actualizarTabla(List<Cliente> lista) {
        modeloTabla.setRowCount(0);
        for (Cliente c : lista) {
            modeloTabla.addRow(new Object[]{c.getId(), c.getNombre()});
        }
    }

    public static void main(String[] args) {
        VistaCliente vista = new VistaCliente();
        ClienteDao dao = new ClienteDao();
        new ControladorCliente(vista, dao);
        vista.setVisible(true);
    }
}