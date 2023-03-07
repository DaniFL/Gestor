package aplicacion;

import dominio.Agenda;
import dominio.Cliente;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingrese la opcion que desea realizar");
                System.out.println("1. Agregar cliente");
                System.out.println("2. Mostrar clientes");
                System.out.println("3. Buscar cliente");
                System.out.println("4. Eliminar cliente");
                System.out.println("5. Modificar cliente");
                System.out.println("6. Salir");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la cantidad de clientes que desea agregar");
                        int cantidadClientes = sc.nextInt();
                        for (int i = 0; i < cantidadClientes; i++) {
                            System.out.println("Ingrese el nombre del cliente");
                            String nombre = sc.next();
                            System.out.println("Ingrese el apellido del cliente");
                            String apellido = sc.next();
                            System.out.println("Ingrese el dni del cliente");
                            String dni = sc.next();
                            System.out.println("Ingrese la direccion del cliente");
                            String direccion = sc.next();
                            int telefono = 0;
                            try {
                                while (String.valueOf(telefono).length() != 9) {
                                    System.out.println("Ingrese el telefono del cliente");
                                    telefono = sc.nextInt();
                                }
                            } catch (Exception e) {
                                System.out.println("Ingrese un numero valido");
                            }
                            System.out.println("Ingrese el email del cliente");
                            String email = sc.nextLine();
                            Cliente cliente = new Cliente(nombre, apellido, dni, direccion, telefono, email);
                            agenda.agregarCliente(cliente);
                        }
                        break;
                    case 2:
                        System.out.println("Mostrando clientes");
                        agenda.mostrarClientes();
                        break;
                    case 3:
                        System.out.println("Ingrese el dni del cliente que desea buscar");
                        String dni = sc.nextLine();
                        Cliente cliente = agenda.buscarCliente(dni);
                        agenda.buscarCliente(dni);
                        if (cliente != null) {
                            System.out.println(cliente.getNombre() + " " + cliente.getApellido());
                        } else {
                            System.out.println("No se encontro el cliente");
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el dni del cliente que desea eliminar");
                        String dni2 = sc.nextLine();
                        agenda.eliminarCliente(dni2);
                        break;
                    case 5:

                        System.out.println("Ingrese el dni y el nombre del cliente que desea modificar");
                        String dni3 = sc.nextLine();
                        System.out.println("Ingrese el nombre del cliente");
                        String nombre = sc.nextLine();
                        Cliente cliente2 = agenda.buscarCliente(dni3);
                        agenda.modificarCliente(cliente2);
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese una opcion valida");
            }
        }
    }
}
