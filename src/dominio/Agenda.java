package dominio;

public class Agenda {
    //crear una agenda de clientes
    private Cliente[] clientes;

    public Agenda() {
        this.clientes = new Cliente[100];
    }

    //agregar clientes a la agenda
    public void agregarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                cliente.add(cliente);
                break;
            }
        }
    }

    public void mostrarClientes() {
        for (int i = 0; i < clientes.length; i++) {
            System.out.println(clientes[i].getNombre() + " " + clientes[i].getApellido());
        }
    }

    //buscar un cliente por dni
    public Cliente buscarCliente(String dni) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                return clientes[i];
            }
        }
        return null;
    }

    //eliminar un cliente por dni
    public void eliminarCliente(String dni) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                clientes[i] = null;
                break;
            }
        }
    }

    //modificar un cliente por dni







}
