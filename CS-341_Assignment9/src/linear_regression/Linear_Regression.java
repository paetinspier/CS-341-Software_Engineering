package linear_regression;

import java.util.ArrayList;

public class Linear_Regression {
	
	/* 			**Notes**
	 * 
	 * 	x_value represent the number of consecutive hours spent coding an application
	 * 
	 * 	y_value represent the number of bugs produced during development
	 * 
	 * 	find sum of x, y, xy, x^2, y^2
	 * 
	 * 	a = ((sum y)(sum x^2) - (sum x)(sum y^2)) / (n(sum x^2) -(sum x)^2)
	 * 
	 * 	b = (n(sum xy) - (sum x)(sum y)) / (n(sum x^2) - (sum x)^2)
	 * 
	 * 	linear regression equation = a + bx
	 * 
	 * */
	
	
	
	
	// data members
	private ArrayList<Double> x_value = new ArrayList<>();
	private ArrayList<Double> y_value = new ArrayList<>();
	
	// constructor
	public Linear_Regression(ArrayList<Double> x_value, ArrayList<Double> y_value) {
		this.x_value = x_value;
		this.y_value = y_value;
	}
	
	// arrays must be the same size
	public Boolean verify_arrays() {
		if(x_value.size() != y_value.size()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// TASK 1: find sum of x and y
	
	private Double sum_x() {
		double sum = 0.0;
		for (int i = 0; i < x_value.size(); i++) {
			sum += x_value.get(i);
		}
		return sum;
	}
	
	private Double sum_y() {
		double sum = 0.0;
		for (int i =0; i < x_value.size(); i++) {
			sum += y_value.get(i);
		}
		return sum;
	}
	
	// TASK 2: GET THE MEAN OF X AND Y
	
	private Double mean_x() {
		return sum_x()/x_value.size();
	}
	
	private Double mean_y() {
		return sum_y()/x_value.size();
	}
	
	// TASK 3: GET Sum of squares (SSX) AND Sum of products (SP)
	
	private Double getSS() {
		double sum = 0.0;
		
		for (int i = 0; i < x_value.size(); i++) {
			sum += Math.pow(x_value.get(i) - mean_x(), 2);
		}
		return sum;
	}
	
	private Double getSP() {
		double sum = 0.0; 
		
		for (int i = 0; i < x_value.size(); i++) {
			sum += (x_value.get(i) - mean_x()) * (y_value.get(i) - mean_y());
		}
		return sum;
	}
	
	
	
	// TASK 2: GET THE A AND B VALUES
	
	// a = mean_y -( b * mean_x)
	
	// b = SP / SS
	
	private double b_value() {
		return getSP()/getSS();
	}
	
	private double a_value() {
		return mean_y() - (b_value() * mean_x());
	}
	

	
	
	// TASK 3: LINEAR REGRESSION METHOD
	
	// linear regression equation = a + bx
	
	public double linear_regression(int x) {
		System.out.println("a: " + a_value());
		System.out.println("b: " + b_value());
		System.out.println("sp: " + getSP());
		System.out.println("ss: " + getSS());
		System.out.println("mean x " + mean_x());
		System.out.println("mean y " + mean_y());
		System.out.println("sum x " + sum_x());
		System.out.println("sum y " + sum_y());
		return a_value() + (b_value() * x);

	}
	
	
	
	
	
	
}
