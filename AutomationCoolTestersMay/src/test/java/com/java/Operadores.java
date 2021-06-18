package com.java;

public class Operadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Operadores Aritmeticos:
		int x = 6;
		int y = 4;
		
		int z = x / y;
		System.out.println("El valor de la variable z = " + z);
		
		//Operadores unarios (incrementar,disminuir)
		
		int A = 1;
		int B = 2;
		
		++A;
		--B;
		
		A = 4;
		
		System.out.println("El valor de la variable A = " +A);
		System.out.println("El valor de la variable B = " +B);
		
		//Operadores Relacionales:
		
		if(B < A) { //todo lo que esté dentro se le llama Block code
			System.out.println("Block code"); //aqui no imprime nada
		}
		
		//Operadores Condicionales:
		int var1 = 5;
		int var2 = 3;
		int var3 = 7;
		int var4 = 5;
		
		if(var1 == var2 || var3 == var4) {
			System.out.println("Condicional Block code"); 
		}
	}

}
