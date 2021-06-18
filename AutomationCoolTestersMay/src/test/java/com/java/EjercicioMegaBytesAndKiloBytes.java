package com.java;

public class EjercicioMegaBytesAndKiloBytes {

	public static void main(String[] args) {

		/*
		 * * printMegaBytesAndKiloBytes(2500); ? should print the following text:
		 * "2500 KB = 2 MB and 452 KB"
		 * 
		 * printMegaBytesAndKiloBytes(-1024); ? should print the following text:
		 * "Invalid Value" because parameter is less than 0.
		 * 
		 * printMegaBytesAndKiloBytes(5000); ? should print the following text:
		 * "5000 KB = 4 MB and 904 KB"
		 * 
		 * XX represents the original value kiloBytes. YY represents the calculated
		 * megabytes. ZZ represents the calculated remaining kilobytes.
		 */

		int[] XX = { 2500, -1024, 5000 };
		for (int i = 0; i < XX.length; i++) {
			printMegaBytesAndKiloBytes(XX[i]);
		}
	}

	public static void printMegaBytesAndKiloBytes(int XX) {
		// "the following text: " + XX + "KB" + "=" + YY + "MB" + "and";
		if (XX < 0) {
			System.out.println("Invalid value");
		} else {
			int megas = (XX * 1) / (1024);
			int kilos = XX % 1024;
			System.out.println(XX + " KB " + " = " + megas + " MB " + kilos + " KB");
		}
	}

}