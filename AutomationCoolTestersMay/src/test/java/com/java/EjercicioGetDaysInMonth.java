//package com.java;
//
//import EjercicioisLeapYear;
//
//public class EjercicioGetDaysInMonth {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[][] data = { { 1, 2020 }, { 2, 2020 }, { 2, 2018 }, { -1, 2020 }, { 1, -2020 } };
//		int numeroDeDias;
//		for (int i = 0; i < data.length; i++) {
//			numeroDeDias = getDaysInMonth(data[i][0], data[i][1]);
//			if (numeroDeDias > 0) {
//				System.out.println(" El mes " + data[i][0] + " de " + data[i][1] + " tiene " + numeroDeDias + " dias.");
//			} else {
//				System.out.println("Month or Year is invalid");
//			}
//		}
//	}
//
//	public static int getDaysInMonth(int month, int year) {
//
//		if (month < 1 || month > 12) {
//			return -1;
//		} else if (year < 1 || year > 9999) {
//			return -1;
//		} else {
//
//			switch (month) {
//				case 1:
//				case 3:
//				case 7:
//				case 9:
//				case 10:
//				case 12:
//					return 31;// "has 31 days";
//				case 4:
//				case 6:
//				case 8:
//				case 11:
//					return 30;
//				case 2:
//					return EjercicioisLeapYear.isLeapYear(year) == true ? 29 : 28;
//				default:
//					return -1;
//			}
//		}
//	}
//}
