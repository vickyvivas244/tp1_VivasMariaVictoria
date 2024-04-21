package ar.edu.unju.fi.ejercicio16.Main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        
        String[] nombres = new String[5];

        
        System.out.println("Ingrese 5 nombres de personas:");

        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }

        
        System.out.println("\nValores guardados en el array:");
        int index = 0;
        while (index < nombres.length) {
            System.out.println("Índice " + index + ": " + nombres[index]);
            index++;
        }

        
        System.out.println("\nTamaño del array: " + nombres.length);

        
        byte indiceAEliminar;
        do {
            System.out.print("\nIngrese el índice (0-4) del elemento a eliminar: ");
            indiceAEliminar = scanner.nextByte();
        } while (indiceAEliminar < 0 || indiceAEliminar >= nombres.length);

        
        for (int i = (int) indiceAEliminar; i < nombres.length - 1; i++) {
            nombres[i] = nombres[i + 1];
        }
        nombres[nombres.length - 1] = "";

        
        System.out.println("\nArreglo después de eliminar el elemento en el índice " + indiceAEliminar + ":");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Índice " + i + ": " + nombres[i]);
        }

        scanner.close();
    }


	}


