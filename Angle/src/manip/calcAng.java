package manip;

public class calcAng {
	
	public calcAng(){
		
	}
	
	public double getAngle(Line aLine, Line bLine){
		double m1 = aLine.getGradient();
		double m2 = bLine.getGradient();
		
		double angA = Math.atan(m1);
		double angB = Math.atan(m2);
		
		angA = angA*(180/Math.PI);
		angB = angB*(180/Math.PI);
		double angle = angA - angB;
		
		return angle;
		
	}
	

}
