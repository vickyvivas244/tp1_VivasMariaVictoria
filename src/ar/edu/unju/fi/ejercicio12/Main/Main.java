package ar.edu.unju.fi.ejercicio12.Main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio12.Model.Persona;
public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        
	        System.out.print("Ingrese el nombre de la persona: ");
	        String nombre = scanner.nextLine();

	        System.out.print("Ingrese la fecha de nacimiento (formato dd/MM/yyyy): ");
	        String fechaNacimientoStr = scanner.nextLine();

	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);

	       
	        Persona persona = new Persona(nombre, fechaNacimiento);

	        
	        System.out.println("\nDatos de la Persona:");
	        System.out.println("Nombre: " + persona.getNombre());
	        System.out.println("Fecha de nacimiento: " + fechaNacimientoStr);
	        System.out.println("Edad: " + persona.calcularEdad() + " años");
	        System.out.println("Signo del zodiaco: " + persona.obtenerSignoZodiaco());
	        System.out.println("Estación del año: " + persona.obtenerEstacion());

	        scanner.close();
	    }
	}


