package com.java;

public class EjercicioisLeapYear {
	public static void main(String[] args) {
		// The following years are not leap * years:
		/*
		 * 1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600 This is because they are
		 * evenly divisible by 100 but not by 400.
		 * 
		 * The following years are leap years: 1600, 2000, 2400 This is because they are
		 * evenly divisible by both 100 and 400.
		 * 
		 * Examples of input/output:
		 * 
		 * isLeapYear(-1600); ? should return false since the parameter is not in range
		 * (1-9999)
		 * 
		 * isLeapYear(1600); ? should return true since 1600 is a leap year
		 * 
		 * isLeapYear(2017); ? should return false since 2017 is not a leap year
		 * 
		 * isLeapYear(2000); ? should return true because 2000 is a leap year
		 */
		int[] year = { -1600, 1600, 2017, 2000 };
		for (int i = 0; i < year.length; i++) {
			System.out.print(year[i] + " ");
			System.out.println(isLeapYear(year[i]));

		}
		System.out.println("----------------------------------------");
	}

	public static boolean isLeapYear(int year) {
		if (year >= 0 && year <= 99999) {
			// calcular si se cumplen las condiciones de bisiesto
			// 1. Si el año es divisible por 4 ir a paso 2, sino ir a paso 5000
			// 2. Si el año es divisible por 100, ir a paso 3 sino ir a paso 4
			// 3. si el año es divisible por 400 ir a paso 4 sino ir a paso 5
			// 4. Es año bisiesto result --> True
			// 5. Es año no bisiesto result -->Falseº
			boolean result;
			// paso 1
			if (year % 4 == 0) {
				// paso 2
				if (year % 100 == 0) {
					// paso 3
					if (year % 400 == 0) {
						result = true;
					} else {
						result = false;
					}
				} else {
					result = true;
				}
			} else {
				result = false;
			}

			return result;

		} else {
			return false;
		}
	}

}
