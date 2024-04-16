package ar.edu.unju.fi.ejercicio10.Main;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio10.Model.Pizza;
public class Menu {
	private int opcion = 0;
	private char answer = 'n';

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public char getAnswer() {
		return answer;
	}

	public void setAnswer(char answer) {
		this.answer = answer;
	}

	public void generarMenu(Pizza pizza) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---------------------------");
			System.out.println("** Detalles del pedido **");

			do {
				System.out.println("Ingrese 1 - Pizza pequeña de diametro: 20um");
				System.out.println("Ingrese 2 - Pizza Mediana de diametro: 30um");
				System.out.println("Ingrese 3 - Pizza Grande de diametro: 40um");
				System.out.print("Ingrese una opcion: ");
				opcion = sc.nextInt();

				if (opcion < 1 || opcion > 3) {
					System.out.println("\n¡Error de opcion elegida, intente nuevamente!");
				}

			} while (opcion < 1 || opcion > 3);

			do {
				System.out.println("\n ¿lleva ingredientes especiales? s/n");
				answer = sc.next().charAt(0);
				if (answer != 's' && answer != 'n') {
					System.out.println("\n¡Error de opcion elegida, intente nuevamente!");
				}
			} while (answer != 's' && answer != 'n');

			setearDatosPizza(pizza);
			System.out.println(pizza.toString());

			System.out.println("\n ¿Desea Encargar otra Pizza? s/n");
			answer = sc.next().charAt(0);

		} while (answer != 'n');

		System.out.println("\n PROGRAMA TERMINADO");
		
		sc.close();
	}

	public void setearDatosPizza(Pizza pizza) {
		switch (opcion) { // funcion setDiameter(Pizza pizza, int option){}
		case 1:
			pizza.setDiameter(20);
			break;
		case 2:
			pizza.setDiameter(30);
			break;
		case 3:
			pizza.setDiameter(40);
			break;
		}

		if (answer == 's') {
			pizza.setSpecial_ingredients(true);

		} else {
			pizza.setSpecial_ingredients(false);

		}
		pizza.calcularPrecio();
		pizza.calcularArea();
	}

}
