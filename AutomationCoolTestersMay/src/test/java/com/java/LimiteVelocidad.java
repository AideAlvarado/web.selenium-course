package com.java;

public class LimiteVelocidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int velocidad = 130; //km x hra
		int limiteVelocidad = 100;
		
//		if(velocidad > limiteVelocidad) {
//			System.out.println("Multa");
//		}else {
//			System.out.println("El coche va en la velocidad adecuada");
//		}

//	}

	//IF anidado / IF ELSE
	
	boolean highway = false;
	if(highway) {
		System.out.println("Estamos conduciendo en una highway");
		
		limiteVelocidad = 120;
		if(velocidad > limiteVelocidad) {
			System.out.println("Multa");
		}else {
			System.out.println("El coche va en la velocidad adecuada");
		}
	}else if(velocidad > limiteVelocidad) {
		System.out.println("El coche esta en una calle y va a exceso de velocidad, MULTA!!!!");
	}else {
		System.out.println("El coche está en un calle y va a una velocidad permitida");
	}
	
	//SWITCH CASE

		int temperatura = 20;
				switch(temperatura) {
				case 5:
					System.out.println("mucho frio");
					break;
					
				case 10:
					System.out.println("frio");
					break;
					
				case 20:
					System.out.println("templado");
					break;
					
				case 35:
					System.out.println("calor");
					break;
					
				default:
					System.out.println("no encontro relacion con la temperatura");
					break;
					
				
				}
  }
}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



