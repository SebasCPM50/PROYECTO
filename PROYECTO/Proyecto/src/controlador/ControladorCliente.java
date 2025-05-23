package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.dao.ClienteDao;
import modelo.dto.Cliente;
import vista.VistaCliente;

public class ControladorCliente implements ActionListener {
    private VistaCliente vista;
    private ClienteDao modelo;
    private Cliente cliente;

    public ControladorCliente(VistaCliente vista) {
        this.vista = vista;
        this.modelo = new ClienteDao();
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnRegistrar)) {
            cliente = new Cliente();
            cliente.setId(vista.tFId.getText());
            cliente.setNombre(vista.tFNombre.getText());

            modelo.agregarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
        }

        if (e.getSource().equals(vista.btnModificar)) {
            cliente = new Cliente();
            cliente.setId(vista.tFId.getText());
            cliente.setNombre(vista.tFNombre.getText());

            modelo.modificarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente modificado correctamente");
        }

        if (e.getSource().equals(vista.btnEliminar)) {
            cliente = new Cliente();
            cliente.setId(vista.tFId.getText());

            modelo.eliminarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
        }

        if (e.getSource().equals(vista.btnBuscar)) {
            cliente = new Cliente();
            cliente.setId(vista.tFId.getText());

            cliente = modelo.buscarCliente(cliente);
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            } else {
                vista.tFNombre.setText(cliente.getNombre());
            }
        }
    }
}
