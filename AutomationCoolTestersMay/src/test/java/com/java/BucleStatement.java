package com.java;

public class BucleStatement {

	public static void main(String[] args) {
		// WHILE
		
		int numero = 1;
		while(numero <= 10) {
			//BLOCK CODE
			System.out.println("el numero es: "+numero);
			++numero; //incrementa uno
		}
		
		//DO WHILE
		//cuantas veces e tiene que sumar un numero para llegar a 100?
		
		int numeroLimite = 20;
		int sumTotal = 0;
		int count = 0;
		
		do {
		//sumTotal = sumTotal + numeroLimite;
			sumTotal += numeroLimite;
		count++;
		//count = count + 1;
		} while(sumTotal < 100);
	
	    System.out.println("el numero se sumo = "+count);
	    
	    
	    //FOR
	    
	    int numeroFor = 10;
	    
	    for(int i = 1; i <= numeroFor; i++) {
	    	System.out.println("el numero for es " + i);
	    	
	    }
	    
	}

}
