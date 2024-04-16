package ar.edu.unju.fi.ejercicio10.Model;

public class Pizza {
	private int diameter;
	private double price;
	private double area;
	private boolean special_ingredients;
	private final int SPECIAL_IN_20 = 500; //corregido
	private final int SPECIAL_IN_30 = 750;
	private final int SPECIAL_IN_40 = 1000;
	
	public Pizza() {
		
	}
	
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public boolean isSpecial_ingredients() {
		return special_ingredients;
	}
	public void setSpecial_ingredients(boolean special_ingredients) {
		this.special_ingredients = special_ingredients;
	}
	
	public void calcularPrecio() {//nueva corrección de clase, aplicado. 
	    double precioBase = 0;
	    double precioEspecial = 0;

	    switch (diameter) {
	        case 20:
	            precioBase = 4500;
	            if (special_ingredients) {
	                precioEspecial = SPECIAL_IN_20;
	            }
	            break;
	        case 30:
	            precioBase = 4800;
	            if (special_ingredients) {
	                precioEspecial = SPECIAL_IN_30;
	            }
	            break;
	        case 40:
	            precioBase = 5500;
	            if (special_ingredients) {
	                precioEspecial = SPECIAL_IN_40;
	            }
	            break;
	        default:
	            // Si la opción no es válida, se puede lanzar una excepción o manejar de alguna otra manera.
	            
	            break;
	    }
	    
	    price = precioBase + precioEspecial;
	}
	
	public void calcularArea() {
		
		area = Math.PI * Math.pow(diameter / 2, 2);
		
	}

	@Override
	public String toString() {
		return "--- Pizza ---\n * diameter=" + diameter + "\n * price=" + price + "\n * area=" + area + "\n * special_ingredients="
				+ special_ingredients;
	}

	
}
