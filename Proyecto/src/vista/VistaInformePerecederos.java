package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import modelo.dao.*;
import modelo.dto.*;
import controlador.*;
public class VistaInformePerecederos extends JFrame {

private JTable tabla;
private DefaultTableModel modelo;

public VistaInformePerecederos() {
    setTitle("Informe Productos Perecederos");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    String[] columnas = {"Código", "Descripción", "Precio", "Días para caducar", "Descuento %"};
    modelo = new DefaultTableModel(columnas, 0);
    tabla = new JTable(modelo);

    JScrollPane scrollPane = new JScrollPane(tabla);
    add(scrollPane, BorderLayout.CENTER);
}

public void agregarProducto(String codigo, String descripcion, double precio, int dias, double descuento) {
    modelo.addRow(new Object[]{codigo, descripcion, precio, dias, descuento + "%"});
}

public static void main(String[] args) {
ProductoDao dao = new ProductoDao();
dao.agregarProducto(new Perecedero("P402", "Pan", 3000, 1));

    VistaInformePerecederos vista = new VistaInformePerecederos();
    new ControladorInformePerecederos(vista, dao);
}
}