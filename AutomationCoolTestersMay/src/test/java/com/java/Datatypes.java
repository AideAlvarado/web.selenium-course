package com.java;

public class Datatypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//para valores enteros:
		byte variableByte = 127; //es la misma declaracion que int variableInt
		int variableInt = 127;
		
		System.out.println("El valor es:" + variableInt); //se usa para imprimir
		
		//Para valores con decimales:
		double altura = 2.54; // se usa para decimales
		double peso = 75.5;
		
		System.out.println("Mi peso es: " + peso);
		
		//Para cadena de caracteres:
		String frase = "Hola";
		String frase2 = " a todos";
		
		System.out.println(frase + frase2);
		
		//char para unicode:
		char char1 = '\u0048';
				System.out.println(char1);
				
		//boolean
		boolean isDog = true;
		System.out.println(isDog);
	}

}
