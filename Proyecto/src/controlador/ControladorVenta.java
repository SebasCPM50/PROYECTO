package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.ClienteDao;
import modelo.dao.ProductoDao;
import modelo.dao.VentaDao;
import modelo.dto.Cliente;
import modelo.dto.Producto;
import modelo.dto.Venta;
import vista.VistaVenta;

public class ControladorVenta {
    private VistaVenta vista;
    private ProductoDao productoDao;
    private ClienteDao clienteDao;
    private VentaDao ventaDao;

    public ControladorVenta(VistaVenta vista, ProductoDao productoDao, ClienteDao clienteDao, VentaDao ventaDao) {
        this.vista = vista;
        this.productoDao = productoDao;
        this.clienteDao = clienteDao;
        this.ventaDao = ventaDao;

        this.vista.getBtnAgregar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarProductoAVenta();
            }
        });

        this.vista.getBtnFacturar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarFactura();
            }
        });
    }

    private void agregarProductoAVenta() {
        String codProducto = vista.getTxtCodigo().getText();
        String idCliente = vista.getTxtIdCliente().getText();
        int cantidad;

        try {
            cantidad = Integer.parseInt(vista.getTxtCantidad().getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Cantidad inválida");
            return;
        }

        Producto producto = productoDao.buscarProducto(codProducto);
        if (producto == null) {
            JOptionPane.showMessageDialog(vista, "Producto no encontrado");
            return;
        }

        Cliente cliente = clienteDao.buscarCliente(idCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(vista, "Cliente no encontrado");
            return;
        }

        double precio = producto.calcularPrecioVenta();
        double total = precio * cantidad;

        String ajuste = producto instanceof modelo.dto.Perecedero ? "Reducción" :
                        producto instanceof modelo.dto.NoPerecedero ? "Aumento" : "";

        double valorAjuste = 0;
        if (producto instanceof modelo.dto.Perecedero) {
            valorAjuste = ((modelo.dto.Perecedero) producto).PorcentajeDescuento();
        } else if (producto instanceof modelo.dto.NoPerecedero) {
            valorAjuste = ((modelo.dto.NoPerecedero) producto).PorcentajeAumento();
        }

        Venta venta = new Venta(codProducto, producto.getDescripcion(), cantidad, producto.getPrecio(), total, ajuste, valorAjuste);
        ventaDao.agregarVenta(venta);

        JOptionPane.showMessageDialog(vista, "Producto agregado a la venta.");
    }

    private void generarFactura() {
        String idCliente = vista.getTxtIdCliente().getText();
        Cliente cliente = clienteDao.buscarCliente(idCliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar un cliente válido.");
            return;
        }

        ventaDao.imprimirFactura(cliente.getNombre(), cliente.getId());
    }
}
