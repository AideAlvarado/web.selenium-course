package com.ejercicioclase;

public class Multiplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		double z = multiplicacionNumeros(3.3, 8.8);
		imprimirMultiplicacion(z);

	}
	
	public static double multiplicacionNumeros(double x, double y) { //double es para decimales
		return (x*y);
	}
	
	public static void imprimirMultiplicacion(double z) {
		System.out.println((z));
	}

}