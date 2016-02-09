package manip;

public class Line {
	public double UNKNOWN = 0.1;
	private double grad;
	private double len;
	private double c;
	
	/*
	 * constructors for line using 2 points on line, (a,b).
	 * 
	 */
	
	public Line(double xa, double xb, double ya, double yb){
		gradient(xa, xb,ya,yb);
		length(xa,xb,ya,yb);
		C(xa,xb);
	}
	
	public Line(double _grad,double _length, double _c){
		grad = _grad;
		len = _length;
		c = _c;
	}
	public Line (double _grad, double _c){
		grad= _grad;
		c=_c;
		len= UNKNOWN;
	}
	/*
	 * private set gradient from construction
	 * 
	 */
	private void gradient(double xa, double xb, double ya, double yb){	
		grad= (ya-yb)/(xa-xb);	
	}
	
	private void length(double a,double b,double c,double d){
		len = Math.sqrt((b-a)*(b-a)+(c-d)*(c-d));	
	}
	private void C(double xa, double ya){
		c = ya + (xa*grad);
	}
	
	/*
	 * get methods
	 */
	public double getGradient(){
		return grad;
	}
	
	public double getLength(){
		return len;
	}
	
	public double getC(){
		return c;
	}
	
	public String toString(){
		return "Y = " + grad +"*X + " +c;
	}
	
	public double getX(double y ){
		return (y-c)/grad;
	}
	public double getY(double x ){
		return x*grad +c;
	}

}
