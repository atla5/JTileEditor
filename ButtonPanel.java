/**
 * Constructs and returns button panel and the buttons necessary for color manipulation
 */
	public class ButtonPanel extends JPanel{

	    public ButtonPanel(){
			
		// -- set basic layout -- //
		super.setLayout(new GridLayout(4,2));		
		
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
			    int a = rand.nextInt(100);
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
			swapB.setToolTipText("Save color in list #currently nothing");
			swapB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				    colorHistory = ColorChanger.getColorHistory();
				    colorHistory.add(new Color(getColor('r'),getColor('g'),getColor('b'),getColor('a')));
				    Color swapColor = colorHistory.get(colorHistory.size()-1);
				    }
				 });
				

			// CUSTOM BUTTON - [whatever you want] 
			/* if you wish to add your own buttons, please specify your authorship of them 
			 * while retaining my authorship of the program itself.
			 */
				
				
		// -- adding buttons to panel -- //
		super.add(randomB);
		super.add(greyB);
		super.add(darkB);
		super.add(lightB);
		super.add(coolB);
		super.add(warmB);
		super.add(eraseB);
		super.add(swapB);
		
	    }
	}