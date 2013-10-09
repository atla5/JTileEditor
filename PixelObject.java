/**
 * Object Class for each pixel on the screen.
 *
 */
public PixelObject{

	Canvas canvas;
	ArrayList<Color> colorHistory = new ArrayList<Color>();

	int indexNum;


	/**
	 * Constructs a PixelObject with fed index, fresh white(f) on 
	 * transparent(b) canvas, and fresh colorHistory.
	 *
	 */
	public PixelObject(int i){
	  //set the index to int fed
		this.index = i;
		
	  //set the canvas's background to black transparent
	  //and its foreground to opaque white	
		this.canvas.setBackground(new Color(0,0,0,255));
		this.canvas.setForeground(new Color(255,255,255,0));

	  //add white to the empty colorHistory
		colorHistory.add(new Color(255,255,255,0));

	}

	/**
	 * swaps current color with previous color in color history
	 * then returns the previous color 
	 */
	public Color swap(){
		Color oldColor = this.colorHistory.get(1);
		colorHistory.set( (colorHistory.size()-1) -1, colorHistory.get( colorHistory.size()-1 ) );
		colorHistory.set( (colorHistory.size()-1), oldColor)
		return oldColor;
	}

	/**
	 * removes last color in color history and returns what's
	 * underneath.
	 */
	public Color peel(){
		//don't remove anything if it's down to one element.
		if(colorHistory.size() > 1){
			colorHistory.remove( colorHistory.size()-1 );
		}
		return colorHistory.get( colorHistory.size()-1 );
	}

	/**
	 * returns the current color. 
	 *   (for use as a dropper)
	 */
	public Color getCurrentColor(){
		return colorHistory.get(0);
	}

	/**
	 * sets the pixel's canvas's foreground to the color, and
	 * adds the color to the colorHistory.
	 */
	public void setColor(Color c){
		canvas.setForeground(c);
		colorHistory.add(c);
	}


}