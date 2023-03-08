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

                            String dni;
                            boolean dniValido = false;
                            do {
                                System.out.println("Ingrese su DNI (8 números seguidos de una letra):");
                                dni = sc.nextLine();
                                // Verifica que la entrada del usuario tenga el formato correcto
                                if (dni.matches("[0-9]{8}[A-Za-z]")) {
                                    dniValido = true;
                                } else {
                                    System.out.println("El formato del DNI es inválido. Inténtelo de nuevo.");
                                }
                            } while (!dniValido);
                            // Verifica si la letra del DNI es correcta utilizando el algoritmo de validación
                            // que se utiliza en España (letra = "TRWAGMYFPDXBNJZSQVHLCKE")
                            int dniNumerico = Integer.parseInt(dni.substring(0, 8));
                            char letraCalculada = calcularLetraDNI(dniNumerico);
                            char letraDNI = dni.charAt(8);
                            if (letraCalculada == letraDNI) {
                                System.out.println("El DNI ingresado es válido.");
                            } else {
                                System.out.println("La letra del DNI no es correcta. El DNI es inválido.");
                            }

                            System.out.println("Ingrese la direccion del cliente");
                            String direccion = sc.next();

                            // Se utiliza un bucle do-while para solicitar al usuario que ingrese su número de teléfono
                            // hasta que lo haga en el formato correcto. Luego, se muestra un mensaje diciendo que el número
                            // de teléfono es válido.

                            String telefono;
                            boolean telefonoValido = false;

                            // Pide al usuario que ingrese su número de teléfono y lo almacena en una variable String
                            do {
                                System.out.println("Ingrese su número de teléfono (9 dígitos):");
                                telefono = sc.nextLine();
                                // Verifica que la entrada del usuario tenga el formato correcto
                                if (telefono.matches("[0-9]{9}")) {
                                    telefonoValido = true;
                                } else {
                                    System.out.println("El formato del número de teléfono es inválido. Inténtelo de nuevo.");
                                }
                            } while (!telefonoValido);

                            // Si el número de teléfono es válido, se muestra un mensaje de confirmación
                            System.out.println("El número de teléfono ingresado es válido.");

                            System.out.println("Ingrese el email del cliente");
                            String email = sc.nextLine();

                            //una vez que se ingresan los datos se crea el objeto cliente
                            Cliente cliente = new Cliente(nombre, apellido, dni, direccion, telefono, email);
                            //añadir objeto cliente a la agenda
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
    public static char calcularLetraDNI(int dniNumerico) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indiceLetra = dniNumerico % 23;
        return letras.charAt(indiceLetra);
    }
}




