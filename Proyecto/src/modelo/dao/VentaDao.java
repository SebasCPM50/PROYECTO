package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.dto.Venta;

public class VentaDao {
    private List<Venta> listaVentas = new ArrayList<>();

    public void agregarVenta(Venta venta) {
        listaVentas.add(venta);
    }

    public List<Venta> obtenerVentas() {
        return listaVentas;
    }

    public double calcularTotalGeneral() {
        double total = 0.0;
        for (Venta v : listaVentas) {
            total += v.getTotalPorProducto();
        }
        return total;
    }

    public void imprimirFactura(String nombreCliente, String idCliente) {
        System.out.println("FACTURA");
        System.out.println("Cliente: " + nombreCliente + " (ID: " + idCliente + ")");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s %-15s %-8s %-10s %-10s\n", "Código", "Producto", "Cant.", "P.Unit", "Total");
        for (Venta v : listaVentas) {
            System.out.printf("%-10s %-15s %-8d %-10.2f %-10.2f\n",
                    v.getCodigoProducto(),
                    v.getNombreProducto(),
                    v.getCantidad(),
                    v.getPrecioUnitario(),
                    v.getTotalPorProducto());
            if (!v.getTipoAjuste().isEmpty()) {
                System.out.printf("    [%s %.2f%%]\n", v.getTipoAjuste(), v.getValorAjuste());
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL A PAGAR: %.2f\n", calcularTotalGeneral());
        System.out.println("===============================");
    }
}