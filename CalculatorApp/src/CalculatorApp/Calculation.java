package CalculatorApp;

public class Calculation {
	
	public double add( double x, double y) {
		return x+y;
	}
	
	public double subtract(double x, double y) {
		return x-y;
	}
	
	public double multiply(double x, double y) {
		return x+y;
	}
	
	public double divide(double x, double y) {
		if (y == 0) {
			throw new ArithmeticException("Cannot divide by zero!");
		} 
		return x/y;
	}
	
	public double squareRoot(double x) {
		if (x < 0) {
			throw new ArithmeticException("Cannot calculate square root of negative number!");
		}
		return Math.sqrt(x);
	}
	
	public double power(double x, double y) {
		return Math.pow(x,y);
	}
	
}
