package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import modelo.dao.VentaDao;
import modelo.dto.Venta;
import controlador.ControladorInformeVentas;

public class VistaInformeVentas extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTotales;

    public VistaInformeVentas() {
        setTitle("Informe de Ventas Realizadas");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"Factura", "Fecha", "Cliente", "Aumento", "Reducción", "Valor Total Venta"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        lblTotales = new JLabel("Totales - Aumento: 0.0, Reducción: 0.0, Valor Total: 0.0");
        lblTotales.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotales.setFont(new Font("Arial", Font.BOLD, 14));

        add(scrollPane, BorderLayout.CENTER);
        add(lblTotales, BorderLayout.SOUTH);
    }

    public void agregarVenta(String factura, String fecha, String cliente, double aumento, double reduccion, double valorTotal) {
        modelo.addRow(new Object[]{
            factura,
            fecha,
            cliente,
            String.format("%.2f", aumento),
            String.format("%.2f", reduccion),
            String.format("%.2f", valorTotal)
        });
    }

    public void mostrarTotales(double totalAumento, double totalReduccion, double totalValorVenta) {
        lblTotales.setText(String.format("Totales - Aumento: %.2f, Reducción: %.2f, Valor Total: %.2f",
                totalAumento, totalReduccion, totalValorVenta));
    }

    public static void main(String[] args) {
        VentaDao dao = new VentaDao();

        dao.agregarVenta(new Venta("#0394", "Manzanas", 10, 500, 5200, "Aumento", 200));

        VistaInformeVentas vista = new VistaInformeVentas();
        new ControladorInformeVentas(vista, dao);
    }
}

