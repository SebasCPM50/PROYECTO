package modelo.dto;

public class Venta {
    private String codigoProducto;
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private double totalPorProducto;
    private String tipoAjuste; // si es aumwnto o reduccion
    private double valorAjuste;

    public Venta(String codigoProducto, String nombreProducto, int cantidad, double precioUnitario, double totalPorProducto, String tipoAjuste, double valorAjuste) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalPorProducto = totalPorProducto;
        this.tipoAjuste = tipoAjuste;
        this.valorAjuste = valorAjuste;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getTotalPorProducto() {
        return totalPorProducto;
    }

    public String getTipoAjuste() {
        return tipoAjuste;
    }

    public double getValorAjuste() {
        return valorAjuste;
    }
}
