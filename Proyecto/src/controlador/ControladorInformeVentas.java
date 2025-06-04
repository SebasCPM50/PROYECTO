package controlador;

import modelo.dao.VentaDao;
import modelo.dto.Venta;
import vista.VistaInformeVentas;

public class ControladorInformeVentas {

    private VistaInformeVentas vista;
    private VentaDao dao;

    public ControladorInformeVentas(VistaInformeVentas vista, VentaDao dao) {
        this.vista = vista;
        this.dao = dao;
        cargarVentas();
        vista.setVisible(true);
    }

    private void cargarVentas() {
        double totalAumento = 0;
        double totalReduccion = 0;
        double totalValorVenta = 0;

        // todas las ventas
        for (Venta v : dao.obtenerVentas()) {
            double aumento = 0;
            double reduccion = 0;

            if ("Aumento".equalsIgnoreCase(v.getTipoAjuste())) {
                aumento = v.getValorAjuste();
            } else if ("Reducción".equalsIgnoreCase(v.getTipoAjuste())) {
                reduccion = v.getValorAjuste();
            }

            // datos de factura, fecha y cliente para mostrar
            String factura = v.getCodigoProducto(); 
            String fecha = "2025-06-04";
            String cliente = "Sebastian Chaux";

            vista.agregarVenta(factura, fecha, cliente, aumento, reduccion, v.getTotalPorProducto());

            totalAumento += aumento;
            totalReduccion += reduccion;
            totalValorVenta += v.getTotalPorProducto();
        }

        vista.mostrarTotales(totalAumento, totalReduccion, totalValorVenta);
    }
}

