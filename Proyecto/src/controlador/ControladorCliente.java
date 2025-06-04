package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.dao.ClienteDao;
import modelo.dto.Cliente;
import vista.VistaCliente;

public class ControladorCliente implements ActionListener {
    private VistaCliente vista;
    private ClienteDao modelo;

    public ControladorCliente(VistaCliente vista, ClienteDao modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // los botones
        this.vista.getBtnAgregar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);

        actualizarLista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            Cliente cliente = new Cliente(vista.getTxtId().getText(), vista.getTxtNombre().getText());
            modelo.agregarCliente(cliente);
        } else if (e.getSource() == vista.getBtnModificar()) {
            Cliente cliente = new Cliente(vista.getTxtId().getText(), vista.getTxtNombre().getText());
            modelo.modificarCliente(cliente);
        } else if (e.getSource() == vista.getBtnEliminar()) {
            modelo.eliminarCliente(vista.getTxtId().getText());
        } else if (e.getSource() == vista.getBtnBuscar()) {
            Cliente c = modelo.buscarCliente(vista.getTxtId().getText());
            if (c != null) vista.getTxtNombre().setText(c.getNombre());
        }
        actualizarLista();
    }

    private void actualizarLista() {
        vista.actualizarTabla(modelo.listar());
    }
}
