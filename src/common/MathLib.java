package common;

public class MathLib {
	
	public static final double TOLERANCE = 0.0000001;
	
	public boolean compareDouble(double a, double b){
		if((a < 0 && b < 0) || (a > 0 && b > 0)){
			a = Math.abs(a);
			b = Math.abs(b);
			if(Math.abs(a-b) < TOLERANCE){
				return true;
			}
		}else{
			if((Math.abs(0 - a) < TOLERANCE) && (Math.abs(0 - b) < TOLERANCE)){
				return true;
			}
		}
		return false;
		
	}
}
