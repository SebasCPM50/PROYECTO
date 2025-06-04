package modelo.dto;

public class NoPerecedero extends Producto {
    private int tipo;

    public NoPerecedero(String codigo, String descripcion, double precio, int tipo) {
        super(codigo, descripcion, precio);
        this.tipo = tipo;
    }

    @Override
    public double calcularPrecioVenta() {
        double aumento = switch (tipo) {
            case 1 -> precio * 0.03;
            case 2 -> precio * 0.02;
            case 3 -> precio * 0.01;
            default -> 0;
        };
        return precio + aumento;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    // NUEVO MÉTODO
    public double PorcentajeAumento() {
        return switch (tipo) {
            case 1 -> 0.03;
            case 2 -> 0.02;
            case 3 -> 0.01;
            default -> 0;
        };
    }
}
