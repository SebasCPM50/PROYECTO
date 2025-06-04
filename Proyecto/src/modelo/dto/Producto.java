package modelo.dto;

public abstract class Producto {
    protected String codigo;
    protected String descripcion;
    protected double precio;

    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public abstract double calcularPrecioVenta();

    public String getCodigo() { 
    	return codigo; 
    	}
    public String getDescripcion() { 
    	return descripcion; 
    	}
    public double getPrecio() { 
    	return precio; 
    	}

    public void setCodigo(String codigo) { 
    	this.codigo = codigo; 
    	}
    public void setDescripcion(String descripcion) { 
    	this.descripcion = descripcion; 
    	}
    public void setPrecio(double precio) { 
    	this.precio = precio; 
    	}
    
    
}