package aplicacion;

import dominio.Agenda;
import dominio.Cliente;

public class Principal {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(3);
        agenda.agregarCliente(new Cliente("Juan", "Perez", "12345678", "Calle 123", "123456789", "aa"));
        agenda.agregarCliente(new Cliente("Maria", "Gomez", "87654321", "Calle 321", "987654321", "bb"));
        agenda.agregarCliente(new Cliente("Pedro", "Gonzalez", "11111111", "Calle 111", "111111111", "cc"));
        agenda.mostrarClientes();
        System.out.println("Buscando cliente con dni 12345678");
        agenda.mostrarClientes();
    }
}
