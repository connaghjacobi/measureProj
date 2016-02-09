package testClasses;

import manip.*;

public class Test {
	public static void main(String[] args){
		evalData eval = new evalData();
		calcAng getAng= new calcAng();
		double ang= getAng.getAngle(new Line(1, 3), new Line(-1, 6));
		
		Line aline = new Line(1,3);
		Line bline = new Line(-1,3);
		double[] data = new double[10];
		int count = 0;
		/*
		 * data arc round axis!!! not in one quadrant!!
		 * fix this data its not right!!
		 * 
		 */
		for(double i=-5;i<0 ;i++){
			data[count] = Math.sqrt( (i*i) + aline.getY(i)*aline.getY(i) );
			count++;
		}
		for(double i=0;i<5;i++){
			data[count] = Math.sqrt( (i*i) + bline.getY(i)*bline.getY(i) );
			count++;
		}
//		double[] data 			
		Line[] lines = eval.getLines(data); 
		
		System.out.println();
		System.out.println(lines[0].toString());
		System.out.println(lines[0].toString());
		System.out.println(ang);
	}

}
