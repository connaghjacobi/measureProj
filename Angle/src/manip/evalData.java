package manip;

import java.util.ArrayList;

public class evalData {
	
	private double[] xHolders;
	private double[] yHolders;
	private seperateData data;
	
	/*
	 * class to evaluate incoming data
	 * 
	 */
	
	public evalData(){
		data = new seperateData();
	}
	
	/*
	 * splits data into lines then creates 2 lines from the data
	 * returns an array containing 2 lines
	 */
	
	public Line[] getLines(double[] readings){
		int len = readings.length;
		xHolders = new double[len];
		yHolders = new double[len];
		holders(readings);
		double[][] linesData = data.seperate(xHolders, yHolders) ;
		Line Aline = calcLine(linesData[0],linesData[2]);
		Line Bline = calcLine(linesData[1],linesData[3]);
		Line[] lines = {Aline,Bline};
		return lines;
	}
	
	/*
	 * currently splits data into half for test data before implementation of the data separating algoithm 
	 * 
	 */
	
	private void holders(double[] readings){
		for(int i = 0; i <readings.length;i++){
			xHolders[i]=getX(readings[i], 45 +i*10);
			yHolders[i]=getY(readings[i], 45 +i*10);
		}
	}
	/*
	 * get X,y value from distance measure and angle.
	 */
	private double getX(double val, int _ang){
		double ang = _ang*(Math.PI/180);
		double x = val *Math.cos((double )ang);
		return x;
	}
	private double getY(double val, int _ang){
		double ang = _ang*(Math.PI/180);
		double y = val *Math.sin((double )ang);
		return y;		
	}
	/*
	 * calculate the line from given Xvalues 
	 * 
	 */	
	
	private Line calcLine(double[] xVals, double[] yVals){
		ArrayList<Double> grads = new ArrayList<Double>();
		for(int i = 0; i<xVals.length;i++){
			for(int j=i+1;j<yVals.length;j++){
				double g =calcGrad(xVals[i],xVals[j],yVals[i],yVals[j]);
				grads.add(g);
				
			}		
		}
		double sum =0;
		
		for(int i = 0;i<grads.size();i++){
			sum = sum +grads.get(i);	
		}
		
		double grad = sum/grads.size();
		double c = calcC(grad, xVals[1],xVals[2]);		
		return new Line(grad, c);
		}
	/*
	 * takes 2 points and calculates gradient of line between them 
	 */
	private double calcGrad(double xa,double xb,double ya, double yb){
		double grad =((ya-yb)/(xa-xb));
		return grad;
	}
	/*
	 * calculates the Y intercept of the line.
	 */
	private double calcC(double grad, double x, double y){
		return y-x*grad;
	}
}
