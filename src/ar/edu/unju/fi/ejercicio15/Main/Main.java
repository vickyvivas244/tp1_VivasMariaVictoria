package ar.edu.unju.fi.ejercicio15.Main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        
        int size;
        do {
            System.out.print("Ingrese un número entero en el rango [5, 10]: ");
            size = scanner.nextInt();
        } while (size < 5 || size > 10);

        
        String[] nombres = new String[size];

        
        System.out.println("Ingrese " + size + " nombres de personas:");

        for (int i = 0; i < nombres.length; i++) {
            scanner.nextLine(); 
            System.out.print("Nombre " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }

        
        System.out.println("\nContenido del array (ascendente):");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Posición " + i + ": " + nombres[i]);
        }

       
        System.out.println("\nContenido del array (descendente):");
        for (int i = nombres.length - 1; i >= 0; i--) {
            System.out.println("Posición " + i + ": " + nombres[i]);
        }

        scanner.close();
    }


	}


