package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.dao.ProductoDao;
import modelo.dto.Producto;
import modelo.dto.Perecedero;
import modelo.dto.NoPerecedero;
import vista.VistaProducto;

public class ControladorProducto implements ActionListener {

    private VistaProducto vista;
    private ProductoDao modelo;

    public ControladorProducto(VistaProducto vista, ProductoDao modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtnGuardar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnGuardar()) {
            agregarProducto();
        }
    }

    private void agregarProducto() {
        String codigo = vista.getTxtCodigo().getText();
        String descripcion = vista.getTxtDescripcion().getText();
        double precio = Double.parseDouble(vista.getTxtPrecio().getText());

        Producto producto;

        if (vista.getRdbPerecedero().isSelected()) {
            int diasCaducar = Integer.parseInt(vista.getTxtDiasCaducar().getText());
            producto = new Perecedero(codigo, descripcion, precio, diasCaducar);
        } else {
            int tipo = Integer.parseInt(vista.getTxtTipo().getText());
            producto = new NoPerecedero(codigo, descripcion, precio, tipo);
        }

        modelo.agregarProducto(producto);
        vista.mostrarMensaje("Producto agregado correctamente.");
        vista.limpiarCampos();
    }
}
