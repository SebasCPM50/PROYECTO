package controlador;

import modelo.dao.ProductoDao;
import modelo.dto.Producto;
import modelo.dto.Perecedero;
import vista.VistaInformePerecederos;

public class ControladorInformePerecederos {
private VistaInformePerecederos vista;
private ProductoDao dao;

public ControladorInformePerecederos(VistaInformePerecederos vista, ProductoDao dao) {
    this.vista = vista;
    this.dao = dao;
    cargarProductos();
    vista.setVisible(true); // Muestra la ventana
}

private void cargarProductos() {
    for (Producto p : dao.lista()) {
        if (p instanceof Perecedero) {
            Perecedero per = (Perecedero) p;
            double descuento = per.PorcentajeDescuento() * 100;
            vista.agregarProducto(per.getCodigo(), per.getDescripcion(), per.getPrecio(), per.getDiasCaducar(), descuento);
        }
    }
}
}