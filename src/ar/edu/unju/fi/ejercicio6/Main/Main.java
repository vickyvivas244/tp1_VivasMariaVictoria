package ar.edu.unju.fi.ejercicio6.Main;
import java.time.LocalDate;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio6.Model.Persona;
public class Main {

	public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
	        Persona persona1 = new Persona();
	        System.out.println("Ingrese DNI:");
	        int dni1 = scanner.nextInt();
	        scanner.nextLine();
	        System.out.println("Ingrese nombre:");
	        String nombre1 = scanner.nextLine();
	        System.out.println("Ingrese fecha de nacimiento (en formato aaaa-mm-dd):");
	        LocalDate fechaNacimiento1 = LocalDate.parse(scanner.nextLine());
	        System.out.println("Ingrese provincia:");
	        String provincia1 = scanner.nextLine();
	        persona1.setDni(dni1);
	        persona1.setNombre(nombre1);
	        persona1.setFechaNacimiento(fechaNacimiento1);
	        persona1.setProvincia(provincia1);
	        persona1.mostrarDatos();
	        System.out.println();

	        System.out.println("Ingrese DNI:");
	        int dni2 = scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.println("Ingrese nombre:");
	        String nombre2 = scanner.nextLine();
	        System.out.println("Ingrese fecha de nacimiento (en formato aaaa-mm-dd):");
	        LocalDate fechaNacimiento2 = LocalDate.parse(scanner.nextLine());
	        System.out.println("Ingrese provincia:");
	        String provincia2 = scanner.nextLine();
	        Persona persona2 = new Persona(dni2, nombre2, fechaNacimiento2, provincia2);
	        persona2.mostrarDatos();
	        System.out.println();

	        System.out.println("Ingrese DNI:");
	        int dni3 = scanner.nextInt();
	        scanner.nextLine();
	        System.out.println("Ingrese nombre:");
	        String nombre3 = scanner.nextLine();
	        System.out.println("Ingrese fecha de nacimiento (en formato aaaa-mm-dd):");
	        LocalDate fechaNacimiento3 = LocalDate.parse(scanner.nextLine());
	        System.out.println("Ingrese provincia:");
	        String provincia3 = scanner.nextLine();
	        Persona persona3 = new Persona(dni3, nombre3, fechaNacimiento3, provincia3);
	        persona3.mostrarDatos();

	        scanner.close();
	    }
}



