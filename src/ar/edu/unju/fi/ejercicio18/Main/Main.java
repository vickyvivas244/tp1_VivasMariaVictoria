package ar.edu.unju.fi.ejercicio18.Main;

import ar.edu.unju.fi.ejercicio18.Model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.Model.Pais;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pais> paises = new ArrayList<>();
        paises.add(new Pais("001", "Argentina"));
        paises.add(new Pais("002", "Brasil"));
        paises.add(new Pais("003", "Chile"));

        List<DestinoTuristico> destinosTuristicos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 - Alta de destino turístico");
            System.out.println("2 - Mostrar todos los destinos turísticos");
            System.out.println("3 - Modificar el país de un destino turístico");
            System.out.println("4 - Limpiar el ArrayList de destinos turísticos");
            System.out.println("5 - Eliminar un destino turístico");
            System.out.println("6 - Mostrar los destinos turísticos ordenados por nombre");
            System.out.println("7 - Mostrar todos los países");
            System.out.println("8 - Mostrar los destinos turísticos que pertenecen a un país");
            System.out.println("9 - Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaDestinoTuristico(destinosTuristicos, paises, scanner);
                    break;
                case 2:
                    mostrarDestinosTuristicos(destinosTuristicos);
                    break;
                case 3:
                    modificarPaisDestinoTuristico(destinosTuristicos, paises, scanner);
                    break;
                case 4:
                    destinosTuristicos.clear();
                    System.out.println("ArrayList de destinos turísticos limpiado con éxito.");
                    break;
                case 5:
                    eliminarDestinoTuristico(destinosTuristicos, scanner);
                    break;
                case 6:
                    mostrarDestinosTuristicosOrdenados(destinosTuristicos);
                    break;
                case 7:
                    mostrarPaises(paises);
                    break;
                case 8:
                    mostrarDestinosPorPais(destinosTuristicos, scanner);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    private static void altaDestinoTuristico(List<DestinoTuristico> destinosTuristicos, List<Pais> paises, Scanner scanner) {
        System.out.println("Ingrese los datos del destino turístico:");
        System.out.print("Código: ");
        String codigo = scanner.next();
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        Pais pais = seleccionarPais(paises, scanner);
        if (pais != null) {
            System.out.print("Cantidad de días: ");
            int cantidadDias = scanner.nextInt();
            destinosTuristicos.add(new DestinoTuristico(codigo, nombre, precio, pais, cantidadDias));
            System.out.println("Destino turístico agregado con éxito.");
        } else {
            System.out.println("No se pudo agregar el destino turístico.");
        }
    }

    private static Pais seleccionarPais(List<Pais> paises, Scanner scanner) {
        mostrarPaises(paises);
        System.out.print("Seleccione el código del país: ");
        String codigoPais = scanner.next();
        for (Pais pais : paises) {
            if (pais.getCodigo().equalsIgnoreCase(codigoPais)) {
                return pais;
            }
        }
        System.out.println("No se encontró ningún país con el código especificado.");
        return null;
    }

    private static void mostrarPaises(List<Pais> paises) {
        System.out.println("Lista de países:");
        for (Pais pais : paises) {
            System.out.println(pais.getCodigo() + " - " + pais.getNombre());
        }
    }

    private static void mostrarDestinosTuristicos(List<DestinoTuristico> destinosTuristicos) {
        System.out.println("Lista de destinos turísticos:");
        for (DestinoTuristico destino : destinosTuristicos) {
            System.out.println(destino);
        }
    }

    private static void modificarPaisDestinoTuristico(List<DestinoTuristico> destinosTuristicos, List<Pais> paises, Scanner scanner) {
        System.out.print("Ingrese el código del destino turístico: ");
        String codigoDestino = scanner.next();
        DestinoTuristico destinoTuristicoEncontrado = null;
        for (DestinoTuristico destino : destinosTuristicos) {
            if (destino.getCodigo().equalsIgnoreCase(codigoDestino)) {
                destinoTuristicoEncontrado = destino;
                break;
            }
        }
        if (destinoTuristicoEncontrado != null) {
            Pais nuevoPais = seleccionarPais(paises, scanner);
            if (nuevoPais != null) {
                destinoTuristicoEncontrado.setPais(nuevoPais);
                System.out.println("País del destino turístico modificado con éxito.");
            } else {
                System.out.println("No se pudo modificar el país del destino turístico.");
            }
        } else {
            System.out.println("No se encontró ningún destino turístico con ese código.");
        }
    }

    private static void eliminarDestinoTuristico(List<DestinoTuristico> destinosTuristicos, Scanner scanner) {
        System.out.print("Ingrese el código del destino turístico a eliminar: ");
        String codigoDestino = scanner.next();
        Iterator<DestinoTuristico> iter = destinosTuristicos.iterator();
        while (iter.hasNext()) {
            DestinoTuristico destino = iter.next();
            if (destino.getCodigo().equalsIgnoreCase(codigoDestino)) {
                iter.remove();
                System.out.println("Destino turístico eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró ningún destino turístico con ese código.");
    }

    private static void mostrarDestinosTuristicosOrdenados(List<DestinoTuristico> destinosTuristicos) {
        List<DestinoTuristico> destinosOrdenados = new ArrayList<>(destinosTuristicos);
        Collections.sort(destinosOrdenados, (d1, d2) -> d1.getNombre().compareToIgnoreCase(d2.getNombre()));
        System.out.println("Lista de destinos turísticos ordenados por nombre:");
        for (DestinoTuristico destino : destinosOrdenados) {
            System.out.println(destino);
        }
    }

    private static void mostrarDestinosPorPais(List<DestinoTuristico> destinosTuristicos, Scanner scanner) {
        System.out.print("Ingrese el código del país: ");
        String codigoPais = scanner.next();
        System.out.println("Destinos turísticos pertenecientes al país con código '" + codigoPais + "':");
        for (DestinoTuristico destino : destinosTuristicos) {
            if (destino.getPais().getCodigo().equalsIgnoreCase(codigoPais)) {
                System.out.println(destino);
            }
        }
    }
}