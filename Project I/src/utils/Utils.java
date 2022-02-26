package utils;

import java.math.BigDecimal;

public class Utils {
	
	public static int factorial(int number) {
		if (number == 0 || number == 1) return 1;
		return factorial(number-1)*number;
	}
	
	public static boolean isOperation(String s) {
		if (Configs.OPERATIONS.containsKey(s)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumeric(String s) {
		try {
			new BigDecimal(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean isInteger(double d) {
		int i = (int) d;
		if (d - i != 0) {
			return false;
		}
		return true;
	}
	
	public static double calculateArcsinh(double d) {
		return (Math.log(d + Math.sqrt(Math.pow(d, 2) + 1)));
	}
	
	public static double calculateArccosh(double d) {
		return (Math.log(d + Math.sqrt(Math.pow(d, 2) - 1)));
	}
	
	public static double calculateArctanh(double d) {
		return (Math.log((1+d)/(1-d))/2);
	}
	
	public static void swap(double d1, double d2) {
		double temp = d1;
		d1 = d2;
		d2 = 1/temp;
	}
}
