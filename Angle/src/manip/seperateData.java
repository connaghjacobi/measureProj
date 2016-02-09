package manip;

public class seperateData {
	
	public seperateData(){
		
	}
	/*
	 * current just splits data in half for lines and returns them in 2d array.
	 */
	
	public double[][] seperate(double[] xVals, double[] yVals){
	//TODO create Algorithm
		int half = (int)xVals.length/2;
		double[] aXVals = new double[half];
		double[] bXVals = new double[half];
		double[] ayVals = new double[half];
		double[] byVals = new double[half];
		for(int i = 0; i < xVals.length;i++){
			if(i <half){
				aXVals[i] = xVals[i];
				ayVals[i] = yVals[i];
			}else{
				bXVals[i-(half)]= xVals[i];
				byVals[i-(half)]=yVals[i];
			}
		}
		double[][] lists = {aXVals,bXVals,ayVals,byVals};
		return lists;
		
	}
}
