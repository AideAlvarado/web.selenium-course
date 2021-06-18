package com.java;

public class EjercicioIsCatPlaying {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pruebaGato(true, 10);
		pruebaGato(false, 36);
		pruebaGato(false, 35);
	}

	public static void pruebaGato(boolean verano, int temperatura) {
		boolean valorMetodo = isCatPlaying(verano, temperatura);
		System.out
				.println("El valor para verano=" + verano + " y temperatura de " + temperatura + " es :" + valorMetodo);
	}

	public static boolean isCatPlaying(boolean verano, int temperatura) {
		int LIMITE_SUPERIOR = verano ? 45 : 35;
		if (temperatura >= 25 && temperatura <= LIMITE_SUPERIOR) {
			return true;
		} else {
			return false;
		}
	}

}
