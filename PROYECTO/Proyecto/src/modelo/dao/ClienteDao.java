package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.dto.Cliente;

public class ClienteDao {
    private List<Cliente> listaClientes = new ArrayList<>();

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

    public void eliminarCliente(Cliente cliente) {
        listaClientes.removeIf(c -> c.getId().equals(cliente.getId()));
    }

    public Cliente buscarCliente(Cliente cliente) {
        for (Cliente c : listaClientes) {
            if (c.getId().equals(cliente.getId())) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> lista() {
        return listaClientes;
    }
}
