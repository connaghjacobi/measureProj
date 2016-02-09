package testClasses;

import javax.swing.JComponent;
import java.awt.geom.Line2D;

import manip.Line;

@SuppressWarnings("serial")
public class visualise extends JComponent{
	
	public visualise(Line a, Line b){
		Line2D linea = getLine(a);
		Line2D lineb = getLine(b);
	}
	
	private Line2D getLine(Line a){
		Line2D line = new Line2D.Double(0,a.getY(0),a.getX(0),0);
		return line;
	}
	
	private void paint(){
		
	}

}
