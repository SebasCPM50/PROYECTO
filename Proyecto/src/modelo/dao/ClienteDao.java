package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.dto.Cliente;

public class ClienteDao {
    private List<Cliente> listaClientes;

    public ClienteDao() {
        listaClientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void modificarCliente(Cliente cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId().equals(cliente.getId())) {
                listaClientes.set(i, cliente);
                break;
            }
        }
    }

    public void eliminarCliente(String id) {
    	for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId().equals(id)) {
                listaClientes.remove(i);
                break;
            }
        }
    }

    public Cliente buscarCliente(String id) {
        for (Cliente c : listaClientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
    
    public List<Cliente> listar() {
        return listaClientes;
    }
}