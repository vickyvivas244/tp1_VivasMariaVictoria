package ar.edu.unju.fi.ejercicio14.Main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        
        int size;
        do {
            System.out.print("Ingrese un número entero en el rango [3, 10]: ");
            size = scanner.nextInt();
        } while (size < 3 || size > 10);

        
        int[] numeros = new int[size];

        
        System.out.println("Ingrese " + size + " números enteros:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        
        int suma = 0;

        System.out.println("\nContenido del array:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posición " + i + ": " + numeros[i]);
            suma += numeros[i];
        }

        
        System.out.println("La suma de todos los valores es: " + suma);
        scanner.close();
    }
}

	
