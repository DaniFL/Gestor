package dominio;

public class Agenda {
    //crear una agenda de clientes
    private Cliente[] clientes;
    private int cantidadClientes;

    public Agenda(int cantidadClientes) {
        this.clientes = new Cliente[cantidadClientes];
        this.cantidadClientes = 0;
    }

    public void agregarCliente(Cliente cliente) {
        if (cantidadClientes < clientes.length) {
            clientes[cantidadClientes] = cliente;
            cantidadClientes++;
        }
    }

    public void mostrarClientes() {
        for (int i = 0; i < cantidadClientes; i++) {
            System.out.println(clientes[i].getNombre() + " " + clientes[i].getApellido());
        }
    }

    //buscar un cliente por dni
    public Cliente buscarCliente(String dni) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getDni().equals(dni)) {
                return clientes[i];
            }
        }
        return null;
    }

    //eliminar un cliente por dni
    public void eliminarCliente(String dni) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getDni().equals(dni)) {
                clientes[i] = clientes[cantidadClientes - 1];
                cantidadClientes--;
            }
        }
    }

    //modificar un cliente por dni
    public void modificarCliente(String dni, Cliente cliente) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getDni().equals(dni)) {
                clientes[i] = cliente;
            }
        }
    }








}
