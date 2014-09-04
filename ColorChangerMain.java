/**
 * @author AidanSawyer [Sourceforge: aks5238, GitHub: atla5]
 * @description Basic color changer for rgba values
 * @date September 2013
 * @version Alpha
 */

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
public class ColorChangerMain{
	
	static private Color currentColor;
	
	// variables/components to be used later. [static in order to be read by refresh()]
	static JPanel ccPanel = new JPanel();
	static Canvas canvas = new Canvas();
	static JSlider rSlide = new JSlider(0,255,0);
	static JSlider gSlide = new JSlider(0,255,0);
	static JSlider bSlide = new JSlider(0,255,0);
	static JSlider aSlide = new JSlider(0,255,0);
	static JTextField rTF = new JTextField("0",3);
	static JTextField gTF = new JTextField("0",3);
	static JTextField bTF = new JTextField("0",3);
	static JTextField aTF = new JTextField("0",3);
	
	public ColorChangerMain(JTileEditorMain jtem){
		currentColor = new Color(0,0,0);
	}

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
		
		ccPanel.setLayout(new GridLayout(3,1));
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
	 * Construct and return a panel containing the JTextFields and Sliders necessary for user input
	 * @return slidePan panel for user input
	 */
	public static JPanel mkSlidePanel(){
		
		// -- main code -- //
		JPanel slidePan = new JPanel();
		slidePan.setLayout(new GridLayout(4,1));
		
		///// making the panels for each slider  ////
			
			// RED //
			JPanel rP = new JPanel();
			rP.setLayout(new GridLayout(1,3));
			JLabel rL = new JLabel("R: ");
			
			/*add a changelistener to the slider, call refresh.*/
			rSlide.addChangeListener(new ChangeListener(){ public void stateChanged(ChangeEvent e){ refresh();}});
			/*add an action listener to the text field to call setColor(val) and refresh() on enter*/
			rTF.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){setColor('r',Integer.parseInt(rTF.getText()));refresh();}});
			
			rP.add(rL);
			rP.add(rTF);
			rP.add(rSlide);
			
			// GREEN //
			JPanel gP = new JPanel();
			gP.setLayout(new GridLayout(1,3));
			JLabel gL = new JLabel("G: ");
			
			/*add a changelistener to the slider, call refresh.*/
			gSlide.addChangeListener(new ChangeListener(){ public void stateChanged(ChangeEvent e){ refresh();}});
			/*add an action listener to the text field to call setColor(val) and refresh() on enter*/
			gTF.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					setColor('g',Integer.parseInt(gTF.getText()));
					refresh();
				}
			});
			
			gP.add(gL);
			gP.add(gTF);
			gP.add(gSlide);
			
			// BLUE //
			JPanel bP = new JPanel();
			bP.setLayout(new GridLayout(1,3));
			JLabel bL = new JLabel("B: ");
			
			/*add a changelistener to the slider, call refresh.*/
			bSlide.addChangeListener(new ChangeListener(){ public void stateChanged(ChangeEvent e){ refresh();}});
			/*add an action listener to the text field to call setColor(val) and refresh() on enter*/
			bTF.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){setColor('b',Integer.parseInt(bTF.getText()));refresh();}});
			
			bP.add(bL);
			bP.add(bTF);
			bP.add(bSlide);
			
			// ALPHA //
			JPanel aP = new JPanel();
			aP.setLayout(new GridLayout(1,3));
			JLabel aL = new JLabel("A: ");
			
			/*add a changelistener to the slider, call refresh.*/
			aSlide.addChangeListener(new ChangeListener(){ public void stateChanged(ChangeEvent e){ refresh();}});
			/*add an action listener to the text field to call setColor(val) and refresh() on enter*/
			aTF.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){setColor('a',Integer.parseInt(aTF.getText()));refresh();}});
			
			/*
			aP.add(aL);
			aP.add(aTF);
			aP.add(aSlide);
			*/
		
		// -- adding each color's slide panel to the main slide panel-- //		
		slidePan.add(rP);
		slidePan.add(gP);
		slidePan.add(bP);
		
		return slidePan;
		
	}
	
	/**
	 * Constructs and returns button panel and the buttons necessary for color manipulation
	 * @return butPan button panel
	 */
	public static JPanel mkButtonPanel(){
		
		// -- create panel with basic layout -- //
		JPanel butPan = new JPanel();
		butPan.setLayout(new GridLayout(4,2));		
		
		///// - construct buttons - /////
		
			// Random - [make a random color]
			JButton randomB = new JButton("Random");
			randomB.setToolTipText("pick random color");
			randomB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Random rand = new Random();
					int r = rand.nextInt(255);
					int g = rand.nextInt(255);
					int b = rand.nextInt(255);
					setColor('r',r);
					setColor('g',g);
					setColor('b',b);
					refresh();
				}
			});
			
			// GreyScale - [average all RGB values to create a grey]
			JButton greyB = new JButton("GreyScale");
			greyB.setToolTipText("Convert to b/w");
			greyB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(getColor('r') == getColor('g') && getColor('g') == getColor('b')){
						
					}
					int r_old = getColor('r');
					int g_old = getColor('g');
					int b_old = getColor('b');
					int sum = r_old+g_old+b_old;
					int avg = sum/3;
					setColor('r',avg);
					setColor('g',avg);
					setColor('b',avg);
					refresh();
				}
			});
			
			// Darken - [decrease all RGB values to make a darker version of the color]
			JButton darkB = new JButton("Darken");
			darkB.setToolTipText("Create darken version of current color");
			darkB.addActionListener(new ActionListener(){
				int x = 5;
				public void actionPerformed(ActionEvent e){
					setColor('r',getColor('r')-x);
					setColor('g',getColor('g')-x);
					setColor('b',getColor('b')-x);
					refresh();
				}
			});
			
			// Lighten - [increase all RGB values to make a lighter version of the color]
			JButton lightB = new JButton("Lighten");
			lightB.setToolTipText("Creater lighter version of current color");
			lightB.addActionListener(new ActionListener(){
				int x = 5;
				public void actionPerformed(ActionEvent e){
					setColor('r',getColor('r')+x);
					setColor('g',getColor('g')+x);
					setColor('b',getColor('b')+x);
					refresh();
				}
			});
			
			// Warm - [make the color 'warmer' by increasing R and decreasing B]
			JButton warmB = new JButton("Warm");
			warmB.setToolTipText("Increase R, Decrease B ");
			warmB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int x = 6;
					setColor('r',getColor('r')+x);
					setColor('b',getColor('b')-x);
					refresh();
				}
			});
			
			// Cool - [make the color 'colder' by decreasing R and increasing B]
			JButton coolB = new JButton("Cool");
			coolB.setToolTipText("Decrease R, Increase B");
			coolB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int x = 6;
					setColor('r',getColor('r')-x);
					setColor('b',getColor('b')+x);
					refresh();
				}
			});

			// Eraser - [sets the color to white]
			//@ToDo: account for colors other than white. 
			JButton eraseB = new JButton("Eraser");
			eraseB.setToolTipText("Sets color to white");
			eraseB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					setColor('r',255);
					setColor('g',255);
					setColor('b',255);
					refresh();
				}
			});
			
			 // Swap - [saves series of colors last used and sets to previous].
			 // @ToDo MAKE FUNCTIONAL
			 final ArrayList<Color> colorHistory= new ArrayList<Color>();
			 colorHistory.add(new Color(255,255,255));
			 JButton swapB = new JButton("Swap");
			 swapB.setToolTipText("Save color in list #currently nothing");
			 swapB.addActionListener(new ActionListener(){
			 	public void actionPerformed(ActionEvent e){
			 		colorHistory.add(new Color(getColor('r'),getColor('g'),getColor('b'),getColor('a')));
			 		Color swapColor = colorHistory.get(colorHistory.size()-1);
			 		//@ToDo: display colors visibly and set color to that when clicked
			 	}
			 });
			

			// CUSTOM BUTTON - [whatever you want] 
			/* if you wish to add your own buttons, please specify your authorship of them 
			 * while retaining my authorship of the program itself.
			 */
			
			
		// -- adding buttons to panel -- //
		butPan.add(randomB);
		butPan.add(greyB);
		butPan.add(darkB);
		butPan.add(lightB);
		butPan.add(coolB);
		butPan.add(warmB);
		//butPan.add(eraseB);
		//butPan.add(swapB);

		return butPan;
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
		canvas.setForeground(new Color(getColor('r'),getColor('g'),getColor('b'),getColor('a')));
		currentColor = new Color(getColor('r'),getColor('g'),getColor('b'),getColor('a'));
		rTF.setText(""+getColor('r'));
		gTF.setText(""+getColor('g'));
		bTF.setText(""+getColor('b'));
	}

}