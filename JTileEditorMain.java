import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class JTileEditorMain{
	
	public Color currentColor;
	
	public static void main(String[] args){
		
		JTileEditorMain jtem = new JTileEditorMain();
		JFrame frame = new JFrame("JTileEditor");
		
		int x = 25, y = 25;
		JPanel panel = new JPanel(new GridLayout(25,25));

		int i = 0;
		for(x = 25; x>0; x--){
			for(y = 25; y>0; y--){
				PixelObject p = new PixelObject(i,10);
				panel.add(p);
				i++;
			}
		}
		
		frame.add(panel);
		frame.pack();
		frame.setSize(500,400);
		ColorChangerMain.main(args);
		
		frame.setVisible(true);
		
	}
	
}
