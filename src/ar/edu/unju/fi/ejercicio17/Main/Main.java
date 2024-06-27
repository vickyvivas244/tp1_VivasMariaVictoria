package ar.edu.unju.fi.ejercicio17.Main;

import ar.edu.unju.fi.ejercicio17.Model.Jugador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar los datos del jugador");
            System.out.println("3 - Mostrar todos los jugadores ordenados por apellido");
            System.out.println("4 - Modificar los datos de un jugador");
            System.out.println("5 - Eliminar un jugador");
            System.out.println("6 - Mostrar la cantidad total de jugadores");
            System.out.println("7 - Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
            System.out.println("8 - Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaJugador(jugadores, scanner);
                    break;
                case 2:
                    mostrarDatosJugador(jugadores, scanner);
                    break;
                case 3:
                    mostrarJugadoresOrdenadosPorApellido(jugadores);
                    break;
                case 4:
                    modificarDatosJugador(jugadores, scanner);
                    break;
                case 5:
                    eliminarJugador(jugadores, scanner);
                    break;
                case 6:
                    mostrarCantidadTotalJugadores(jugadores);
                    break;
                case 7:
                    mostrarCantidadJugadoresPorNacionalidad(jugadores, scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static void altaJugador(List<Jugador> jugadores, Scanner scanner) {
        System.out.println("Ingrese los datos del jugador:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("Fecha de nacimiento (formato dd/mm/aaaa): ");
        String fechaNacimientoStr = scanner.next();
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimientoStr);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha. Formato incorrecto.");
            return;
        }
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.next();
        System.out.print("Estatura: ");
        double estatura = scanner.nextDouble();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Posición (delantero, medio, defensa, arquero): ");
        String posicion = scanner.next();
        jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion));
        System.out.println("Jugador agregado con éxito.");
    }

    private static void mostrarDatosJugador(List<Jugador> jugadores, Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println(jugador);
                return;
            }
        }
        System.out.println("No se encontró al jugador con ese nombre y apellido.");
    }

    private static void mostrarJugadoresOrdenadosPorApellido(List<Jugador> jugadores) {
        List<Jugador> jugadoresOrdenados = new ArrayList<>(jugadores);
        jugadoresOrdenados.sort(Comparator.comparing(Jugador::getApellido));
        for (Jugador jugador : jugadoresOrdenados) {
            System.out.println(jugador);
        }
    }

    private static void modificarDatosJugador(List<Jugador> jugadores, Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Ingrese los nuevos datos del jugador:");
                System.out.print("Nombre: ");
                jugador.setNombre(scanner.next());
                System.out.print("Apellido: ");
                jugador.setApellido(scanner.next());
                System.out.print("Fecha de nacimiento (formato dd/mm/aaaa): ");
                String fechaNacimientoStr = scanner.next();
                Date fechaNacimiento = null;
                try {
                    fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimientoStr);
                } catch (ParseException e) {
                    System.out.println("Error al parsear la fecha. Formato incorrecto.");
                    return;
                }
                jugador.setFechaNacimiento(fechaNacimiento);

                System.out.print("Nacionalidad: ");
                jugador.setNacionalidad(scanner.next());

                System.out.print("Estatura: ");
                jugador.setEstatura(scanner.nextDouble());

                System.out.print("Peso: ");
                jugador.setPeso(scanner.nextDouble());

                System.out.print("Posición (delantero, medio, defensa, arquero): ");
                jugador.setPosicion(scanner.next());

                System.out.println("Datos del jugador modificados con éxito.");
                return;
            }
        }
        System.out.println("No se encontró al jugador con ese nombre y apellido.");
    }

    private static void eliminarJugador(List<Jugador> jugadores, Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();
        Iterator<Jugador> iter = jugadores.iterator();
        while (iter.hasNext()) {
            Jugador jugador = iter.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                iter.remove();
                System.out.println("Jugador eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró al jugador con ese nombre y apellido.");
    }

    private static void mostrarCantidadTotalJugadores(List<Jugador> jugadores) {
        System.out.println("Cantidad total de jugadores: " + jugadores.size());
    }

    private static void mostrarCantidadJugadoresPorNacionalidad(List<Jugador> jugadores, Scanner scanner) {
        System.out.print("Ingrese la nacionalidad: ");
        String nacionalidad = scanner.next();
        int contador = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
                contador++;
            }
        }
        System.out.println("Cantidad de jugadores de la nacionalidad '" + nacionalidad + "': " + contador);
    }
}