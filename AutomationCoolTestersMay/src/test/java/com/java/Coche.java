package com.java;

public class Coche { //clase coche
//y tiene estas propiedades:
	public String llantas; 
	public String marca;
	
//esto es un contructor y lo mando inicializar desde otra clase Main (otro fichero "MainClass.java")
	//public Coche() {} --> java no lo usa. Si esta o no, para java le da igual
//	public Coche(String llantas, String marca) { 
//		this.llantas = llantas;
//		this.parabrisas = marca;
//	}
	
	//overloading:
	public static int operador(int x ,int y) {
		return x+y;
	}
	
	public static int operador(int x ,int y, int z) {
		return x+y+z;
	}
	
	public static int operador(int x ,int y, int z, int a) {
		return x+y+z+a;
	}
	
	public static int operador(boolean b) {
		return 1+1;
	}
	
	public static int operador(int c) {
		
		switch(c) {
		case 1:
			return 1+1;
		
		
		case 2:
			return 2+2;
		
		}
		return 3+3;
	}
	
	
}
