package aplicacion;

import dominio.Agenda;
import dominio.Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Principal {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        while (true) {
            try {
                System.out.println("Ingrese la opcion que desea realizar");
                System.out.println("1. Agregar cliente");
                System.out.println("2. Mostrar clientes");
                System.out.println("3. Buscar cliente");
                System.out.println("4. Eliminar cliente");
                System.out.println("5. Modificar cliente");
                System.out.println("6. Salir");
                int opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la cantidad de clientes que desea agregar");
                        int cantidadClientes = Integer.parseInt(br.readLine());
                        int n = 0;

                        for (int i = 0; i < cantidadClientes; i++) {
                            n++;
                            String nombre;
                            String apellido;
                            // verificar que el nombre y apellido sean solo letras, si el usuario ingresa un numero, se le vuelve a pedir que ingrese el nombre y apellido
                            do {
                                System.out.println("Ingrese el nombre del cliente" + i + ":");
                                nombre = br.readLine();
                                System.out.println("Ingrese el apellido del cliente" + i + ":");
                                apellido = br.readLine();
                                if (nombre.matches("^[a-zA-Z ]+$") && apellido.matches("^[a-zA-Z ]+$")) {
                                    System.out.println("Nombre y apellido válidos.");
                                } else {
                                    System.out.println("Nombre y apellido inválidos.");
                                }
                            } while (!nombre.matches("^[a-zA-Z ]+$") && !apellido.matches("^[a-zA-Z ]+$"));

                            String dni;
                            boolean dniValido = false;
                            do {
                                System.out.println("Ingrese su DNI (8 números seguidos de una letra):");
                                dni = br.readLine();
                                // Verifica que la entrada del usuario tenga el formato correcto
                                if (dni.matches("[0-9]{8}[A-Za-z]")) {
                                    dniValido = true;
                                    System.out.println("El DNI ingresado es válido.");
                                } else {
                                    System.out.println("El formato del DNI es inválido. Inténtelo de nuevo.");
                                }
                            } while (!dniValido);

                            System.out.println("Ingrese la direccion del cliente");
                            String direccion = br.readLine();

                            String telefono;
                            boolean telefonoValido = false;

                            // Pide al usuario que ingrese su número de teléfono y lo almacena en una variable String
                            do {
                                System.out.println("Ingrese su número de teléfono (9 dígitos):");
                                telefono = br.readLine();
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
                            String email = br.readLine();

                            //una vez que se ingresan los datos se crea el objeto cliente
                            Cliente cliente = new Cliente(n, nombre, apellido, dni, direccion, telefono, email);
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
                        String dni = br.readLine();
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
                        String dni2 = br.readLine();
                        agenda.eliminarCliente(dni2);
                        break;
                    case 5:

                        System.out.println("Ingrese el dni y el nombre del cliente que desea modificar");
                        String dni3 =  br.readLine();
                        System.out.println("Ingrese el nombre del cliente");
                        String nombre = br.readLine();
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




