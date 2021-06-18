package com.java;

public class EjericioEqualByThreeDecimalPlaces {

	public static void main(String[] args) {

		/*
		 * {-3.1756, -3.175); ? should return true since numbers are equal up to 3
		 * decimal places.
		 * 
		 * {3.175, 3.176); ? should return false since numbers are not equal up to 3
		 * decimal places
		 * 
		 * {3.0, 3.0); ? should return true since numbers are equal up to 3 decimal
		 * places.
		 * 
		 * {-3.123, 3.123); ? should return false since numbers are not equal up to 3
		 * decimal places.
		 * 
		 */
		double[][] valores = { { -3.1756, -3.175 }, { 3.175, 3.176 }, { 3.0, 3.0 }, { -3.123, 3.123 } };
		for (int i = 0; i < valores.length; i++) {
			System.out.println(chequear(valores[i][0], valores[i][1]));
		}
	}

	public static String chequear(double a, double b) {
		String valor = "";
		if (areEqualByThreeDecimalPlaces(a, b) == true) {
			valor = " son iguales.";
		} else {
			valor = " son diferentes";
		}
		return " El resultado de comparar " + a + " y " + b + valor;
	}

	public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
		int nuevoa = (int) ((a * 1000));
		int nuevob = (int) ((b * 1000));

		if (nuevoa == nuevob) {
			return true;
		} else {
			return false;
		}
		/*
		 * return (nuevoa == nuevob) ? true : false;
		 */
	}
}
