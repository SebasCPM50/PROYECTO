package controlador;

import modelo.dao.*;
import modelo.dto.*;
import vista.VistaInformeNoPerecederos;

import java.util.List;
import java.util.ArrayList;

public class ControladorInformeNoPerecederos {
	public ControladorInformeNoPerecederos(ProductoDao dao) {
	    List<Producto> todos = dao.lista();
	    List<NoPerecedero> noPerecederos = new ArrayList<>();


for (Producto p : todos) {
    if (p instanceof NoPerecedero) {
        noPerecederos.add((NoPerecedero) p);
    }
}

VistaInformeNoPerecederos vista = new VistaInformeNoPerecederos(noPerecederos);
vista.setVisible(true);
}
}