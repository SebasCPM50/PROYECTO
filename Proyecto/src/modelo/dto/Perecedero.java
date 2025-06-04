package modelo.dto;

public class Perecedero extends Producto {
    private int diasCaducar;

    public Perecedero(String codigo, String descripcion, double precio, int diasCaducar) {
        super(codigo, descripcion, precio);
        this.diasCaducar = diasCaducar;
    }

    @Override
    public double calcularPrecioVenta() {
        double descuento = switch (diasCaducar) {
            case 1 -> precio / 4;
            case 2 -> precio / 3;
            case 3 -> precio / 2;
            default -> 0;
        };
        return precio - descuento;
    }

    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }

    public double PorcentajeDescuento() {
        return switch (diasCaducar) {
            case 1 -> 0.25;
            case 2 -> 0.33;
            case 3 -> 0.50;
            default -> 0;
        };
    }
}
