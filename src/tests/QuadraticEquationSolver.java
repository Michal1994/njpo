package tests;

public class QuadraticEquationSolver {
	
	//equation have form like this ax^2 + bx + c = 0
	
	public static boolean isQuadraticEquation(double a){
		
		return a != 0 ? true : false;
		
	}
	
	public static double calculateDelta( double a, double b, double c ){
		
		if(a == 0) return -1;
		
		return b*b - 4*a*c;
		
	}
	
	public static double[] calculateRootsOfEquation( double a, double b, double c ){
		
		double[] ret;
		
		if(a == 0){
			ret = new double[1];
			ret[0] = -c/b;
			return ret;
		}
		
		double delta = calculateDelta(a, b, c);
		
		if(delta < 0){
			ret = new double[0];
		}
		else if(delta == 0){
			ret = new double[1];
			ret[0] = -b/(2*a);
		}
		else{
			ret = new double[2];
			ret[0] = (-b - Math.sqrt(delta))/(2*a);
			ret[1] = (-b + Math.sqrt(delta))/(2*a);
		}
		
		return ret;
		
	}
	
}
