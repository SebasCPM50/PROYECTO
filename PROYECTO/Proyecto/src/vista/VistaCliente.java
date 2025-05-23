package vista;

import javax.swing.*;
import java.awt.*;

public class VistaCliente extends JFrame {
    public JTextField tFId, tFNombre;
    public JButton btnRegistrar, btnModificar, btnEliminar, btnBuscar;

    public VistaCliente() {
        setTitle("Gestión de Clientes");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblId = new JLabel("ID:");
        tFId = new JTextField();

        JLabel lblNombre = new JLabel("Nombre:");
        tFNombre = new JTextField();

        btnRegistrar = new JButton("Registrar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");

        getContentPane().add(lblId);
        getContentPane().add(tFId);
        getContentPane().add(lblNombre);
        getContentPane().add(tFNombre);
        getContentPane().add(btnRegistrar);
        getContentPane().add(btnModificar);
        getContentPane().add(btnEliminar);
        getContentPane().add(btnBuscar);
    }
}

