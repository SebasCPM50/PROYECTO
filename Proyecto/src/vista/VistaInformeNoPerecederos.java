package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import modelo.dto.*;
import modelo.dao.*;
import controlador.*;

public class VistaInformeNoPerecederos extends JFrame {
	
private JTable tabla;
private DefaultTableModel modelo;

public VistaInformeNoPerecederos(List<NoPerecedero> productos) {
    setTitle("Informe de Productos No Perecederos");
    setSize(700, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{
        "Código", "Descripción", "Precio Original", "Tipo", "Precio con Aumento", "Aumento (%)"
    });

    for (NoPerecedero p : productos) {
        double precioAjustado = p.calcularPrecioVenta();
        double porcentaje = (precioAjustado - p.getPrecio()) / p.getPrecio() * 100;

        modelo.addRow(new Object[]{
            p.getCodigo(),
            p.getDescripcion(),
            p.getPrecio(),
            p.getTipo(),
            precioAjustado,
            String.format("%.2f%%", porcentaje)
        });
    }

    tabla = new JTable(modelo);
    add(new JScrollPane(tabla), BorderLayout.CENTER);
}

public static void main(String[] args) {
ProductoDao dao = new ProductoDao();
dao.agregarProducto(new NoPerecedero("P401", "Leche", 5000, 2));
new ControladorInformeNoPerecederos(dao);
}
}