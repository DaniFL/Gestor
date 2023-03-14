package dominio;

import java.util.ArrayList;

public class Agenda {
    //crear una agenda de clientes
    private ArrayList<Cliente> clientes;

    public Agenda() {
        clientes = new ArrayList<>();
    }

    //agregar clientes a la agenda
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    //mostrar todos los clientes
    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    //buscar un cliente por dni
    public Cliente buscarCliente(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    //eliminar un cliente por dni
    public void eliminarCliente(String dni) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }

    //modificar un cliente por dni
    public void modificarCliente(Cliente cliente) {
        Cliente cliente2 = buscarCliente(cliente.getDni());
        if (cliente2 != null) {
            cliente2.setNombre(cliente.getNombre());
        }
    }



}

