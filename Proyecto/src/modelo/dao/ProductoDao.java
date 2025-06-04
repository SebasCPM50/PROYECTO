package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.dto.Producto;

public class ProductoDao {

    private List<Producto> listaProducto;

    public ProductoDao() {
        listaProducto = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProducto.add(producto); 
    }

    public void modificarProducto(Producto producto) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getCodigo().equals(producto.getCodigo())) {
                listaProducto.set(i, producto);
                return;
            }
        }
    }

    public void eliminarProducto(String codigo) {
        listaProducto.removeIf(p -> p.getCodigo().equals(codigo));
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : listaProducto) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> lista() {
        return listaProducto;
    }
} 
