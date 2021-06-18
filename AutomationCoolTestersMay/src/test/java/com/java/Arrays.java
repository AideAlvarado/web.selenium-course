package com.java;

public class Arrays {

	public static void main(String[] args) {
		// arreglo unidimensional

		String[] nombres = { "Ricardo", "Jessica", "Aide", "Felipe" }; // asi se declara un arreglo (array)
																		// unidimensaional

		// System.out.println("el nombre de la persona es: " + nombres[1]);

		for (int i = 0; i < nombres.length; i++) {
			System.out.println("el nombre de la persona es: " + nombres[i]);
		}

		// Arreglo Bidimensional (2 dimensiones)

		String[][] nombreEdad = new String[4][4]; // se declaran los valores 4 - 4
		nombreEdad[0][0] = "Ricardo";
		nombreEdad[0][1] = "30";
		nombreEdad[1][0] = "Jessica";
		nombreEdad[1][1] = "31";
		nombreEdad[2][0] = "Aide";
		nombreEdad[2][1] = "32";
		nombreEdad[3][0] = "Felipe";
		nombreEdad[3][1] = "33";

		// System.out.println("el nombre de la persona es: "+nombreEdad[0][0]+ " y su
		// edad es: "+nombreEdad[0][1]);

		printNombreEdad(nombreEdad[0][0], nombreEdad[0][1]);
		// int z = suma(2,2);
		// System.out.println(z);
		// suma(2,2,2);

		// boolean valorMetodo = ifsuma(3, 2);
		// System.out.println(valorMetodo);
		// System.out.println(holaMundo());

	}
	// METODOS

	public static void printNombreEdad(String nombre, String edad) {
		System.out.println("METODO: el nombre de la persona es: " + nombre + " " + "y su edad es: " + edad);
		suma(2, 3, 4);
	}

	public static int suma(int x, int y) {
		return x + y;
	}

	public static void suma(int x, int y, int z) {
		System.out.println("la suma de las variables es = " + (x + y + z));
	}

	public static boolean ifsuma(int x, int y) {
		if (x >= y) {
			return true;
		} else {
			return false;
		}
	}

	public static String holaMundo() {
		return "hola Mundo";
	}
}
