package ar.edu.unju.fi.ejercicio8.Main;
import ar.edu.unju.fi.ejercicio8.Model.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);       
	        System.out.println("Ingrese el valor de n:");
	        int n = scanner.nextInt();       
	        CalculadoraEspecial calculadoraespecial = new CalculadoraEspecial();
	        calculadoraespecial.setN(n);    
	        System.out.println("La sumatoria es: " + calculadoraespecial.calcularSumatoria());      
	        System.out.println("La productoria es: " + calculadoraespecial.calcularProductoria());

	        scanner.close();
		}
	}

