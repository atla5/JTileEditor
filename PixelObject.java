import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Object Class for each pixel on the screen.
 */
public class PixelObject extends Canvas{

	//store the color history of each pixel.
	ArrayList<Color> colorHistory = new ArrayList<Color>();

	//locations of x and y coordinates
	int x, y;

	//ID of the pixel in the array
	int id;


	/**
	 * Constructs a PixelObject with fed index, fresh white(f) on 
	 * transparent(b) canvas, and fresh colorHistory.
	 */
	public PixelObject(int i, int s){

	    //set the index to int fed into it
		this.id = i;
		
		//set size
		this.setSize(s,s);

	    //figure out the x and y from the index
		int numRows = 15;
		int numCols = 15;

		/*
		this.y = i/numRows;
		this.x = i%10;
		*/

	    //set the canvas's background to white
	    //and its foreground to transparent
		this.setBackground(new Color(255,255,255,0));
		this.setForeground(new Color(0,0,0,255));

	    //add white to the empty colorHistory
		colorHistory.add(new Color(255,255,255,0));

	}

	/**
	 * swaps current color with previous color in color history
	 * then returns the previous color 
	 */
	public Color swap(){

		Color oldColor = this.colorHistory.get(1);
		colorHistory.set( (colorHistory.size()-1) -1, 
			colorHistory.get( colorHistory.size()-1 ) );

		colorHistory.set( (colorHistory.size()-1), oldColor);
		return oldColor;
	}

	/**
	 * removes last color in color history and returns what's
	 * underneath.
	 */
	public Color peel(){
		//don't remove anything if it's down to one element.
		if(colorHistory.size() > 0){
			colorHistory.remove( colorHistory.size()-1 );
		}
		return colorHistory.get( colorHistory.size()-1 );
	}

	/**
	 * returns the current color. 
	 *   (for use as a dropper)
	 */
	public Color getCurrentColor(){
		return this.getForeground();
	}

	/**
	 * sets the pixel's canvas's foreground to the color, and
	 * adds the color to the colorHistory.
	 */
	public void setColor(Color c){
		this.setForeground(c);
		colorHistory.add(c);
	}


}
