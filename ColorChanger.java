/**
 * @author AidanSawyer [Sourceforge: Daniels-ai, GitHub: atla5]
 * @description main class for date
 * @JColorChanger September 2013
 * @version Alpha
 */

//supporting classes
import ButtonPanel;
import InputPanel;

//baseline graphics 
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

// utilities and data structures
import java.util.ArrayList;
import java.util.Random;

//panel layouts
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

//action and event handling
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//gui components
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * Basic color changer for selecting desired color codes and gaining a better understanding rgba color values
 * and each components affect on output.
 * 
 */
public class ColorChanger {
	
	// variables/components to be used later. 
	private JPanel ccPanel = new JPanel();
	private Canvas canvas = new Canvas();
	private ArrayList<Color> colorList = new ArrayList<Color>();


	/**
	 * main class which displays the ColorChanger in its own frame
	 * @param ars String[] command line input unused
	 */
	public static void main(String[] args){
		JFrame f = new JFrame("JColorChanger");
		f.add(ColorChangerPanel());
		f.pack();
		f.setSize(575, 150);
		f.setVisible(true);
	}

	/**
	 * Brings all components of the JCC into one panel.
	 * -Makes it easier to format and add new additions
	 * @return ccPanel collection of all subpanels
	 *
	 */
	public static JPanel ColorChangerPanel(){
		
		ccPanel.setLayout(new GridLayout(1,3));
		ccPanel.add(mkCanvas());
		ccPanel.add(mkSlidePanel());
		ccPanel.add(mkButtonPanel());
		
		return ccPanel;
	}
	
	/**
	 * Constructs and returns the preview panel containing the color represented by all fields/sliders
	 * along with any future additions such as the hexadecimal representation or other code representations.
	 * @return lP left panel containing the color output and value
	 */
	public static JPanel mkCanvas(){
		JPanel lP = new JPanel(); 
//		lP.setLayout(new GridLayout(1,2));
		
		canvas.setSize(new Dimension(90,90));
		refresh();
		canvas.setVisible(true);
		
		//@ToDo create a JTextField containing code representation and maybe a drop-down for different types

		lP.add(canvas);
		
		return lP;
	}
	
	/**
	 * Returns the current number value of r, g, b, or a based on query
	 * @param x char 'r','g','b','a' #desired color component
	 * @return int value of value (0-255) for given color component
	 */
	public static int getColor(char x){
		if(x=='r'){
			return rSlide.getValue();
		}
		if(x=='g'){
			return gSlide.getValue();
		}
		if(x=='b'){
			return bSlide.getValue();
		}
		if(x=='a'){
			return aSlide.getValue();
		}else{
		return 0;
		}
	}
	
	/**
	 * Sets the int value (0,255) for desired color component
	 * @param x char 'r','g','b','a' #desired color component
	 * @param v int value you'd like to set that color component to
	 */
	public static void setColor(char x, int v){
		if(v > 255 | v < 0){
			//do nothing
		}else{
			if(x=='r'){
				rSlide.setValue(v);
			}
			if(x=='g'){
				gSlide.setValue(v);
			}
			if(x=='b'){
				bSlide.setValue(v);
			}
			if(x=='a'){
				if(v>100){
				
				}else{
					aSlide.setValue(v);
				}
			}else{}
		}
	}
	
	/**
	 * updates the preview color and TextField values to match current values
	 *   -(fields display the numerical value of the slider unless they are expressly input.
	 *     in which case the order of the logic is to change the slider, and then refresh)
	 */
	public static void refresh(){
		//update preview color and TextField values 
		canvas.setBackground(new Color(getColor('r'),getColor('g'),getColor('b'),getColor('a')));
		rTF.setText(""+getColor('r'));
		gTF.setText(""+getColor('g'));
		bTF.setText(""+getColor('b'));
		aTF.setText(""+getColor('a'));
		
	}

	public ArrayList<Color> getColorHistory(){
		return self.colorList;
	}

}