/**
 * Construct and return a panel containing the JTextFields and Sliders necessary for user input
 * @return slidePan panel for user input
 */
public class InputPanel extends JPanel{
    private JSlider rSlide = new JSlider(0,255,0);
    private JSlider gSlide = new JSlider(0,255,0);
    private JSlider bSlide = new JSlider(0,255,0);
    private JSlider aSlide = new JSlider(0,255,0);
    private JTextField rTF = new JTextField("0",3);
    private JTextField gTF = new JTextField("0",3);
    private JTextField bTF = new JTextField("0",3);
    private JTextField aTF = new JTextField("0",3);
	
    public InputPanel(){

	// -- main code -- //
	super = new JPanel();
	super.setLayout(new GridLayout(4,1));
	
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
		gTF.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){setColor('g',Integer.parseInt(gTF.getText()));refresh();}});
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
		aP.add(aL);
		aP.add(aTF);
		aP.add(aSlide);

	// -- add each color's input panel to super (main InputPanel)-- //	
	super.add(rP);
	super.add(gP);
	super.add(bP);
	super.add(aP);
			
	}
}
