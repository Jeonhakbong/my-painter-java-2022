import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	Figure[] fList; // figure list.
	// ArrayList<Figure> fList;
	int fMax;
	int fNum;
	
	public MyFrame(String title) {
		super(title);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		fMax = 10;
		fNum = 0;
		fList = new Figure[fMax]; 
	}
	
	@Override 
	public void paint(Graphics g) {
		super.paint(g);
		for(int i = 0 ; i < fNum; i++) {
			fList[i].draw(g);
		}
	}
	
	public void add(Figure f) {
		fList[fNum++] = f;
	}
}